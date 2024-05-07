import java.util.List;

public class Simulation {
	private int runningTimes;
	private List<String> aircraftInstructions;
	private AircraftFactory factory;

	public Simulation()
	{
		factory = AircraftFactory.getInstance();
	}

	public Flyable setUpAircraft(String str)
	{
		String[] instructions = str.split(" ");

		if (instructions.length < 5) {
			throw new IllegalArgumentException("Invalid instruction format: " + str);
		}

		String type = instructions[0];
		String name = instructions[1];
		int longitude = Integer.parseInt(instructions[2]);
		int latitude = Integer.parseInt(instructions[3]);
		int height = Integer.parseInt(instructions[4]);

		Coordinates coordinates = new Coordinates(longitude, latitude, height);

		return (factory.newAircraft(type, name, coordinates));
	}

	public void startSimulation(List<String> fileContent) {
		if (fileContent == null) {
			throw new IllegalArgumentException("Invalid file content: Set to null");
		}

		try {
			runningTimes = Integer.parseInt(fileContent.get(0));

			if (runningTimes <= 0) {
				throw new IllegalArgumentException(runningTimes + " is not a positive number");
			}

			aircraftInstructions = fileContent.subList(1, fileContent.size());
			WeatherTower tower = new WeatherTower();

			for (String str : aircraftInstructions)
			{
				Flyable plane = setUpAircraft(str);

				tower.register(plane);
				plane.registerTower(tower);
			}

			for (int row = 0; row < runningTimes; row++)
			{
				WriteFile.writeToFile("\nSimulation: (" + row + ")");
				tower.changeWeather();
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid number format: " + e.getMessage());
		}
	}
}
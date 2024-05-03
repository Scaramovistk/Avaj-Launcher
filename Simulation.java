import java.util.List;

public class Simulation {
	private int runningTimes;
	private List<String> aircraftInstructions;

	public Simulation(List<String> fileContent) {
		if (fileContent == null) {
			throw new IllegalArgumentException("Invalid file content: Set to null");
		}

		try {
			runningTimes = Integer.parseInt(fileContent.get(0));

			if (runningTimes <= 0) {
				throw new IllegalArgumentException(runningTimes + " is not a positive number");
			}

			aircraftInstructions = fileContent.subList(1, fileContent.size());

			for (String str : aircraftInstructions) {
				String[] instructions = str.split(" ");
				if (instructions.length < 5) {
					throw new IllegalArgumentException("Invalid instruction format: " + str);
				}

				String type = instructions[0];
				String name = instructions[1];
				int longitude = Integer.parseInt(instructions[2]);
				int latitude = Integer.parseInt(instructions[3]);
				int height = Integer.parseInt(instructions[4]);

				AircraftFactory factory = AircraftFactory.getInstance();
				Coordinates coordinates = new Coordinates(longitude, latitude, height);
				Flyable plane = factory.newAircraft(type, name, coordinates);
				//Should it be shorter ?

				plane.updateConditions();

				// Check Type
				// Check Name
				// Check Coordinates
				
				// Build Aircraft ?

				// System.out.println("Type: " + type);

				// System.out.println("Type: " + type);
				// System.out.println("Name: " + name);
				// System.out.println("Longitude: " + longitude);
				// System.out.println("Latitude: " + latitude);
				// System.out.println("Height: " + height);
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid number format: " + e.getMessage());
		}
	}
}
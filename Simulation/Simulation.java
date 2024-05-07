package Simulation;

import File.*;
import Interface.*;
import Aircraft.*;
import Weather.*;
import Tower.*;
import java.util.List;

public class Simulation {
	private int runningTimes;
	private List<String> aircraftInstructions;
	private AircraftFactory factory;
	private WeatherTower tower;

	public Simulation()
	{
		factory = AircraftFactory.getInstance();
		tower = new WeatherTower();
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

	public void registerAircrafts(List<String> fileContent) {
		if (fileContent == null) {
			throw new IllegalArgumentException("Invalid file content: Set to null");
		}

		try {
			runningTimes = Integer.parseInt(fileContent.get(0));

			if (runningTimes <= 0) {
				throw new IllegalArgumentException(runningTimes + " is not a positive number");
			}

			aircraftInstructions = fileContent.subList(1, fileContent.size());

			for (String str : aircraftInstructions)
			{
				Flyable plane = setUpAircraft(str);

				tower.register(plane);
				plane.registerTower(tower);
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid number format: " + e.getMessage());
		}
	}

	public void runSimulation()
	{
		for (int row = 0; row < runningTimes; row++)
		{
			WriteFile.writeToFile("\nSimulation: (" + row + ")");
			tower.changeWeather();
		}
	}
}
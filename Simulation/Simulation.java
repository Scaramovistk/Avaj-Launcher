package Simulation;

import File.*;
import Interface.*;
import Aircraft.*;
import Tower.*;
import Exception.*;

import java.util.LinkedList;
import java.util.List;

public class Simulation {
	private int runningTimes;
	private List<Flyable> AircraftList;
	private AircraftFactory factory;
	private WeatherTower tower;

	public Simulation()
	{
		factory = AircraftFactory.getInstance();
		tower = new WeatherTower();
		AircraftList = new LinkedList<>();
	}

	public Flyable setUpAircraft(String str) throws IncorrectFileContentException, IncorrectClassInitialisationExeption
	{
		String[] instructions = str.split(" ");

		if (instructions.length < 5) {
			throw new IncorrectFileContentException("Invalid instruction format: " + str);
		}

		String type = instructions[0];
		String name = instructions[1];
		int longitude = Integer.parseInt(instructions[2]);
		int latitude = Integer.parseInt(instructions[3]);
		int height = Integer.parseInt(instructions[4]);

		Coordinates coordinates = new Coordinates(longitude, latitude, height);

		return (factory.newAircraft(type, name, coordinates));
	}

	public void registerAircrafts(List<String> fileContent) throws IncorrectFileContentException, IncorrectClassInitialisationExeption
	{
		List<String> aircraftInstructions;

		if (fileContent == null) {
			throw new IncorrectFileContentException("Set to null");
		}
		runningTimes = Integer.parseInt(fileContent.get(0));
		if (runningTimes <= 0) {
			throw new IncorrectFileContentException(runningTimes + " is not a positive number");
		}
		aircraftInstructions = fileContent.subList(1, fileContent.size());
		for (String str : aircraftInstructions)
			AircraftList.add(setUpAircraft(str));
		for (Flyable plane : AircraftList)
		{
			tower.register(plane);
			plane.registerTower(tower);
		}
	}

	public void runSimulation()
	{
		for (int row = 0; row < runningTimes; row++)
		{
			WriteFile.writeToFile("\nSimulation: (" + row + ")");
			tower.changeWeather();
		}
		WriteFile.closeFile();
	}
}

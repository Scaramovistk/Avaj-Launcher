package be._42belgium.avaj.simulator;

import be._42belgium.avaj.file.WriteFile;
import be._42belgium.avaj.flyable.Flyable;
import be._42belgium.avaj.aircraft.AircraftFactory;
import be._42belgium.avaj.tower.WeatherTower;
import be._42belgium.avaj.exception.IncorrectFileContentException;
import be._42belgium.avaj.exception.IncorrectClassInitialisationException;

import java.util.LinkedList;
import java.util.List;

public class Simulation
{
	private int runningTimes;
	private List<Flyable> aircraftList;
	private AircraftFactory factory;
	private WeatherTower tower;

	public Simulation()
	{
		factory = AircraftFactory.getInstance();
		tower = new WeatherTower();
		aircraftList = new LinkedList<>();
	}

	public Flyable setUpAircraft(String str)
		throws IncorrectFileContentException, IncorrectClassInitialisationException
	{
		String[] instructions = str.trim().split("\\s+");
		if (instructions.length != 5)
			throw new IncorrectFileContentException("Invalid instruction format: " + str);

		String type = instructions[0];
		String name = instructions[1];
		int longitude;
		int latitude;
		int height;

		try {
			longitude = Integer.parseInt(instructions[2]);
			latitude = Integer.parseInt(instructions[3]);
			height = Integer.parseInt(instructions[4]);
		} catch (NumberFormatException e) {
			throw new IncorrectFileContentException("Invalid number in instruction: " + str);
		}

		return (factory.newAircraft(type, name, longitude, latitude, height));
	}

	public void registerAircrafts(List<String> fileContent)
		throws IncorrectFileContentException, IncorrectClassInitialisationException
	{
		if (fileContent == null || fileContent.isEmpty())
			throw new IncorrectFileContentException("Scenario file is empty");

		String header = fileContent.get(0).trim();
		if (header.isEmpty())
			throw new IncorrectFileContentException("Missing simulation count on first line");

		try {
			runningTimes = Integer.parseInt(header);
		} catch (NumberFormatException e) {
			throw new IncorrectFileContentException("First line must be a positive integer: " + header);
		}
		if (runningTimes <= 0)
			throw new IncorrectFileContentException(runningTimes + " is not a positive number");

		List<String> aircraftInstructions = fileContent.subList(1, fileContent.size());
		for (String str : aircraftInstructions)
		{
			if (str.trim().isEmpty())
				continue;
			aircraftList.add(setUpAircraft(str));
		}

		for (Flyable plane : aircraftList)
			plane.registerTower(tower);
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

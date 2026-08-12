package be._42belgium.avaj.aircraft;

import be._42belgium.avaj.exception.IncorrectClassInitialisationException;
import be._42belgium.avaj.flyable.Flyable;

public class AircraftFactory
{
	private static AircraftFactory instance;
	private static long idCount;

	private AircraftFactory()
	{
		idCount = 0;
	}

	public static AircraftFactory getInstance()
	{
		if (instance == null)
			instance = new AircraftFactory();
		return (instance);
	}

	public Flyable newAircraft(String p_type, String p_name, int longitude, int latitude, int height)
		throws IncorrectClassInitialisationException
	{
		Coordinates coordinates = new Coordinates(longitude, latitude, height);
		return newAircraft(p_type, p_name, coordinates);
	}

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)
		throws IncorrectClassInitialisationException
	{
		if (p_type == null || p_name == null || p_coordinates == null)
			throw new IllegalArgumentException("Invalid argument: Set to null");

		switch (p_type)
		{
			case "Balloon":
				return new Balloon(idCount++, p_name, p_coordinates);
			case "JetPlane":
				return new JetPlane(idCount++, p_name, p_coordinates);
			case "Helicopter":
				return new Helicopter(idCount++, p_name, p_coordinates);
			default:
				throw new IllegalArgumentException("Invalid argument: Type " + p_type + " dont exist");
		}
	}
}

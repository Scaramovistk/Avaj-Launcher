package be._42belgium.avaj.aircraft;

import be._42belgium.avaj.exception.IncorrectClassInitialisationException;

public class Helicopter extends Aircraft
{
	public Helicopter(long p_id, String p_name, Coordinates p_coordinate) throws IncorrectClassInitialisationException
	{
		super(p_id, p_name, p_coordinate);
		type = "Helicopter";
	}

	public void updateConditions()
	{
		String msg = "";
		long longi = coordinates.getLongitude();
		long lati = coordinates.getLatitude();
		long heigh = coordinates.getHeight();

		switch (weatherTower.getWeather(coordinates))
		{
			case "SUN":
				longi += 10;
				heigh += 2;
				msg = ": This is hot.";
				break;
			case "RAIN":
				longi += 5;
				msg = ": Damn raining again, as 99% of the days in Belgium.";
				break;
			case "FOG":
				longi += 1;
				msg = ": Turn lights on, we have no visibility.";
				break;
			case "SNOW":
				heigh -= 12;
				msg = ": My rotor is going to freeze!";
				break;
		}

		int newLon = Coordinates.clampCoordinate(longi);
		int newLat = Coordinates.clampCoordinate(lati);
		int newHeight = Coordinates.clampHeight(heigh);
		coordinates = new Coordinates(newLon, newLat, newHeight);
		this.sendStatus(msg, newHeight);
	}
}

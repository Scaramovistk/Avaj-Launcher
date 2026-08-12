package be._42belgium.avaj.aircraft;

import be._42belgium.avaj.exception.IncorrectClassInitialisationException;

public class Balloon extends Aircraft
{
	public Balloon(long p_id, String p_name, Coordinates p_coordinate) throws IncorrectClassInitialisationException
	{
		super(p_id, p_name, p_coordinate);
		type = "Balloon";
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
				longi += 2;
				heigh += 4;
				msg = ": Let's enjoy the good weather and take some pics.";
				break;
			case "RAIN":
				heigh -= 5;
				msg = ": Damn you rain! You messed up my Balloon.";
				break;
			case "FOG":
				heigh -= 3;
				msg = ": Looks like Snoop Dogg is in the area.";
				break;
			case "SNOW":
				heigh -= 15;
				msg = ": It's snowing. We're gonna crash.";
				break;
		}

		int newLon = Coordinates.clampCoordinate(longi);
		int newLat = Coordinates.clampCoordinate(lati);
		int newHeight = Coordinates.clampHeight(heigh);
		coordinates = new Coordinates(newLon, newLat, newHeight);
		this.sendStatus(msg, newHeight);
	}
}

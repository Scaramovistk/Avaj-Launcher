package be._42belgium.avaj.aircraft;

import be._42belgium.avaj.exception.IncorrectClassInitialisationException;

public class JetPlane extends Aircraft
{
	public JetPlane(long p_id, String p_name, Coordinates p_coordinate) throws IncorrectClassInitialisationException
	{
		super(p_id, p_name, p_coordinate);
		type = "JetPlane";
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
				lati += 10;
				heigh += 2;
				msg = ": Some sunshine is good for the soul, but I always make sure I wear a big hat.";
				break;
			case "RAIN":
				lati += 5;
				msg = ": It's raining. Better watch out for lightings.";
				break;
			case "FOG":
				lati += 1;
				msg = ": When life is foggy, path is unclear and mind is dull, remember your breath.";
				break;
			case "SNOW":
				heigh -= 7;
				msg = ": OMG! Winter is coming!";
				break;
		}

		int newLon = Coordinates.clampCoordinate(longi);
		int newLat = Coordinates.clampCoordinate(lati);
		int newHeight = Coordinates.clampHeight(heigh);
		coordinates = new Coordinates(newLon, newLat, newHeight);
		this.sendStatus(msg, newHeight);
	}
}

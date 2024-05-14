package Aircraft;

import Exception.IncorrectClassInitialisationExeption;

public class Helicopter extends Aircraft
{

	public Helicopter(long p_id, String p_name, Coordinates p_coordinate) throws IncorrectClassInitialisationExeption
	{
		super(p_id, p_name, p_coordinate);
		type = "Helicopter";
	}

	public void updateConditions()
	{
		String msg = "";
		int longi = coordinates.getLongitude();
		int lati = coordinates.getLatitude();
		int heigh = coordinates.getHeight();

		switch(weatherTower.getWeather(coordinates))
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

		if (heigh > 100)
			heigh = 100;
		else if (heigh < 0)
			heigh = 0;
		coordinates = new Coordinates(longi, lati, heigh);
		this.sendStatus(msg ,heigh);
	}
}

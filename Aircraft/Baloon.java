package Aircraft;

import Exception.IncorrectClassInitialisationExeption;

public class Baloon extends Aircraft
{
	public Baloon(long p_id, String p_name, Coordinates p_coordinate) throws IncorrectClassInitialisationExeption
	{
		super(p_id, p_name, p_coordinate);
		type = "Baloon";
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
			longi += 2;
			heigh += 4;
			msg = ": Let's enjoy the good weather and take some pics.";
			break;
			case "RAIN":
			heigh -= 5;
			msg = ": Damn you rain! You messed up my baloon.";
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
		if (heigh > 100)
			heigh = 100;
		else if (heigh < 0)
			heigh = 0;
		coordinates = new Coordinates(longi, lati, heigh);
		this.sendStatus(msg, heigh);
	}
}

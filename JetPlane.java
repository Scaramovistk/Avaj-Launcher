public class JetPlane extends Aircraft
{
	public JetPlane(long p_id, String p_name, Coordinates p_coordinate)
	{
		super(p_id, p_name, p_coordinate);
		type = "JetPlane";
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

		if (heigh > 100)
			heigh = 100;
		else if (heigh < 0)
			heigh = 0;
		coordinates = new Coordinates(longi, lati, heigh);
		this.sendStatus(msg, heigh);
	}
}

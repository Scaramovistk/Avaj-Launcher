public class Baloon extends Aircraft
{
	public Baloon(long p_id, String p_name, Coordinates p_coordinate)
	{
		super(p_id, p_name, p_coordinate);
		type = "Baloon";
	}

	public void updateConditions()
	{
		String msg;
		int longi = cordernates.getLongitude();
		int lati = cordernates.getLatitude();
		int heigh = cordernates.getHeight();

		switch(weatherTower.getCurrentWeather(coordinates))
		{
			case "SUN"
				longi += 2;
				hiegh += 4;
				msg = "Let's enjoy the good weather and take some pics.";
				break;
			case "RAIN"
				hiegh -= 5;
				msg = "Damn you rain! You messed up my baloon.";
				break;
			case "Fog"
				hiegh -= 3;
				msg = "Looks like SnoopDog is in the area.";
				break;
			case "SNOW"
				heigh -= 15;
				msg = "It's snowing. We're gonna crash.";
				break;
		}

		coordinates = new Coordinates(longi, lati, hiegh);
		msg = getName + " :" + msg;

		/**
		 * ◦ SUN - Longitude increases with 2, Height increases with 4
		◦ RAIN - Height decreases with 5
		◦ FOG - Height decreases with 3
		◦ SNOW - Height decreases with 15
		 */
	}
}

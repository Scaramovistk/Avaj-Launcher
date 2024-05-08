package Weather;

import java.util.Random;
import Aircraft.*;

public class WeatherProvider
{
	private static WeatherProvider instance;
	private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

	private WeatherProvider() {}

	public static WeatherProvider getInstance()
	{
		if (instance == null)
			instance = new WeatherProvider();
		return (instance);
	}

	public static String getCurrentWeather(Coordinates cord)
	{
		int nbr = new Random().nextInt(4);

		nbr = cord.getHeight() > 60 ? 2 : nbr;
		nbr = cord.getHeight() > 80 ? 0 : nbr;
		return (weather[(nbr % 4)]);
	}
}

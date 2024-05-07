package Weather;

import java.util.Random;
import Aircraft.*;

/**
 * A class for making Weather Provider
 */
public class WeatherProvider
{
	private static WeatherProvider instance;
	private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

	/**
	 * Private Constructor making it a Singleton
	 */
	private WeatherProvider()
	{
	}

	/**
	 * Set and get the global instance
	 * @return a instance for a global object
	 */
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

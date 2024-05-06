/**
 * A class for making Weather Provider
 */
public class WeatherProvider extends Tower
{
	private static WeatherProvider instance;
	private String[] weather;

	/**
	 * Constructs a WeatherProvider object and sets the weather types
	 */
	private static WeatherProvider()
	{
		weather = {"SUN", "RAIN", "FOG", "SNOW"};
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
		int nbr = new Random().nextInt();

		nbr = cord.getHeight > 60 ? 2 : nbr;
		return (weather[nbr % 3]);
	}
}

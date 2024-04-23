/**
 * A class for making Weather Provider
 */
public class WeatherProvider extends Tower
{
	private static WeatherProvider instance;
	private String[] weather;

	/**
	 * Constructs a WeatherProvider object
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
}

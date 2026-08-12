package be._42belgium.avaj.weather;

import java.util.Random;
import be._42belgium.avaj.aircraft.Coordinates;

public class WeatherProvider
{
	private static WeatherProvider instance;
	private String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

	private WeatherProvider() {}

	public static WeatherProvider getInstance()
	{
		if (instance == null)
			instance = new WeatherProvider();
		return (instance);
	}

	public String getCurrentWeather(Coordinates cord)
	{
		int nbr = new Random().nextInt(4);
		nbr = cord.getHeight() > 60 ? 2 : nbr;
		nbr = cord.getHeight() > 80 ? 0 : nbr;
		return (weather[(nbr % 4)]);
	}
}

public class WeatherTower
{
	public String getWeather(Coordinates p_coordinates)
	{
		return (WeatherProvider.getCurrentWeather());
	}

	public void changeWeather()
	{
		conditionChanged();
	}
}
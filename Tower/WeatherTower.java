package Tower;
import Tower.*;
import Aircraft.*;
import Weather.*;

public class WeatherTower extends Tower
{
	public String getWeather(Coordinates p_coordinates)
	{
		return (WeatherProvider.getCurrentWeather(p_coordinates));
	}

	public void changeWeather()
	{
		this.conditionChanged();
	}
}
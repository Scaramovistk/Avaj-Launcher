package be._42belgium.avaj.tower;

import be._42belgium.avaj.aircraft.Coordinates;
import be._42belgium.avaj.weather.WeatherProvider;

public class WeatherTower extends Tower
{
	public String getWeather(Coordinates p_coordinates)
	{
		return (WeatherProvider.getInstance().getCurrentWeather(p_coordinates));
	}

	public void changeWeather()
	{
		this.conditionChanged();
	}
}

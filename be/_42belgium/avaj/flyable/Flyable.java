package be._42belgium.avaj.flyable;

import be._42belgium.avaj.tower.WeatherTower;

public abstract class Flyable
{
	protected WeatherTower weatherTower;

	public abstract void updateConditions();
	public abstract String getName();

	public void registerTower(WeatherTower p_tower)
	{
		this.weatherTower = p_tower;
		p_tower.register(this);
	}
}

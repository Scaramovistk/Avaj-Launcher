public abstract class Flyable
{
	protected WeatherTower weatherTower;

	public abstract void updateConditions();

	public abstract String getName();

	public void registerTower(WeatherTower p_tower)
	{
		weatherTower = p_tower;
	}
}
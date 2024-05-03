public abstract class Flyable
{
	//This is subscriber class
	protected WeatherTower weatherTower;

	public abstract void updateConditions();

	public void registerTower(WeatherTower p_tower)
	{

	}
}

// protected Aircraft(String type, Flyable flyable)
// {
// 	this.factory = AircraftFactory.getInstance();
// }
// protected final AircraftFactory factory;
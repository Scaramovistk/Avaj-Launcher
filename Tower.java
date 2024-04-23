import java.util.List;

/**
 * Class that will manage the Aircrafts
 */
public class Tower
{
	private List<Flyable> observers;

	/**
	 * Register a Flyable object in the Tower
	 * @param p_flyable is the Flyable object that will be register in the Tower
	 */
	public void register(Flyable p_flyable)
	{
		if (p_flyable != null)
		{
			observers.add(p_flyable);
			String name = "Baloon#B1(1)"; //get the name from the flyable
			System.out.print("Tower says: " + name + " registered to weather tower.");
		}
	}

	/**
	 * Unregister a Flyable object in the Tower
	 * @param p_flyable is the Flyable object that will be unregister in the Tower
	 */
	public void unregister(Flyable p_flyable)
	{
		if (!observers.remove(p_flyable))
		{
			String name = "Baloon#B1(1)";
			System.out.print("Tower says: " + name + " unregistered from weather tower.");
		}
	}

	/**
	 * 
	 */
	protected void conditionChanged()
	{

	}
}

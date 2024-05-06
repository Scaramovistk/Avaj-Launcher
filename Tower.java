import java.util.List;
import java.util.LinkedList;

//This is the publisher class
/**
 * Class that will manage the Aircrafts
 */
public class Tower
{
	private List<Flyable> observers = new LinkedList<>();

	/**
	 * Register a Flyable object in the Tower
	 * @param p_flyable is the Flyable object that will be register in the Tower
	 */
	public void register(Flyable p_flyable)
	{
		if (p_flyable != null)
		{
			observers.add(p_flyable);
			System.out.print("Tower says: " + p_flyable.getName() + " registered to weather tower.\n");
		}
	}

	/**
	 * Unregister a Flyable object in the Tower
	 * @param p_flyable is the Flyable object that will be unregister in the Tower
	 */
	public void unregister(Flyable p_flyable)
	{
		if (observers.remove(p_flyable))
		{
			System.out.print("Tower says: " + p_flyable.getName() + " unregistered from weather tower.\n");
		}
		else
			throw new IllegalArgumentException("Invalid argument: Element cannot be remove because it dosent exist");
	}

	/**
	 * 
	 */
	protected void conditionChanged()
	{

	}
}

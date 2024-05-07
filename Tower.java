import java.util.List;
import java.util.LinkedList;

//This is the publisher class
/**
 * Class that will manage the Aircrafts
 */
public class Tower
{
	private List<Flyable> observers = new LinkedList<>();
	private List<Flyable> unregistered = new LinkedList<>();

	/**
	 * Register a Flyable object in the Tower
	 * @param p_flyable is the Flyable object that will be register in the Tower
	 */
	public void register(Flyable p_flyable)
	{
		if (p_flyable != null && !observers.contains(p_flyable))
		{
			observers.add(p_flyable);
			WriteFile.writeToFile("Tower says: " + p_flyable.getName() + " registered to weather tower.");
		}
	}

	/**
	 * Unregister a Flyable object in the Tower
	 * @param p_flyable is the Flyable object that will be unregister in the Tower
	 */
	public void unregister(Flyable p_flyable)
	{
		if (observers.contains(p_flyable))
		{
			unregistered.add(p_flyable);
			WriteFile.writeToFile("Tower says: " + p_flyable.getName() + " unregistered from weather tower.");
		}
		else
			throw new IllegalArgumentException("Invalid argument: Element cannot be remove because it dosent exist");
	}

	/**
	 * 
	 */
	protected void conditionChanged()
	{
		for (Flyable fly : observers)
			fly.updateConditions();
		observers.removeAll(unregistered);
		unregistered.clear();
	}
}

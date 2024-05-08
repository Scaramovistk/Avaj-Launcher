package Tower;

import Interface.*;
import File.*;
import java.util.List;
import java.util.LinkedList;

public class Tower
{
	private List<Flyable> observers = new LinkedList<>();
	private List<Flyable> unregistered = new LinkedList<>();

	public void register(Flyable p_flyable)
	{
		if (p_flyable != null && !observers.contains(p_flyable))
		{
			observers.add(p_flyable);
			WriteFile.writeToFile("Tower says: " + p_flyable.getName() + " registered to weather tower.");
		}
	}

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

	protected void conditionChanged()
	{
		for (Flyable fly : observers)
			fly.updateConditions();
		observers.removeAll(unregistered);
		unregistered.clear();
	}
}

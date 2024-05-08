package Aircraft;

import Interface.*;
import File.*;

public class Aircraft extends Flyable
{
	protected long id;
	protected String type;
	protected String name;
	protected Coordinates coordinates;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinate)
	{
		if (p_id < 0 || p_name == null || p_coordinate == null)
			throw new IllegalArgumentException("Invalid argument: Set to null");
		id = p_id;
		name = p_name;
		coordinates = p_coordinate;
		type = "Aircraft";
	}

	public String getName()
	{
		return (type + "#" + name + "(" + id + ")");
	}

	public void updateConditions()
	{

	}

	public void sendStatus(String msg, int heigh)
	{
		msg = this.getName() + msg;
		WriteFile.writeToFile(msg);
		if (heigh <= 0)
		{
			WriteFile.writeToFile(this.getName() + " landing.");
			weatherTower.unregister(this);
		}
	}
}

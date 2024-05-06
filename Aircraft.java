/**
 * A class to be a blueprint for varios Aircraft types
 */
public class Aircraft extends Flyable
{
	protected long id;
	protected String type;
	protected String name;
	protected Coordinates coordinates;

	/**
	 * Construcs a Aircraft seting up theirs params
	 * @param p_id is the id of the Aircraft
	 * @param p_name is the name of the Aircraft
	 * @param p_coordinate is the cordernates that the Aircraft is
	 */
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
}

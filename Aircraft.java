/**
 * A class to be a blueprint for varios Aircraft types
 */
public class Aircraft extends Flyable
{
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	/**
	 * Construcs a Aircraft seting up theirs params
	 * @param p_id is the id to specify wich type of Aircraft is demanded
	 * @param p_name is the name of the Aircraft
	 * @param p_coordinate is the cordernates that the Aircraft is
	 */
	protected Aircraft(long p_id, String p_name, Coordinates p_coordinate)
	{
		if (p_id > 0 && p_name != null && p_coordinate != null)
		{
			id = p_id;
			name = p_name;
			coordinates = p_coordinate;
		}
		else
		{
			id = p_id;
			name = null;
			coordinates = null;
		}
	}

	/**
	 * Update Conditions
	 */
	public void updateConditions()
	{

	}
}

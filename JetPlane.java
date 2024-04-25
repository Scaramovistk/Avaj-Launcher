public class JetPlane extends Aircraft
{
	public JetPlane(long p_id, String p_name, Coordinates p_coordinate)
	{
		super(p_id, p_name, p_coordinate);
	}

	public void updateConditions()
	{
		/**
		 * SUN - Latitude increases with 10, Height increases with 2
		RAIN - Latitude increases with 5
		◦ FOG - Latitude increases with 1
		◦ SNOW - Height decreases with 7
		 */
	}
}

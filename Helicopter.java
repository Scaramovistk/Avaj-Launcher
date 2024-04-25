public class Helicopter extends Aircraft
{
	public Helicopter(long p_id, String p_name, Coordinates p_coordinate)
	{
		super(p_id, p_name, p_coordinate);
	}

	public void updateConditions()
	{
		/**
		 * ◦ SUN - Longitude increases with 10, Height increases with 2
		◦ RAIN - Longitude increases with 5
		◦ FOG - Longitude increases with 1
		◦ SNOW - Height decreases with 12
		 */
	}
}

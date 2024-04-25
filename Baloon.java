public class Baloon extends Aircraft
{
	public Baloon(long p_id, String p_name, Coordinates p_coordinate)
	{
		super(p_id, p_name, p_coordinate);
	}

	public void updateConditions()
	{
		/**
		 * ◦ SUN - Longitude increases with 2, Height increases with 4
		◦ RAIN - Height decreases with 5
		◦ FOG - Height decreases with 3
		◦ SNOW - Height decreases with 15
		 */
	}
}

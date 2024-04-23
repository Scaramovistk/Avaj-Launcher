/**
 * A class that has 3 private ints to setup coordinates
 */
public class Coordinates
{
	private int longitude;
	private int latitude;
	private int height;

	/**
	 * Constructor to inicialize all the private paramets of Coordinates
	 * @param p_longitude initialize the longitude parameter
	 * @param p_latitude initialize the latitude parameter
	 * @param p_height initialize the height parameter
	 */
	Coordinates(int p_longitude, int p_latitude, int p_height)
	{
		//Should i check something here ?
		longitude = p_longitude;
		latitude = p_latitude;
		height = p_height;
	}

	/**
	 * Give the value of longitude
	 * @return the longitude param
	 */
	public int getLongitude()
	{
		return (longitude);
	}
	
	/**
	 * Give the value of latitude
	 * @return the latitude param
	 */
	public int getLatitude()
	{
		return (latitude);
	}
	
	/**
	 * Give the value of height
	 * @return the height param
	 */
	public int getHeight()
	{
		return (height);
	}
}

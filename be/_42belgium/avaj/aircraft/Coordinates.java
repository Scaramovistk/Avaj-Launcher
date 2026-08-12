package be._42belgium.avaj.aircraft;

public class Coordinates
{
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int p_longitude, int p_latitude, int p_height)
	{
		if (p_longitude < 0 || p_latitude < 0 || p_height < 0)
			throw new IllegalArgumentException("Invalid coordinates or height");
		if (p_height > 100)
			p_height = 100;
		longitude = p_longitude;
		latitude = p_latitude;
		height = p_height;
	}

	static int clampCoordinate(long value)
	{
		if (value < 0)
			return (0);
		if (value > Integer.MAX_VALUE)
			return (Integer.MAX_VALUE);
		return ((int) value);
	}

	static int clampHeight(long value)
	{
		if (value < 0)
			return (0);
		if (value > 100)
			return (100);
		return ((int) value);
	}

	public int getLongitude() { return (longitude); }
	public int getLatitude() { return (latitude); }
	public int getHeight() { return (height); }
}

import java.lang.reflect.Field;

/**
 * A class made in the Factory Design Patter, that will make diferent type of Aircrafts
 */
public class AircraftFactory
{
	private static AircraftFactory instance;
	private String[] aircrafTypes = {
		"Baloon",
		"JetPlane",
		"Helicopter"};

	/**
	 * Constructor that will initialize the AircraftFactory values
	 */
	private AircraftFactory(){ /*Initialization code if needed */ }

	/**
	 * Makes the AircraftFactory a Singleton
	 * @return a global instance of AircraftFactory
	 */
	public static AircraftFactory getInstance()
	{
		if (instance == null)
			instance = new AircraftFactory();
		return(instance);
	}

	/**
	 * Creates a new Aircraft and checks if all the parametes are valid
	 * @param p_type is the Aircraft type
	 * @param p_name is the Aircraft name
	 * @param p_coordinates is the Aicraft coordinates
	 * @return a new Aircraft if valid or null if not
	 */
	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)
	{
		int row;

		row = 0;
		while (row != aircrafTypes.length)
		{
			if (aircrafTypes[row] == p_type)
				break;
			row++;
		}

		if (row < aircrafTypes.length && p_name != null && p_coordinates != null)
			return new Aircraft(row, p_name, p_coordinates);
		return null;
	}
}

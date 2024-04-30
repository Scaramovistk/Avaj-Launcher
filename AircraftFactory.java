/**
 * A class made in the Factory Design Patter, that will make diferent type of Aircrafts
 */
public class AircraftFactory
{
	private static AircraftFactory instance;
	private static int id_count;

	/**
	 * Constructor that will initialize the AircraftFactory values
	 */
	private AircraftFactory()
	{
		id_count = 0;
	}

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
	 * @return a new Aircraft if valid or exeption if not
	 */
	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)
	{
		if (p_type == null || p_name == null || p_coordinates == null)
			throw new IllegalArgumentException("Invalid argument: Set to null");
		switch (p_type)
		{
			case "Baloon":
				return new Baloon(id_count++, p_name, p_coordinates);
			case "JetPlane":
				return new JetPlane(id_count++, p_name, p_coordinates);
			case "Helicopter":
				return new Helicopter(id_count++, p_name, p_coordinates);
			default:
				throw new IllegalArgumentException("Invalid argument: Type " + p_type + " dont exist");
		}
	}
}

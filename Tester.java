/**
 * A class to test each part of the system
 */
public class Tester
{
	/**
	 * Automaticatly make some test for the AircraftFactory class
	 */
	public void testAircraftFactory()
	{
		AircraftFactory factory = AircraftFactory.getInstance();
		Coordinates cord = new Coordinates(4, 6, 7);

		if (factory.newAircraft("Baloon", "B2", cord) == null)
			System.out.print("Failed test 01\n");
		if (factory.newAircraft("JetPlane", "B2", cord) == null)
			System.out.print("Failed test 02\n");
		if (factory.newAircraft("Helicopter", "B2", cord) == null)
			System.out.print("Failed test 03\n");
		if (factory.newAircraft("Hdadasdaselicopter", "B2", cord) != null)
			System.out.print("Failed test 04\n");
		if (factory.newAircraft("", "B2", cord) != null)
			System.out.print("Failed test 05\n");
		if (factory.newAircraft(null, "B2", cord) != null)
			System.out.print("Failed test 06\n");
		if (factory.newAircraft("Helicopter", null, cord) != null)
			System.out.print("Failed test 07\n");
		if (factory.newAircraft("Helicopter", "B2", null) != null)
			System.out.print("Failed test 08\n");
	}
}

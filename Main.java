import File.ReadFile;
import Simulation.*;

public class Main
{
	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.out.println("Usage: java Main <filename>.txt");
			return;
		}

		ReadFile file = new ReadFile(args[0]);
		Simulation sim = new Simulation();

		sim.registerAircrafts(file.fileContent());
		sim.runSimulation();
	}
}

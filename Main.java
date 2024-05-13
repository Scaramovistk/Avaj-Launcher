import File.ReadFile;
import Simulation.*;
import Exception.*;

public class Main
{
	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.err.println("Usage: java Main <filename>.txt");
			return;
		}

		try
		{
			Simulation sim = new Simulation();
			ReadFile file = new ReadFile(args[0]);
			sim.registerAircrafts(file.fileContent());
			sim.runSimulation();
		}
		catch(IncorrectFileNameException e)
		{
			System.err.println("Error try another file: " + e);
		}
		catch(IncorrectFileContentException e)
		{
			System.err.println("Error content is not according to norm: " + e);
		}
		catch(IncorrectClassInitialisationExeption e)
		{
			System.err.println("Error content is not according to norm: " + e);
		}
		catch(NumberFormatException e)
		{
			System.err.println("Error in Numbers: " + e);
		}
		catch(IllegalArgumentException e)
		{
			System.err.println("Input error: " + e);
		}
		catch (Exception e) {
			System.err.println("Error: " + e);
		}
	}
}

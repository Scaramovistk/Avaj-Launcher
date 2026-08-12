package be._42belgium.avaj.simulator;

import be._42belgium.avaj.file.ReadFile;
import be._42belgium.avaj.exception.IncorrectFileNameException;
import be._42belgium.avaj.exception.IncorrectFileContentException;
import be._42belgium.avaj.exception.IncorrectClassInitialisationException;

public class Simulator
{
	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.err.println("Usage: java be._42belgium.avaj.simulator.Simulator <filename>.txt");
			return;
		}

		try
		{
			Simulation sim = new Simulation();
			ReadFile file = new ReadFile(args[0]);
			sim.registerAircrafts(file.fileContent());
			sim.runSimulation();
		}
		catch (IncorrectFileNameException e)
		{
			System.err.println("Error try another file: " + e.getMessage());
		}
		catch (IncorrectFileContentException e)
		{
			System.err.println("Error content is not according to norm: " + e.getMessage());
		}
		catch (IncorrectClassInitialisationException e)
		{
			System.err.println("Error content is not according to norm: " + e.getMessage());
		}
		catch (NumberFormatException e)
		{
			System.err.println("Error in Numbers: " + e.getMessage());
		}
		catch (IllegalArgumentException e)
		{
			System.err.println("Input error: " + e.getMessage());
		}
		catch (Exception e)
		{
			System.err.println("Error: " + e.getMessage());
		}
	}
}

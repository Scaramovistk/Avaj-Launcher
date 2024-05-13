package File;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;

public class WriteFile
{
	private static String fileName = "simulation.txt";
	private static String buffContent = "";
	private static BufferedWriter writer;

	public WriteFile()
	{

	}

	public static void writeToFile(String str)
	{
		buffContent += str + "\n";
	}

	public static void closeFile()
	{
		try {
			writer = new BufferedWriter(new FileWriter(fileName));
			writer.write(buffContent);
			writer.close();
		} catch (IOException e)
		{
			System.err.println("Error reading file: " + e.getMessage());
		}
	}
}

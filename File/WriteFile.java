package File;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;

public class WriteFile
{
	private static String fileName = "simulation.txt";
	private static String fStr = "";


	public WriteFile() {}

	public static void writeToFile(String str)
	{
		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			fStr += str + "\n";
			writer.write(fStr);
			writer.close();
		} catch (IOException e)
		{
			System.err.println("Error reading file: " + e.getMessage());
		}
	}
}
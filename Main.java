import java.util.List;
import java.util.ArrayList;

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

		sim.startSimulation(file.fileContent());
		// for (String str : file_content)
		// 	System.out.println(str);
	}
}

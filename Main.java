import java.io.*;
import java.awt.Desktop;

public class Main
{
	public static void main(String[] args)
	{
		// Tester obj = new Tester();
		System.out.print("\nStarted\n");
		// obj.testAircraftFactory();
		// System.out.print("test");
		
		// Open the file here get the fd
		//Send the file to the simulation
		//Check if theres only one arguments in args
		try
		{
			File file = new File("./" + args[0]);
			// Desktop desktop = Desktop.getDesktop();
			FileInputStream fis=new FileInputStream(file);
			System.out.println("file content: ");
			int r = 0;
			int row = 0;
			String[] line;

			while((r=fis.read())!=-1)  
			{
				if (r == '\n')
					System.out.print("Next line");
				else
				{
					line[row] += r;
					// Concatenate the caracters here and make a string per line
				}
				System.out.print((char)r);
			}


			// if(file.exists())
			// 	desktop.open(file);


		} catch(Exception e)
		{
			System.out.print("Error\n");
			e.printStackTrace();
		}
	}
}

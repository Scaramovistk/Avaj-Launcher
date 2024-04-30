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
		List<String> file_strings = file.fileContent();

		for (String str : file_strings)
			System.out.println(str);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;

public class ReadFile
{
	private String file_name;
	private List<String> list_of_strings;

	public ReadFile(String file)
	{
		if (file == null)
			throw new IllegalArgumentException("Invalid file name: Set to null");
		file_name = file;
	}

	public List<String> fileContent()
	{
		BufferedReader bf = null;
		list_of_strings = new ArrayList<>();

		try {
			bf = new BufferedReader(new FileReader(file_name));

			String line;
			while ((line = bf.readLine()) != null)
				list_of_strings.add(line);
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
		} finally {
			if (bf != null)
			{
				try {
					bf.close();
				} catch (IOException e) {
					System.err.println("Error closing file: " + e.getMessage());
				}
			}
		}
		return (list_of_strings);
	}
}
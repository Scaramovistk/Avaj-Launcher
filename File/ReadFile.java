package File;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import Exception.*;

public class ReadFile
{
	private String fileName;
	private List<String> listOfStrings;

	public ReadFile(String file) throws IncorrectFileNameException
	{
		if (file == null)
			throw new IncorrectFileNameException("Invalid file name: Set to null");
		fileName = file;
	}

	public List<String> fileContent() throws IncorrectFileNameException
	{
		File file = new File(fileName);
		BufferedReader bf = null;
		listOfStrings = new ArrayList<>();
		if (!file.exists())
			throw new IncorrectFileNameException(fileName + " dont exist");
		try {
			bf = new BufferedReader(new FileReader(fileName));
			
			String line;
			while ((line = bf.readLine()) != null)
				listOfStrings.add(line);
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
		return (listOfStrings);
	}
}

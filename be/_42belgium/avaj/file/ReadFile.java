package be._42belgium.avaj.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import be._42belgium.avaj.exception.IncorrectFileNameException;

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
		if (!file.isFile())
			throw new IncorrectFileNameException(fileName + " is not a regular file");
		if (!file.canRead())
			throw new IncorrectFileNameException(fileName + " cannot be read");

		try {
			bf = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = bf.readLine()) != null)
				listOfStrings.add(line);
		} catch (IOException e) {
			throw new IncorrectFileNameException("Error reading file: " + e.getMessage());
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

		if (listOfStrings.isEmpty())
			throw new IncorrectFileNameException(fileName + " is empty");

		return (listOfStrings);
	}
}

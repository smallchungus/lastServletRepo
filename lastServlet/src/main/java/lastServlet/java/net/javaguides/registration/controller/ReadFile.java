package lastServlet.java.net.javaguides.registration.controller;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ReadFile {

	public static int readFunction(String inputFileName) throws FileNotFoundException {
		int count = 0;
		File myObj = new File(inputFileName);
		Scanner myReader;
		myReader = new Scanner(myObj);

		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			System.out.println(data);
			count++;
		}
		myReader.close();
		return count;
		// EmployeeServlet.exportFunction(inputFileName, count);

	}
}

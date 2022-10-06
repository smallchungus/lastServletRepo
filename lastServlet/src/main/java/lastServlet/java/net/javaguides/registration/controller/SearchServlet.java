package lastServlet.java.net.javaguides.registration.controller;

import java.io.File;
import java.util.Scanner;

public class SearchServlet {
	
	
	public static void searchFunction ( String toBeSearched )
	{
		try {
			File myObj = new File("C:\\Users\\wchen\\eclipse\\jee-2022-06\\eclipse\\filenameNew.txt");
			Scanner myReader = new Scanner(myObj);
			
			int count = 0; 
			while (myReader.hasNextLine()) 
			{
				String data = myReader.nextLine().toLowerCase().toString();
				if ( data.contains(toBeSearched))
				{
				System.out.println(data);
				count++;
				}
			}
			
			System.out.println("Number of times your inquiry is in the file " + count);
			myReader.close();
		} catch (NullPointerException e) {
			System.out.println("File not found here");
		} catch (Exception e) {
			System.out.println("exception occured");
		}
	}
}

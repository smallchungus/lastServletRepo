package lastServlet.java.net.javaguides.registration.controller;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

public class ReadFile {

	public static String[][] readFunction(String inputFileName) throws Exception{
	    
		File file = new File(inputFileName);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		Scanner sc2 = null;
	    sc2 = new Scanner(inputFileName);
		
		String [][] newString = new String[100][5];
		int i = 0; 


        for(; i < 100 && reader.ready(); i++) {
            String[] splittedRow = reader.readLine().split(" "); // split using the space character
            for(int j = 0; j < 5; j++) {
                newString[i][j] = splittedRow[j];
                //System.out.println(splittedRow[j]);
            }
        }
        
        reader.close();
        //ExportFile.exportFunction(inputFileName, newString);
        //ExportFile.exportFunction();
//        ExportFile.exportFunction(newString);
        return newString;
		
	}
}

package lastServlet.java.net.javaguides.registration.controller;

import java.util.Iterator;
import java.util.Scanner;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


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
            }
        }
        
        reader.close();
        sc2.close();
        return newString;
		
	}
	
	public static int[][] readFunction (String inputFileName, boolean flag) throws Exception {
		
		try {

			FileInputStream reader = new FileInputStream ( new File (inputFileName));
			
			XSSFWorkbook wb = new XSSFWorkbook(reader);
			XSSFSheet sheet = wb.getSheetAt(0);
			
			Iterator<Row> rowIterator = sheet.iterator();
			int i = 1; 
			int j = 0; 
			int data [][] = new int [5][5]; 
			
			Row row = rowIterator.next();
			
			while ( rowIterator.hasNext()) {
				row = rowIterator.next();
				
				Iterator<Cell> cellIterator = row.cellIterator();
				
				while ( cellIterator.hasNext()) {
					
					Cell cell = cellIterator.next();
					
					System.out.println(cell.getNumericCellValue());
                    data [i][j]= (int) cell.getNumericCellValue();
					j++;
					}
				
				i ++;
				j = 0; 
				}
			
			
			return data; 

		}
		finally {
			
		}
}
	
	public static void main (String [] args)
	{
		try {
			readFunction("OrdersPerHour.xlsx", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

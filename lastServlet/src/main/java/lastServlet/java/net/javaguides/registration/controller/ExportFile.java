package lastServlet.java.net.javaguides.registration.controller;
import lastServlet.java.net.javaguides.registration.model.Employee;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileWriter;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExportFile {
	// Main driver method
	public static void exportFunction() {
    //public static void main(String[] args){
  

		// Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();

		// Creating a blank Excel sheet
		XSSFSheet sheet = workbook.createSheet("Register User");
	       Map<String, Object[]> asdf
           = new TreeMap<String, Object[]>();
 
       // Writing data to Object[]
       // using put() method
           asdf.put("1",
                new Object[] { "ID", "NAME", "LASTNAME" });
           asdf.put("2",
                new Object[] { 1, "Will", "Kumar" });
           asdf.put("3",
                new Object[] { 2, "Prakashni", "Yadav" });
           asdf.put("4", new Object[] { 3, "Ayan", "Mondal" });
           asdf.put("5", new Object[] { 4, "Virat", "kohli" });
 
       // Iterating over data and writing it to sheet
       Set<String> keyset = asdf.keySet();
 
       int rownum = 0;
 
       for (String key : keyset) {
 
           // Creating a new row in the sheet
           Row row = sheet.createRow(rownum++);
 
           Object[] objArr = asdf.get(key);
 
           int cellnum = 0;
 
           for (Object obj : objArr) {
 
               // This line creates a cell in the next
               //  column of that row
               Cell cell = row.createCell(cellnum++);
 
               if (obj instanceof String)
                   cell.setCellValue((String)obj);
 
               else if (obj instanceof Integer)
                   cell.setCellValue((Integer)obj);
           }
       }
//	      Row[] row = new Row[data.length];
//	      Cell[][] cell = new Cell[row.length][];
//
//	      //Define and Assign Cell Data from Given
//	      for(int i = 0; i < row.length; i ++)
//	      {
//	          row[i] = sheet.createRow(i);
//	          cell[i] = new Cell[data[i].length];
//
//	          for(int j = 0; j < cell[i].length; j ++)
//	          {
//	              cell[i][j] = row[i].createCell(j);
//	              cell[i][j].setCellValue(data[i][j]);
//	          }
//
//	      }

		// Try block to check for exceptions
		try {

			// Writing the workbook
			FileOutputStream out = new FileOutputStream(new File("Users.xlsx"));
			workbook.write(out);

			// Closing file output connections
			out.close();

			// Console message for successful execution of
			// program
			System.out.println("gfgcontribute.xlsx written successfully on disk.");
		}

		// Catch block to handle exceptions
		catch (Exception e) {

			// Display exceptions along with line number
			// using printStackTrace() method
			e.printStackTrace();
		}
	}
}

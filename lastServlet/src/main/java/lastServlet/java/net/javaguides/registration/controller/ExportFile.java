package lastServlet.java.net.javaguides.registration.controller;


import java.io.*;

import org.apache.poi.poifs.filesystem.*;
//import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import org.apache.poi.poifs.crypt.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportFile {

	public static void exportFunction(String[][] data) throws FileNotFoundException, IOException, Exception {

		POIFSFileSystem fs = new POIFSFileSystem();

		EncryptionInfo info = new EncryptionInfo(EncryptionMode.standard);
		Encryptor enc = info.getEncryptor();
		enc.confirmPassword("password");

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("Register User");

		// Create 2D Cell Array
		Row[] row = new Row[data.length];
		Cell[][] cell = new Cell[row.length][];

		// writing the headers for the data to be input
		String[][] headers = new String[1][6];
		headers[0][0] = "First Name";
		headers[0][1] = "Last Name";
		headers[0][2] = "Email Address";
		headers[0][3] = "UserName";
		headers[0][4] = "Password";

		for (int i = 0; i < headers.length; i++) {
			row[i] = sheet.createRow(i);
			cell[i] = new Cell[headers[i].length];
			for (int j = 0; j < headers[0].length; j++) {

				cell[i][j] = row[i].createCell(j);
				cell[i][j].setCellValue(headers[i][j]);
			}
		}

		// Define and Assign Cell Data from Given
		for (int i = 1; i < row.length; i++) {
			row[i] = sheet.createRow(i);
			cell[i] = new Cell[data[i].length];

			for (int j = 0; j < cell[i].length; j++) {
				cell[i][j] = row[i].createCell(j);
				
//	            cell[i][j].setCellValue(data[i][j]); this works but the string is returning a null. 
				if (j != 4)
					cell[i][j].setCellValue(data[i][j]);
				else { 
//					System.out.println(data[i][j]);
					cell[i][j].setCellValue(EncryptString.Encrypt(data[i][j]));
				}
			}

		}
		  OutputStream encos = enc.getDataStream(fs);
		  wb.write(encos);
		  wb.close();
		  encos.close(); // this is necessary before writing out the FileSystem
		  
		  OutputStream os = new FileOutputStream("UsersRegister.xlsx");
		  fs.writeFilesystem(os);
		  os.close();
		  fs.close();
		  
		System.out.println("File exported successfully first one");
	}
	public static void exportFunction(int[][] data) throws FileNotFoundException, IOException, Exception {
				
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("Number of Orders Per Hour");
		
		
		Row[] row = new Row[data.length];
		Cell[][] cell = new Cell[row.length][];
		
		String[][] headers = new String[1][2];
		headers[0][0] = "Number of Orders";
		headers[0][1] = "Time";
		
		for ( int i =0; i < headers.length; i ++ ) 
		{
			row[i] = sheet.createRow(i);
			cell[i] = new Cell[headers[i].length];
			for ( int j = 0; j < headers[0].length; j++)
			{
				cell[i][j] = row[i].createCell(j);
				cell[i][j].setCellValue(headers[i][j]);
			}
		}
		
		
		for ( int i = 1; i < row.length; i ++ ) 
		{
			row[i] = sheet.createRow(i);
			cell[i] = new Cell[data[i].length];
			
			for ( int j = 0; j < cell[i].length; j ++ ) 
			{
				cell[i][j] = row[i].createCell(j);
				cell[i][j].setCellValue(data[i][j]);

			}
		}

		  
		  OutputStream os = new FileOutputStream("OrdersPerHour.xlsx");
		  wb.write(os);
		  
		  wb.close();
		  os.close();

		System.out.println("File exported successfully here");
	}
	
	public static void main ( String [] args )
	{
		int [][] data = new int [5][2];
		
		for ( int i =1; i < data.length; i ++ ) 
		{
			for ( int j = 1 ; j < data[0].length; j ++)
			{
				data[i][j] = i * 100;
			}
			data[i][0] = i;
			
		}
		
		try {
			exportFunction(data);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}


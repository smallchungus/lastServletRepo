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

import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import org.apache.poi.poifs.crypt.*;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportFile {
	// Main driver method
	public static void exportFunction(String[][] data) throws FileNotFoundException, IOException, Exception {
		// public static void main(String[] args){
		// Create new workbook and tab

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
					System.out.println(data[i][j]);
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
		  
		System.out.println("File exported successfully");
	}
}


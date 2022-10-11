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

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportFile {
	// Main driver method
	public static void exportFunction(String[][] data) throws FileNotFoundException, IOException {
		// public static void main(String[] args){
		// Create new workbook and tab
		XSSFWorkbook wb = new XSSFWorkbook();
		FileOutputStream fileOut = new FileOutputStream(new File("UsersRegister.xlsx"));
		XSSFSheet sheet = wb.createSheet("Register User");

		// Create 2D Cell Array
		Row[] row = new Row[data.length];
		Cell[][] cell = new Cell[row.length][];

		// Define and Assign Cell Data from Given
		for (int i = 0; i < row.length; i++) {
			row[i] = sheet.createRow(i);
			cell[i] = new Cell[data[i].length];

			for (int j = 0; j < cell[i].length; j++) {
				cell[i][j] = row[i].createCell(j);
				cell[i][j].setCellValue(data[i][j]);
			}

		}

		// Export Data
		wb.write(fileOut);
		fileOut.close();
		System.out.println("File exported successfully");
	}

}
//}

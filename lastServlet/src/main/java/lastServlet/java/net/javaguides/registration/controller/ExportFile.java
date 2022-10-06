package lastServlet.java.net.javaguides.registration.controller;

import java.io.*;
import java.util.Scanner;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import java.io.FileWriter;

public class ExportFile {

	public static void exportFunction(String fileToBeRead, int size) throws FileNotFoundException, IOException {

		Workbook wb = new HSSFWorkbook();
		FileOutputStream fileOut = new FileOutputStream("EmployeeLoginInformation.xls");
		int[][] loginInformation = new int[size / 2][2];
		int count = 0;

		Sheet sheet = wb.createSheet("Login Information");

		File myObj = new File(fileToBeRead);
		Scanner myReader = new Scanner(myObj);

		Row[] row = new Row[size / 2];
		Cell[][] cell = new Cell[row.length][size/2+1];

		for (int i = 0; i < size / 2 +1; i++) {
			row[i] = sheet.createRow[i];
			cell[i] = new Cell[size / 2];

			for (int j = 0; j < 2; j++) {
				String data = myReader.nextLine();
				cell[i][j] = row[i].createCell(j);
				cell[i][j].setCellValue(data);
				int rowIndex = i;
				int columnIndex = j;
				System.out.println(
						"Given cell is created at i changed something " + "(" + rowIndex + "," + columnIndex + ")");
			}
		}

		// Writing the content to Workbook
		wb.write(fileOut);

		// Printing the row and column index of cell created
		wb.close();
		System.out.println("File exported successfully");

	}
}

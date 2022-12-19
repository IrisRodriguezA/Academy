package Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class ReadSpreasheet {

	@SuppressWarnings("deprecation")
	public void readExcel(String path, String filename, String sheetName) throws IOException {

		// CREATES A FILE OBJECT TO OPEN THE FILE //
		// ABRIR ARCHIVO
		File excelFile = new File(path + "\\" + filename);

		// CREATE OBJECT FILEINPUTSTREAM TO READ EXCEL //LEE EL ARCHIVO SIN SABER QUE ES
		// UN EXCEL
		FileInputStream inputStream = new FileInputStream(excelFile);

		// LEER ARCHIVO COMO UN EXCEL
		Workbook seleniumTrainingWorkbook = null;

		// FIND FILE EXTENSION //
		String fileExtensionName = filename.substring(filename.indexOf("."));

		// IF THE FILE IS XLSX THEN WE WILL CREATE AN OBJECT OF XSSWORKBOOK CLASS //
		if (fileExtensionName.equals(".xlsx")) {
			seleniumTrainingWorkbook = new XSSFWorkbook(inputStream);
		}

		// IF THE FILE IS XLSX THEN WE WILL CREATE AN OBJECT OF HSSWORKBOOK CLASS //
		if (fileExtensionName.equals(".xls")) {
			seleniumTrainingWorkbook = new HSSFWorkbook(inputStream);
		}

		// READ SHEET INSIDE THE WORBOOK USING ITS NAME //
		// OBTENER LA HOJA1 Y GUARDANDO EL CONTENIDO EN UNA VARIABLE
		Sheet sheetTraining = seleniumTrainingWorkbook.getSheet(sheetName);

		// GETTING THE FIRST ROW //
		// GUARDAMOS EL RENGLON
		// Row row = sheetTraining.getRow(1);
		Row row;

		// READING FIRST CELL //
		// LEE EL RENGLON Y LO IMPRIME EN UNA VARIABLE

		// ONE CELL
		// String firstCell = row.getCell(0).getStringCellValue();

		// READING CELLS
		String cell = "";
		for (int rowIndex = 0; rowIndex <= sheetTraining.getLastRowNum(); rowIndex++) {
			row = sheetTraining.getRow(rowIndex);
			for (int columnIndex = 0; columnIndex < row.getLastCellNum(); columnIndex++) {
				row.getCell(columnIndex).setCellType(Cell.CELL_TYPE_STRING);
				cell = row.getCell(columnIndex).getStringCellValue();
				System.out.print(cell + "  |  ");
			}
			System.out.println();
		}

		// System.out.println("First cell of the row: " + firstCell);
	}

	public void writeExcel(String path, String filename, String sheetName, String cellValue) throws IOException {

		// CREATES A FILE OBJECT TO OPEN THE FILE
		File excelFile = new File(path + "\\" + filename);

		// CREATE OBJECT FILEINPUTSTREAM TO READ EXCEL
		FileInputStream inputStream = new FileInputStream(excelFile);

		Workbook seleniumTrainingWorkbook = null;

		// FIND FILE EXTENSION
		String fileExtensionName = filename.substring(filename.indexOf("."));

		// IF THE FILE IS XLSX THEN WE WILL CREATE AN OBJECT OF XSSWORKBOOK CLASS
		if (fileExtensionName.equals(".xlsx")) {
			seleniumTrainingWorkbook = new XSSFWorkbook(inputStream);
		}

		// IF THE FILE IS XLSX THEN WE WILL CREATE AN OBJECT OF HSSWORKBOOK CLASS
		if (fileExtensionName.equals(".xls")) {
			seleniumTrainingWorkbook = new HSSFWorkbook(inputStream);
		}

		// READ SHEET INSIDE THE WOKRBOOK USING ITS TIME
		Sheet sheetTraining = seleniumTrainingWorkbook.getSheet(sheetName);

		// GET CELL NUMBER COUNT (OF THE FIRST ROW)
		int firstRowLastCellNumber = sheetTraining.getRow(0).getLastCellNum();

		// GET HOW MANY ROWS ARE IN THE SHEET
		int rowCount = sheetTraining.getLastRowNum();

		// CREATE A NEW ROW AFTER THE LAST ONE
		Row newRow = sheetTraining.createRow(rowCount + 1);

		// CICLE INTO EACH COLUMN OF THE NEW ROW AND SET THE VALUE
//		for (int indexNewCell = 0; indexNewCell < firstRowLastCellNumber; indexNewCell++) {
//			Cell cell = newRow.createCell(indexNewCell);
//			cell.setCellValue(cellValue + indexNewCell);
//		}

		for (int indexNewCell = 0; indexNewCell < firstRowLastCellNumber; indexNewCell++) {
			switch (indexNewCell) {
			case 0: {
				Cell cell = newRow.createCell(indexNewCell);
				cell.setCellValue("pink");
				break;
			}
			case 1: {
				Cell cell = newRow.createCell(indexNewCell);
				cell.setCellValue("black");
				break;
			}
			case 2: {
				Cell cell = newRow.createCell(indexNewCell);
				cell.setCellValue("white");
				break;
			}
			default: {
				Assert.fail("Failed: index is out of bounds");
			}

			} // CLOSING SWITCH
		}

		// CLOSE THE INPUT STREAM
		inputStream.close();

		// CREATE AN OBJECT OF FILEOUTPUTSTREAM TO WRITE DATA IN EXCEL FILE
		FileOutputStream outputStream = new FileOutputStream(excelFile);

		// WRITE DATA
		seleniumTrainingWorkbook.write(outputStream);
		outputStream.close();
	}

	public static void main(String arg[]) throws IOException {
		ReadSpreasheet objectExcelFile = new ReadSpreasheet();
		// objectExcelFile.readExcel("C:\\Seleni~1", "selenium.xlsx", " Hoja 1");

		// CHANGE FOR .WRITEEXCEL
		objectExcelFile.writeExcel("C:\\Seleni~1", "selenium.xlsx", "Hoja 1", "HELLO");
	}

}

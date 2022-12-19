package Google;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class googleSearch {

	String path = "C:\\Seleni~1";
	String filename = "google.xlsx";
	String sheetName = "Hoja1";
	WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Selenium Training\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
	}

	public String readExcel(String parameterName) throws IOException {

		// CREATES A FILE OBJECT TO OPEN THE FILE
		File excelFile = new File(path + "\\" + filename);

		// CREATE OBJECT FILEINPUTSTREAM TO READ EXCEL
		FileInputStream inputStream = new FileInputStream(excelFile);

		Workbook seleniumTrainingWorkbook = null;

		// FIND FILE EXTENSION
		String fileExtensionName = filename.substring(filename.indexOf("."));

		// IF THE FILE IS XLSX THEN WE WILL CREATE AN OBJECT OF XSSWorkbook CLASS
		if (fileExtensionName.equals(".xlsx")) {
			seleniumTrainingWorkbook = new XSSFWorkbook(inputStream);
		}

		// IF THE FILE IS XLSX THEN WE WILL CREATE AN OBJECT OF HSSWorkbook CLASS
		if (fileExtensionName.equals(".xls")) {
			seleniumTrainingWorkbook = new HSSFWorkbook(inputStream);
		}

		// READ SHEET INSIDE THE WORKBOOK USING ITS TIME
		Sheet sheetTraining = seleniumTrainingWorkbook.getSheet(sheetName);

		// GETTING THE FIRST ROW
		Row row = sheetTraining.getRow(0);

		// READING THE FIRST CELL
		String cell = "";

		// GUARDA EL INDICE EN LA COLUMNA EN FORMATO STRING
		String foundColumn = null;

		// CYCLYING INTO EACH COLUMN OF THE FIRST ROW
		for (int columnIndex = 0; columnIndex < row.getLastCellNum(); columnIndex++) {

			// WE WANT TO READ EACH CELL AS STRING
			row.getCell(columnIndex).setCellType(CellType.STRING);

			// RETRIVING THE VALUE OF THE CELL
			cell = row.getCell(columnIndex).getStringCellValue();

			// VALIDATE THAT THE CURRENT CELL IS EQUALS TO THE PARAMETER BANE WE WANT TO
			// USE
			if (cell.equals(parameterName)) {

				// IF IS EQUALS THEN WE WILL SAVE THE INDEX IN THE FOUNDCOLUMN VARIABLE
				foundColumn = String.valueOf(columnIndex);
				break;
			}
		}
		if (foundColumn == null)
			Assert.fail("FAILED: The parameter with name " + parameterName + " does not exist in excel spreadsheet");

		// GETTING THE SECOND ROW
		row = sheetTraining.getRow(1);

		// SETTING THE CELL TYPE TO STRING
		row.getCell(Integer.valueOf(foundColumn)).setCellType(CellType.STRING);

		// RETRIEVE THE VALUE FROM THE PROPER COLUMN
		String retrieveValue = row.getCell(Integer.valueOf(foundColumn)).getStringCellValue();
		return retrieveValue;

	}

	@Test
	public void googleSearchCatsMiau() throws IOException {
		String URL = "https://www.google.com";

		System.out.println("Navigating to google");
		driver.navigate().to(URL);

		// SETTING THE IMPLICIT WAIT FOR ALL OBJECTS
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement searchKeyword = driver.findElement(By.xpath("//input[@title='Buscar']"));
		searchKeyword.sendKeys(this.readExcel("keywordSearch"));
		searchKeyword.click();

		List<WebElement> sugerencia = driver.findElements(By.xpath("//div[@class='wM6W7d']/span"));

		for (WebElement contenedor : sugerencia) {
			System.out.println("sugerencia:" + contenedor.getText());
		}

		sugerencia.get(1).click();
	}
}

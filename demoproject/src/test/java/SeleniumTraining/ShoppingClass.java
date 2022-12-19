package SeleniumTraining;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ShoppingClass {

	String path = "C:\\Selenium Training\\ShoppingClass Screenshots\\";
	// String path = "C:\\Seleni~1";
	String filename = "checkout.xlsx";
	String sheetName = "Hoja1";
	WebDriver driver;
	JavascriptExecutor js;
	String URL;

	// =======================================================JAVASCRIPT=======================================================//

	public void jsClick(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public void jsScrollDown() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	}

	public void jsScrollToElement(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void jsWaitForThePageToBeLoaded() {
		js = (JavascriptExecutor) driver;
		new WebDriverWait(driver, Duration.ofSeconds(15), Duration.ofSeconds(3))
				.until((ExpectedCondition<Boolean>) waitPage2 -> ((JavascriptExecutor) waitPage2)
						.executeScript("return document.readyState").equals("complete"));
	}

	public String jsGetURL() {
		js = (JavascriptExecutor) driver;
		return js.executeScript("return document.URL").toString();
	}

	public String jsGetTitle() {
		js = (JavascriptExecutor) driver;
		return js.executeScript("return document.title").toString();
	}

	public String jsGetDomain() {
		js = (JavascriptExecutor) driver;
		return js.executeScript("return document.domain").toString();
	}

	public void jsGoToNewPage() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.location = 'http://www.google.com/'");
	}

	public void jsSendKeysToEmail(String email) {
		js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('email').value='" + email + "'");
	}

	// =======================================================SCREENSHOT=======================================================//

	public void screenshot(WebDriver webdriver, String pathToFile) throws Exception {
		// CONVERT THE DRIVER OBJECT TO TAKE SCREENSHOT
		TakesScreenshot capture = ((TakesScreenshot) webdriver);

		// CALL GETSCREENHOTAS AS METHOD SO WE CAN CREATE IMAGE FILE
		File scrFile = capture.getScreenshotAs(OutputType.FILE);

		File destinationFile = new File(pathToFile);

		FileUtils.copyFile(scrFile, destinationFile);

	}

	public void screenshotElement(WebElement element, String pathToFile) throws Exception {
		// CONVERT THE DRIVER OBJECT TO TAKE SCREENSHOT
		TakesScreenshot capture = ((TakesScreenshot) element);

		// CALL GETSCREENHOTAS AS METHOD SO WE CAN CREATE IMAGE FILE
		File scrFile = capture.getScreenshotAs(OutputType.FILE);

		File destinationFile = new File(pathToFile);

		FileUtils.copyFile(scrFile, destinationFile);

	}

	// =======================================================EXCEL=======================================================//

	@SuppressWarnings("unused")
	public String readExcel(String parameterName) throws IOException {

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
		// READ SHEET INSIDE THE WORKBOOK USING ITS NAME
		Sheet sheetTraining = seleniumTrainingWorkbook.getSheet(sheetName);

		// GETTIN THE FIRST ROW
		Row row = sheetTraining.getRow(0);
		int totalRow = sheetTraining.getLastRowNum();

		// READING FIRST CELL
		String cell = "";
		String foundColumn = null;

		// CYCLIYNG INTO EACH COLUMN OF THE FIRST ROW
		for (int columnIndex = 0; columnIndex < row.getLastCellNum(); columnIndex++) {

			// WE WANT TO REACH EACH CELL AS STRING
			row.getCell(columnIndex).setCellType(CellType.STRING);

			// RETRIEVING THE VALUE OF THE CELL
			cell = row.getCell(columnIndex).getStringCellValue();

			// VALIDATE THAT THE CURRENT CELL IS EQUALS TO THE PARAMETER NAME WE WANT TO
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

	@SuppressWarnings("unused")
	public void writeExcel(String parameterName, String valueOfParameter) throws IOException {

		// CREATES A FILE OBJECT TO OPEN THE FILE
		File excelFile = new File(path + "\\" + filename);

		// CREATE OBJECT FILEINPUTSTREAM TO READ EXCEL
		FileInputStream inputStream = new FileInputStream(excelFile);
		Workbook seleniumTrainingWorkbook = null;

		// FIND FILER EXTENSION
		String fileExtensionName = filename.substring(filename.indexOf("."));

		// IF THE FILE IS XLSX THEN WE WILL CREATE AN OBJECT OF XSSWORKBOOK CLASS
		if (fileExtensionName.equals(".xlsx")) {
			seleniumTrainingWorkbook = new XSSFWorkbook(inputStream);
		}
		// IF THE FILE IS XLSX THEN WE WILL CREATE AN OBJECT OF HSSWORKBOOK CLASS
		if (fileExtensionName.equals(".xls")) {
			seleniumTrainingWorkbook = new HSSFWorkbook(inputStream);
		}

		// READ SHEET INSIDE THE WORKBOOK USING ITS TIME
		Sheet sheetTraining = seleniumTrainingWorkbook.getSheet(sheetName);

		// GETTING THE FIRST ROW
		Row row = sheetTraining.getRow(0);
		int totalRow = sheetTraining.getLastRowNum();

		// READING FIRST CELL
		String cell = "";
		String foundColumn = null;

		// CYCLING INTO EACH COLUMN OF THE FIRST ROW
		for (int columnIndex = 0; columnIndex < row.getLastCellNum(); columnIndex++) {

			// WE WANT TO READ EACH CELL AS STRING
			row.getCell(columnIndex).setCellType(CellType.STRING);

			// RETRIEVING THE VALUE OF THE CELL
			cell = row.getCell(columnIndex).getStringCellValue();

			// VALIDATE THAT THE CURREN CELL IS EQUALS TO THE PARAMETER NAME WE WANT TO
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
//      row.getCell(Integer.valueOf(foundColumn)).setCellType(CellType.STRING);

		// SAVE THE VALUE FROM THE PROPER COLUMN
		Cell cellSet = row.createCell(Integer.valueOf(foundColumn));
		cellSet.setCellValue(valueOfParameter);

		// CLOSE THE INPUT STREAM
		inputStream.close();

		// CREATE AN OBJECT OF FILEOUTSTREMA TO WRITE DATA IN EXCEL FILE
		FileOutputStream outputStream = new FileOutputStream(excelFile);

		// WRITE DATA
		seleniumTrainingWorkbook.write(outputStream);
		outputStream.close();
		System.out.println("Se guardo el valor '" + valueOfParameter + "' en el parametro '" + parameterName + "'");
	}

	// =======================================================METHOD=======================================================//

	@SuppressWarnings("unused")
	@Test
	public void registerUser() throws Exception {
		URL = "http://automationpractice.com/index.php";
		driver.navigate().to(URL);
		String getTitle = driver.getTitle();
		System.out.println("URL:" + getTitle);

		System.out.println("URL:" + this.jsGetURL());
		System.out.println("Domain:" + this.jsGetDomain());
		System.out.println("Title:" + this.jsGetTitle());

		// FOR EXAMPLE GET LINKS
//		List<WebElement> link = driver.findElements(By.xpath("//a[@href]"));
//		for (int indice=0; indice<link.size(); indice++ ) {
//		
//			System.out.println("href for first link: " + link.get(indice).getAttribute("href"));
//		}

		// SETTINHG THE IMPLICIT WAIT FOR ALL OBJECTS //
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// ENTER TO SIGN IN
		WebElement signIn = driver.findElement(By.xpath("//*[@class= 'login']"));
		signIn.click();

		// ENTER EMAIL
		WebElement enterEmail = driver.findElement(By.id("email"));
		// enterEmail.sendKeys(this.readExcel("email"));
		enterEmail.sendKeys("black_pink_10@gmail.com");

		// ENTER PASSWORD
		WebElement enterPassword = driver.findElement(By.id("passwd"));
		// enterPassword.sendKeys(this.readExcel("password"));
		enterPassword.sendKeys("sooya12345");

		// CLICK THE SUBMIT BUTTON
		WebElement submitLoginButton = driver.findElement(By.id("SubmitLogin"));
		submitLoginButton.click();

		Wait<WebDriver> waitForMyAccount = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(4)).ignoring(NoSuchElementException.class);
		waitForMyAccount.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='My account']")));

		// MY ACCOUNT LABEL
		WebElement myAccountLabel = driver.findElement(By.xpath("//h1[text()='My account']"));
		if (myAccountLabel.isDisplayed()) {
			System.out.println("My account page is displayed");
		} else {
			Assert.fail("My Account page was not displayed");
		}

		// DRESSES BUTTON
		WebElement dressesButton = driver.findElement(By.xpath("(//a[@title='Dresses'])[2]"));
		dressesButton.click();

		Wait<WebDriver> waitForDress = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(4)).ignoring(NoSuchElementException.class);
		waitForMyAccount.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//img[@alt='Printed Dress' and @width>0]/../../..)[1]")));

		// FIRST PRINT DRESS DIV ELEMENT
		WebElement firstPrintDressDiv = driver
				.findElement(By.xpath("(//img[@alt='Printed Dress' and @width>0]/../../..)[1]"));
		firstPrintDressDiv.click();

		// SWITCH TO NEW IFRAME
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6), Duration.ofSeconds(2));
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("//iframe[@class='fancybox-iframe']"))));

		Wait<WebDriver> waitForSubmit = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(4)).ignoring(NoSuchElementException.class);
		waitForSubmit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='Submit']")));

		// ADD TO THE CART BUTTON
		WebElement addToCart = driver.findElement(By.xpath("//button[@name='Submit']"));
		this.jsClick(addToCart);

		// SWITCH TO THE MAIN CONTENT OF THE WEB PAGE
		driver.switchTo().defaultContent();
		Wait<WebDriver> waitForProductAddedMessage = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(4))
				.ignoring(NoSuchElementException.class);

		waitForProductAddedMessage.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='layer_cart']/div/div/h2)[1]")));

		// VALIDATE THAT PRODUCT WAS ADDED TO THE SHOPPING CART
		WebElement verifyProductAdded = driver.findElement(By.xpath("(//div[@id='layer_cart']/div/div/h2)[1]"));
		if (verifyProductAdded.getAttribute("innerHTML").contains("successfully added")
				&& verifyProductAdded.isDisplayed()) {
			System.out.println("PASSED: The product was added to the cart");
		} else {
			Assert.fail("FAILED: The product was not added to the cart");
		}

		// PROCEED TO CHECKOUT BUTTON
		WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//a[@title='Proceed to checkout']"));
		proceedToCheckoutButton.click();

		// FLUENT WAIT (EXPLICIT WAIT)
//		Wait<WebDriver> waitForLabel = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
//				.pollingEvery(Duration.ofSeconds(4)).ignoring(NoSuchElementException.class);
//
//		waitForLabel.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='total_price']")));
//
//		WebElement totalPrice = driver.findElement(By.xpath("//span[@id='total_price']"));
//
//		System.out.println("total price elemento:" + totalPrice.getText());
//		System.out.println("total price excel:" + this.readExcel("total"));
//
//		if (totalPrice.getText().contentEquals(this.readExcel("total"))) {
//			System.out.println("PASSED: Total price matches with " + this.readExcel("total"));
//		} else {
//			Assert.fail("FAILED: total price does not match");
//		}

		// CLICK THE PROCEED TO CHECKOUT BUTTON FROM SHOPPING CART SUMMARY SCREEN
		WebElement proceedToCheckoutButton2 = driver.findElement(By.xpath("(//a[@title='Proceed to checkout'])[2]"));
		proceedToCheckoutButton2.click();

		// SCREENSHOT - ADDRESS
		this.screenshot(driver, path + "6-Address.png");

		// WAIT FOR THE INPUT FOR THE COMMENT
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea")));

		// ENTER COMMENTS
//		WebElement comments = driver.findElement(By.xpath("//textarea"));
//		comments.sendKeys(this.readExcel("comments"));

		// PROCEED TO CHECK OUT - ADDRESS //
		WebElement proceedToCheckoutButton3 = driver.findElement(By.xpath("//button[@name = 'processAddress']"));
		proceedToCheckoutButton3.click();

		// SCREENSHOT - SHIPPING
		this.screenshot(driver, path + "7-Shipping.png");

		// VALIDATE STATUS CHECKBOX - TERMS OF SERVICE//
		WebElement CheckBoxSpan = driver.findElement(By.xpath("//*[@id='uniform-cgv']/span"));
		CheckBoxSpan.click();

		// SHIPPING SCREEN
		WebElement shippingButton = driver.findElement(By.xpath("//button[@name = 'processCarrier']"));
		shippingButton.click();

		// SCREENSHOT - CONFIRM PAYMENT
		this.screenshot(driver, path + "8-ConfirmPayment.png");

		// PAY BY CHECK
		WebElement paybycheckButton = driver.findElement(By.xpath("//a[@title= 'Pay by check.']"));
		paybycheckButton.click();

		// SCREENSHOT - CHECK PAYMENT
		this.screenshot(driver, path + "9-Confirm Order.png");

		// CONFIRM ORDER
		WebElement confirmOrderButton = driver
				.findElement(By.xpath("//span[contains(text(),'I confirm my order')]/.."));
		confirmOrderButton.click();

		Wait<WebDriver> waitForAlert = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(4)).ignoring(NoSuchElementException.class);
		waitForAlert
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='alert alert-success']")));

		// VALIDATE ORDER
		WebElement validateOrder = driver.findElement(By.xpath("//p[text()='Your order on My Store is complete.']"));

		if (validateOrder.getAttribute("class").contains("alert alert-success")) {
			System.out.println(validateOrder.getText());
		} else {
			Assert.fail("The Order is failed");
		}

		// VALIDATE AMOUNT
		WebElement validateAmount = driver.findElement(By.xpath("//span[@class='price']"));

		if (validateAmount.getText().contentEquals("$28.00")) {
			System.out.println("La cantidad es correcta. Su pago es un total de: " + validateAmount.getText());
		} else {
			Assert.fail("Failed: La cantidad no es correcta");
		}

		WebElement alertText = driver.findElement(By.xpath("//p[@class='alert alert-success']"));
		this.writeExcel("resultado", alertText.getText());

		// SCREENSHOT - ORDER COMPLETE
		this.screenshot(driver, path + "10-OrderComplete.png");

		// BACK TO ORDERS
		WebElement backToOrders = driver.findElement(By.xpath("//*[@class='button-exclusive btn btn-default']"));
		backToOrders.click();

		// SCREENSHOT - ALL ORDERS
		this.screenshot(driver, path + "11-AllOrders.png");

	}

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

}

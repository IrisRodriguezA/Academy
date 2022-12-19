package AdvantageOnlineShopping;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

public class shoppingCart {
	WebDriver driver;
	String path = "C:\\Selenium Training\\shoppingCart Screenshots\\";

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

	public void screenshot(WebDriver webdriver, String pathToFile) throws Exception {

		// CONVERT THE DRIVER OBJECT TO TAKE SCREENSHOT
		TakesScreenshot capture = ((TakesScreenshot) webdriver);

		// CALL GETSCREENSHOTAS AS METHOD SO WE CAN CREATE IMAGE FILE
		File scrFile = capture.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(pathToFile);
		FileUtils.copyFile(scrFile, destinationFile);

	}

	public void screenshotElement(WebElement element, String pathToFile) throws Exception {

		// CONVER THE DRIVER OBJECT
		// TO TAKE SCREENSHOT
		TakesScreenshot capture = ((TakesScreenshot) element);

		// CALL GETSCREENSHOTAS AS METHOD SO WE CAN CREATE IMAGE FILE
		File scrFile = capture.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(pathToFile);
		FileUtils.copyFile(scrFile, destinationFile);

	}

	@Test
	public void shoppingCartItems() throws Exception {
		String URL = "https://www.advantageonlineshopping.com/#/";
		System.out.println("Navigating to Advantage Online Shopping");
		driver.navigate().to(URL);

		// SETTING THE IMPLICIT WAIT FOR ALL OBJECTS
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(ElementNotInteractableException.class);

		// WAIT FOR INVISIBILITY OF LOADING MESSAGE
		wait.until(ExpectedConditions.attributeToBe(By.xpath("(//div[@class='loader'])[1]"), "style",
				"display: none; opacity: 0;"));

		// WAIT FOR VISIBILITY OF CONTACT US BUTTON
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@translate='CONTACT_US']")));

		// SCREENSHOT
		this.screenshot(driver, path + "initialScreen.png");

//		List<WebElement> link = driver.findElements(By.xpath("//a[@href]"));
//		System.out.println("href for first link: "+ link.get(0).getAttribute("href"));
//		
//		System.out.println(link.size());

		// CLICK USER MENU
		WebElement userMenu = driver.findElement(By.id("menuUserSVGPath"));
		userMenu.click();

		// ENTER USER NAME
		WebElement usernameInput = driver.findElement(By.name("username"));
		usernameInput.sendKeys("itstark");

		// SCREENSHOT
		this.screenshotElement(usernameInput, path + "user.png");

		// ENTER PASSWORD
		WebElement passwordInput = driver.findElement(By.name("password"));
		passwordInput.sendKeys("Itstark123");

		// WAIT FOR CART PAGE
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(6), Duration.ofSeconds(3));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='SIGN IN']")));

		// CLICK SIGN IN BUTTON
		WebElement signInButton = driver.findElement(By.xpath("//button[text()='SIGN IN']"));
		signInButton.click();

		// WAIT FOR POP UP UP DISSAPPEARS
		WebDriverWait waitPopUp = new WebDriverWait(driver, Duration.ofSeconds(6), Duration.ofSeconds(3));
		waitElement
				.until(ExpectedConditions.attributeToBe(By.xpath("//div[@class='PopUp']"), "style", "display: none;"));

		// CLICK CART BUTTON
		WebElement cartButton = driver.findElement(By.id("menuCart"));
		cartButton.click();

		// WAIT FOR CART PAGE
		WebDriverWait waitPage = new WebDriverWait(driver, Duration.ofSeconds(6), Duration.ofSeconds(3));
		waitPage.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'SHOPPING CART')]")));

		WebElement headerCart = driver.findElement(By.xpath("//h3[contains(text(),'SHOPPING CART')]"));
		headerCart.click();

		// WAIT FOR TOOLTIP CART IS NOT VISIBLE
		waitPopUp.until(ExpectedConditions.attributeContains(By.id("toolTipCart"), "style", "display: none;"));

		List<WebElement> elementList = driver.findElements(
				By.xpath("//table[@class= 'fixedTableEdgeCompatibility']/tbody/tr[position()=1]/td/child::*"));
		System.out.println("Count of found elements: " + elementList.size());

		// PRINT DATA IN THE OUTPUT
		for (WebElement element : elementList) {
			System.out.println("Class: " + element.getText());
		}

		List<WebElement> removeButtonList = driver.findElements(By.xpath("//a[@translate='REMOVE']"));
		int countOfRemoveButtons = removeButtonList.size();

		// CLICK ON REMOVE BUTTON
		for (int row = 1; row <= countOfRemoveButtons; row++) {
			removeButtonList = driver.findElements(By.xpath("//a[@translate='REMOVE']"));
			removeButtonList.get(0).click();
		}
	}
}

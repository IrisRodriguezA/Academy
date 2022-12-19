package library;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Driver {
	WebDriver driver;

	public WebDriver initFirefoxDriver() {
		String URL = "https://www.advantageonlineshopping.com/#/";

		System.out.println("Setting gecko driver path...");
		System.setProperty("webdriver.gecko.driver",
				"C:\\Selenium Training\\geckodriver-v0.31.0-win64\\geckodriver.exe");

		System.out.println("Creating driver...");
		driver = new FirefoxDriver();
		driver.navigate().to(URL);
		driver.manage().window().maximize();

		System.out.println("Waiting for page to be ready...");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(ElementNotInteractableException.class);

		// WAIT FOR INVISIBILITY OF LOADING MESSAGE
		wait.until(ExpectedConditions.attributeToBe(By.xpath("(//div[@class='loader'])[1]"), "style",
				"display: none; opacity: 0;"));

		// WAIT FOR VISIBILITY OF CONTACT US BUTTON
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@translate='CONTACT_US']")));

		// WEBPAGE IS READY AT THIS POINT
		System.out.println("Page is ready");
		return driver;
	}

	public void teardownDriver() {

		driver.close();
		driver = null;
	}

}

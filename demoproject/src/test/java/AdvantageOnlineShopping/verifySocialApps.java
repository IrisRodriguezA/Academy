package AdvantageOnlineShopping;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class verifySocialApps {

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

	@Test
	public void verifySocialAppsFromContactUsScreen() {
		String URL = "https://www.advantageonlineshopping.com/#/";

		System.out.println("Navigating to Advantage Online Shopping");
		driver.navigate().to(URL);

		// SETTING THE IMPLICIT WAIT FOR ALL OBJECTS
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(ElementNotInteractableException.class);

		// WAIT FOR INVISIBILITY OF LOADING MESSAGE
		wait.until(ExpectedConditions.attributeToBe(By.xpath("//div[@class='loader']"), "style",
				"display: none; opacity: 0;"));

		// WAIT FOR VISIBILITY OF CONTACT US BUTTON
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@translate='CONTACT_US']")));

		// CLICK THE CONTACT US BUTTON
		WebElement contactUSButton = driver.findElement(By.xpath("//a[@translate='CONTACT_US']"));
		contactUSButton.click();

		String mainWindow = driver.getWindowHandle();

		// EXPLICIT WAIT
		WebDriverWait waitFor = new WebDriverWait(driver, Duration.ofSeconds(4), Duration.ofSeconds(2));

		// WAIT FOR FACEBOOK BUTTON
		waitFor.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@name='follow_facebook']/..")));

		// CLICK THE CONTACT US FACEBOOK BUTTON
		System.out.println("Click facebook button");
		WebElement facebookButton = driver.findElement(By.xpath("//img[@name='follow_facebook']"));
		facebookButton.click();

		// WAIT FOR THE NEW OPENED WINDOW
		waitFor.until(ExpectedConditions.numberOfWindowsToBe(2));

		for (String windowHandle : driver.getWindowHandles()) {
			if (mainWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;

			}
		}

		WebElement facebookContactUsButton = driver.findElement(By.xpath("//span[text()='Contactarnos']"));

		if (facebookContactUsButton.isDisplayed())
			System.out.println("PASSED: The Facebook contact button is displayed");
		else
			Assert.fail("FAILED: the facebook contact button was not displayed");

		// CLOSE FACEBOOK WINDOW
		driver.close();

		// SWITCH TO THE MAIN WINDOW
		driver.switchTo().window(mainWindow);

		System.out.println("Click twitter button");
		WebElement twitterButton = driver.findElement(By.xpath(""));
		twitterButton.click();

		// WAIT FOR THE NEW OPENED WINDOW
		waitFor.until(ExpectedConditions.numberOfWindowsToBe(2));

		for (String windowHandle : driver.getWindowHandles()) {
			if (mainWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;

			}
		}

		WebElement twitterLabel = driver.findElement(By.xpath("(//span[text()='Micro Focus'])[1]"));
		if (twitterLabel.isDisplayed())
			System.out.println("PASSED: The twitter page was opened sucessfully");
		else
			Assert.fail("FAILED: Twitter page was not opened");

		// CLOSE TWITTER WINDOW
		driver.close();

		// SWITCHVTO MAIN WINDOW
		driver.switchTo().window(mainWindow);
	}

}

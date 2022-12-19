package uploadDownload;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class homeworkDownload {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Selenium Training\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@Test
	public void downloadFile() {
		String URL = "https://ftp.mozilla.org/pub/firefox/releases/";

		System.out.println("Navigating to upload page");
		driver.navigate().to(URL);

		// SETTING THE IMPLICIT WAIT FOR ALL OBJECTS
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// ENTER TO THE FIRST DIRECTORY
		WebElement firstResult = driver.findElement(By.xpath("(//a)[2]"));
		firstResult.click();

		String command = "cmd /c c:\\Seleni~1\\wget.exe -P \"C:\\Selenium Training\" --no-check-certificate http://ftp.mozilla.org/pub/firefox/releases/0.10.1/Firefox%201.0PR.dmg.gz";

		try {
			Process downloadFile = Runtime.getRuntime().exec(command);
			int waitForDownload = downloadFile.waitFor();

			if (waitForDownload == 0)
				System.out.println("Passed: File is download");
			else
				Assert.fail("Failed: the files was not downloaded");

		} catch (InterruptedException | IOException ex) {
			System.out.println(ex.toString());

		}

	}

	@AfterClass
	public void tearDown() {
		driver.quit();

	}

}

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

public class uploadFile {

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

	public void uploadNewFile() {

		String URL = "https://demo.guru99.com/test/upload/";

		System.out.println("Navigating to upload page");
		driver.navigate().to(URL);

		// SETTING THE IMPLICIT WAIT FOR ALL OBJECTS
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement inputUpload = driver.findElement(By.id("uploadfile_0"));
		inputUpload.sendKeys("C:\\Users\\irisr\\Downloads\\jisoo-rose.jpg");

		// CLICK THE CHECKBOX TO ACCEPT TERMS
		WebElement acceptTerms = driver.findElement(By.id("terms"));
		acceptTerms.click();

		// CLICK SUBMIT BUTTON
		WebElement submitButton = driver.findElement(By.id("submitbutton"));
		submitButton.click();

		WebElement verifyResult = driver.findElement(By.id("res"));

		Assert.assertTrue(verifyResult.getText().contains("has been successfully uploaded"),
				"Failed: The file failed to upload");

		if (verifyResult.getText().contains("has been successfully uploaded")) {
			System.out.println("Passed: File has been uploaded");
		} else {
			Assert.fail("Failed: the file failed to upload");
		}
	}

	@Test
	public void downloadFile() {
		// SETTING THE IMPLICIT WAIT FOR ALL OBJECTS
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String command = "cmd /c c:\\Seleni~1\\wget.exe -P \"C:\\Selenium Training\" --no-check-certificate http://demo.guru99.com/selenium/msgr11us.exe";

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
}
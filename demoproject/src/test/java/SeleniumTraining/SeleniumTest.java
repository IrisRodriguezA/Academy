package SeleniumTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumTest {

	WebDriver driver;
	String URL;

//	@Test
//	public void amazonTest() throws InterruptedException {
//		URL = "http://amazon.com";
//		driver.navigate().to(URL);
//		String getTitle = driver.getTitle();
//		System.out.println("URL:" + getTitle);
//
//		WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
//
//		searchInput.sendKeys("catnip");
//
//		WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
//
//		searchButton.click();
//
//		Thread.sleep(7000);
//
//		WebElement firstResult = driver
//				.findElement(By.xpath("(//*[@class= 'a-size-mini a-spacing-none a-color-base s-line-clamp-3'])[1]"));
//
//		firstResult.click();
//
//	}

	@Test
	public void googleImageTest() throws InterruptedException {
		URL = "https://www.google.com.mx/imghp?hl=es-419&authuser=0&ogbl";
		driver.navigate().to(URL);
		String getTitle = driver.getTitle();
		System.out.println("URL:" + getTitle);

		WebElement searchInput = driver.findElement(By.name("q"));
		searchInput.sendKeys("tiger");

		WebElement searchButton = driver.findElement(By.xpath("//*[@class='Tg7LZd']"));
		searchButton.click();
		Thread.sleep(7000);

		WebElement firstResult = driver.findElement(By.xpath("//*[@class='isv-r PNCib MSM1fd BUooTd'][8]"));
		firstResult.click();

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
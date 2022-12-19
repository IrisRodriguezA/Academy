package pageObjectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ADProductsPage {
	WebDriver driver;

	public ADProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "tabletsImg")
	WebElement tabletsButton;

	private WebElement getTablesButton() {
		return tabletsButton;
	}

	public void clickTabletsButton() {
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.id("tabletsImg")));

		System.out.println("Clicking tablets button");
		getTablesButton().click();

	}

	@FindBy(xpath = "(//*[@class='AddToCard'])[1]")
	WebElement firstTablet;

	private WebElement getfirstTablet() {
		return firstTablet;
	}

	public void clickFirstTabletButton() {
		WebDriverWait waitFirstTablet = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
		waitFirstTablet.until(ExpectedConditions.visibilityOfElementLocated(By.className("imgProduct")));

		System.out.println("Selecting first tablet...");
		getfirstTablet().click();
		
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='ADD TO CART']")));
		
	}
}

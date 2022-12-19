package pageObjectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ADProductDetailsPage {
	WebDriver driver;

	public ADProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "save_to_cart")
	WebElement addToCartButton;

	private WebElement getaddToCart() {
		return addToCartButton;
	}

	public void clickAddToCart() {
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='ADD TO CART']")));
		
		System.out.println("Adding product to cart...");
		getaddToCart().click();
		
	}
}

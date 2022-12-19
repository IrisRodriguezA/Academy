package pageObjectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AOSMyAccountPage {
	WebDriver driver;

	public AOSMyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// EDIT ACCOUNT DETAILS BUTTON
	@FindBy(xpath = "//*[@href='#/accountDetails']")
	WebElement editAccountDetailsButton;//

	public WebElement geteditAccountDetailsButton() {
		return editAccountDetailsButton;
	}

	public void clickAccountDetailsButton() {
		System.out.println("Click en edit button");
		geteditAccountDetailsButton().click();
	}

	// EDIT PAYMENT BUTTON
	@FindBy(xpath = "//*[@href='#/accountPaymentEdit']")
	WebElement editPaymentDetailsButton;

	public WebElement getPaymentDetailsButton() {
		return editPaymentDetailsButton;
	}

	public void clickPaymentDetailsButton() {

		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(6), Duration.ofSeconds(3));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'MY ACCOUNT')]")));

		System.out.println("Click on edit payment button");
		getPaymentDetailsButton().click();

	}

	

}

package pageObjectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


public class ADInfoOrderPage {

	WebDriver driver;

	public ADInfoOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[@id='trackingNumberLabel']")
	WebElement trackingNumberLabel;

	private WebElement getTrackingNumber() {
		return trackingNumberLabel;
	}

	public void LabelTrackingNumber() {
		
		Wait<WebDriver> wait= new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(ElementNotInteractableException.class);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='ORDER PAYMENT']")));
		
		Wait<WebDriver> wait2= new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(ElementNotInteractableException.class);
	   wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@class='loader']"),"style","display: none; opacity: 0;"));
	   
		System.out.println("Your tracking number is "+getTrackingNumber().getText());		
		//System.out.println(" "+getTrackingNumber().getAttribute("innerHTML"));
	}
	
	@FindBy(xpath = "//label[@id='orderNumberLabel']")
	WebElement orderNumberLabel;

	private WebElement getOrderNumberLabel() {
		return orderNumberLabel;
	}

	public void LabelOrderNumber() {
		
		Wait<WebDriver> wait= new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(ElementNotInteractableException.class);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='ORDER PAYMENT']")));
		
		Wait<WebDriver> wait2= new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(ElementNotInteractableException.class);
	   wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@class='loader']"),"style","display: none; opacity: 0;"));
	   
		System.out.println("Your order number is "+getOrderNumberLabel().getText());	
		//System.out.println(" "+getOrderNumberLabel().getAttribute("innerHTML"));
		
	}
	
	@FindBy(xpath = "//span[text()='Thank you for buying with Advantage']")
	WebElement messageThankYou;

	private WebElement getmessageThankYou() {
		return messageThankYou;
	}

	public void MessageThankYou() {
		
		Wait<WebDriver> wait= new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(ElementNotInteractableException.class);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='ORDER PAYMENT']")));
		
		Wait<WebDriver> wait2= new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(ElementNotInteractableException.class);
	   wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@class='loader']"),"style","display: none; opacity: 0;"));
	   
		System.out.println(" "+getmessageThankYou().getText());	
		//System.out.println(" "+getmessageThankYou().getAttribute("innerHTML"));
		
	}

}
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
import org.openqa.selenium.support.ui.WebDriverWait;

public class ADOrderPaymentPage {
	WebDriver driver;

	public ADOrderPaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='shoppingCartLink']")
	WebElement iconcart;

	private WebElement getIconCart() {
		return iconcart;
	}

	public void clickIconCart() {

		getIconCart().click();

		Wait<WebDriver> wait= new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(ElementNotInteractableException.class);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='checkOutButton']")));
		
		Wait<WebDriver> wait2= new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(ElementNotInteractableException.class);
	   wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@class='loader']"),"style","display: none; opacity: 0;"));
		
		System.out.println("Selecting icon cart...");
		
		}

	@FindBy(xpath = "//button[@id='checkOutButton']")
	WebElement checkOutButton;

	private WebElement getCheckOutButton() {
		return checkOutButton;
	}

	public void clickCheckOutButton() {
		getCheckOutButton().click();
		
		Wait<WebDriver> wait= new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(ElementNotInteractableException.class);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='ORDER PAYMENT']")));
		
		Wait<WebDriver> wait2= new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(ElementNotInteractableException.class);
	   wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@class='loader']"),"style","display: none; opacity: 0;"));
	   
	   System.out.println("Clicking checkout button...");
	}
	
	@FindBy(id = "next_btn")
	WebElement nextButton;
	
	private WebElement getNextButton() {
		return nextButton;
		
	}
	
	public void clickNextButton() {
		
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
		waitElement.until(ExpectedConditions.elementToBeClickable(By.id("next_btn"))); 
		
		getNextButton().click();
		System.out.println("Clicking NEXT button...");
		
	}
	
	@FindBy(xpath = "//*[@id='pay_now_btn_MasterCredit']")
	WebElement paynowButton;
	
	private WebElement getPayNowButton() { 
		return paynowButton;
	}
	
	public void clickPayNowButton() {
		getPayNowButton().click();
		
		Wait<WebDriver> wait= new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(ElementNotInteractableException.class);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='ORDER PAYMENT']")));
		
		Wait<WebDriver> wait2= new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(ElementNotInteractableException.class);
	   wait2.until(ExpectedConditions.attributeToBe(By.xpath("//div[@class='loader']"),"style","display: none; opacity: 0;"));
	   
		System.out.println("Clicking PAY NOW button...");

	}

}
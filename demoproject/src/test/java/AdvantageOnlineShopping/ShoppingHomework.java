package AdvantageOnlineShopping;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import library.Driver;
import pageObjectRepository.ADInfoOrderPage;
import pageObjectRepository.ADOrderPaymentPage;
import pageObjectRepository.ADProductDetailsPage;
import pageObjectRepository.ADProductsPage;
import pageObjectRepository.ADSignInPage;

public class ShoppingHomework extends Driver {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		// INITIALIZE WEBDRIVER
		this.driver = initFirefoxDriver();

	}

	@Test
	public void ShoppingHome() {

		//=====================DECLARAR LAS PAGINAS DE OBJETOS===================== 
		
		//SIGN IN PAGE
		ADSignInPage signInPage = new ADSignInPage(driver);
		
		// PRODUCTS PAGE
		ADProductsPage categoryTablets = new ADProductsPage(driver);
		
		// PRODUCT DETAILS PAGE
		ADProductDetailsPage productViewPage = new ADProductDetailsPage(driver);
		
		// PAYMMENT PAGE
		ADOrderPaymentPage orderpaymentPage = new ADOrderPaymentPage(driver);
		
		// INFO ORDER PAGE
		ADInfoOrderPage infoOrderPage = new ADInfoOrderPage(driver);

		
		
		// LLAMAR METODOS DE CADA PAGINA (EN ORDEN DE EJECUCION)
		
		//============================================SIGN IN PAGE============================================
		// CLICK USER BUTTON
		signInPage.clickUserButton();

		// ENTER USERNAME
		signInPage.enterUsernameInput("IrisRod");

		// ENTER PASSWORD
		signInPage.enterPasswordInput("Sooya12345");

		// CLICK SIGN IN BUTTON
		signInPage.clickSignInButton();

		//============================================CATEGORY TABLETS PAGE========================================
		// ENTER TABLETS IMAGE
		categoryTablets.clickTabletsButton();
		
		// SELECT FIRST TABLET
		categoryTablets.clickFirstTabletButton();
		
		//============================================PRODUCT DETAILS PAGE============================================
		// ADD TO CART PRODUCT 
		productViewPage.clickAddToCart();
		
		
		//============================================PAYMENT PAGE============================================
		// CLICK CHECKOUT POP UP
		orderpaymentPage.clickIconCart();
		
		// CLICK PAY NOW BUTTON
		orderpaymentPage.clickCheckOutButton();
		
		// CLICK NEXT BUTTON
		orderpaymentPage.clickNextButton();
		
		// CLICK PAY NOW BUTTON
		orderpaymentPage.clickPayNowButton();
		
		//============================================INFO-ORDER VIEW=========================================
		// VERIFY THE TRACKING NUMBER
		infoOrderPage.LabelTrackingNumber();
		
		//VERIFY THE NUMBER ORDER
		infoOrderPage.LabelOrderNumber();
		
		// MESSAGE THANK YOU FOR BUYING
		infoOrderPage.MessageThankYou();
	}

	@AfterClass
	public void teardown() {
		// teardownDriver();
	}
}

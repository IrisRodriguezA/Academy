package AdvantageOnlineShopping;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import library.Driver;
import pageObjectRepository.AOSMyAccountPage;
import pageObjectRepository.AOShomePage;

public class POMexcercise extends Driver {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		// INITIALIZE WEBDRIVER
		this.driver = initFirefoxDriver();

	}

	@Test
	public void POMExcerciseAOS() {

		AOShomePage homePage = new AOShomePage(driver);
		AOSMyAccountPage editPage = new AOSMyAccountPage(driver);

		// CLICK USER BUTTON
		homePage.clickUserButton();

		// ENTER USERNAME
		homePage.enterUsernameInput("IrisRod");

		// ENTER PASSWORD
		homePage.enterPasswordInput("Sooya12345");

		// CLICK SIGN IN BUTTON
		homePage.clickSignInButton();

		// USER NOW IS LOGGED IN
		// CLICK USER MENU BUTTON
		homePage.clickLoggedUserButton();

		// CLICK MY ACCOUNT FROM USER MENU
		homePage.clickMyAccountMenuButton();

		// CLICK EDIT ACCOUNT DETAILS BUTTON
		//editPage.clickAccountDetailsButton();

		// CLICK EDIT PAYMENT DETAILS BUTTON
		editPage.clickPaymentDetailsButton();
	}

	@AfterClass
	public void teardown() {
		// teardownDriver();
	}

}

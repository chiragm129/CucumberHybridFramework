package StepDefintions;

import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Duration;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {

	WebDriver driver;

	private LoginPage loginPage;
	private AccountPage accountPage;
	private HomePage homePage;
	private CommonUtils commonUtils;

	@Given("User has navigated to login page")
	public void user_has_navigated_to_login_page() {

		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.selectLoginOptions();
	}
	
	@When("^User enters valid email address (.+)$")
	public void user_enters_valid_email_address(String emailText) {
		
		loginPage.enterEmailAddress(emailText);
		
	}

	@And("^User has entered valid password (.+)$")
	public void user_has_entered_valid_password(String passwordText) {
		
		loginPage.enterPassword(passwordText);
		
	}

	@And("User clicks on login button")
	public void user_clicks_on_login_button() {

		accountPage = loginPage.clickOnLoginButton();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		
	    Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformation());
	}

	@When("User enters invalid email into email field")
	public void user_enters_invalid_email_into_email_field() {
		
		commonUtils = new CommonUtils();
		loginPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
	
	}

	@When("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPasswordText) {
		
		loginPage.enterPassword(invalidPasswordText);
	}

	@Then("User should get proper warning message about credentials mis match")
	public void user_should_get_proper_warning_message_about_credentials_mis_match() {

		Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password"));
	}

	@When("User dont enters email address into email field")
	public void user_dont_enters_email_address_into_email_field() {
		
		loginPage.enterEmailAddress("");
	}

	@When("User dont enters password into password field")
	public void user_dont_enters_password_into_password_field() {
		
		loginPage.enterPassword("");
	}


}

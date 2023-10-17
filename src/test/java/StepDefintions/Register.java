package StepDefintions;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sun.org.apache.xpath.internal.operations.String;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {

	WebDriver driver;
	private RegisterPage registerPage;
	private HomePage homePage;
	private AccountSuccessPage accountSuccessPage;
	private CommonUtils commonUtils;
	
	@Given("User navigates to Registration Page")
	public void user_navigates_to_registration_page() {
		
		driver = DriverFactory.getDriver();
		homePage.clickOnMyAccount();
		registerPage = homePage.selectRegisterOptions();
	}

	@When("User enters the details into below field")
	public void user_enters_the_details_into_below_field(DataTable dataTable) {

		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		registerPage.enterFirstName(dataMap.get("firstName").toString());
		registerPage.enterLastName(dataMap.get("lastName").toString());
		commonUtils = new CommonUtils();
		registerPage.enterEmail(commonUtils.getEmailWithTimeStamp().toString());
		registerPage.enterTelephone(dataMap.get("telephone").toString());
		registerPage.enterPassword(dataMap.get("password").toString());
		registerPage.enterConfirmPassword(dataMap.get("password").toString());

	}

	@When("User enters the details into below field with duplicate email")
	public void User_enters_the_details_into_below_field_with_duplicate_email(DataTable dataTable) {

		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		registerPage.enterFirstName(dataMap.get("firstName").toString());
		registerPage.enterLastName(dataMap.get("lastName").toString());
		registerPage.enterEmail(dataMap.get("email").toString());
		registerPage.enterTelephone(dataMap.get("telephone").toString());
		registerPage.enterPassword(dataMap.get("password").toString());
		registerPage.enterConfirmPassword(dataMap.get("password").toString());

	}

	@And("User selects Privacy Plicy")
	public void user_selects_privacy_plicy() {

		registerPage.selectPrivacyPolicy();
	}

	@And("User clicks on continue button")
	public void user_clicks_on_continue_button() {

		accountSuccessPage = registerPage.clickOnContinueButton();
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {

		Assert.assertEquals("Your Account Has Been Created", accountSuccessPage.getPageHeading());
	}

	@When("User selects yes for News Selecter")
	public void user_selects_yes_for_news_selecter() {

		registerPage.selectYesNewsLetter();
	}

	@Then("User account should get proper warning about duplicate email")
	public void user_account_should_get_proper_warning_about_duplicate_email() {

		Assert.assertTrue(registerPage.getWarningMessageText().contains("Warning: E-Mail Address is already registered"));
	}

	@When("User dont enter any details into field")
	public void user_dont_enter_any_details_into_field() {

		registerPage.enterFirstName("");
		registerPage.enterLastName("");
		registerPage.enterEmail("");
		registerPage.enterTelephone("");
		registerPage.enterPassword("");
		registerPage.enterConfirmPassword("");

	}

	@Then("User account should get proper warning for every mandatory field")
	public void user_account_should_get_proper_warning_for_every_mandatory_field() {

		Assert.assertTrue(registerPage.getWarningMessageText().contains("Warning: You must agree to the Privacy Policy"));
		Assert.assertEquals("First Name must be between 1 and 32 character!", registerPage.getFirstNameWarning());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerPage.getLastNameWarning());
		Assert.assertEquals("E-Mail Address does not appear to be valid!",registerPage.getEmailWarning());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerPage.getTelephoneWarning());
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerPage.getPasswordWarning());
				

	}

	private java.lang.String getEmailWithTimeStamp() {

		Date date = new Date();
		return "chirag123" + date.toString().replace(" ", "_").replace(":", "_") + "@gmail.com";
	}

}

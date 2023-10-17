package StepDefintions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchResultPage;

public class Search {
	
	WebDriver driver;
	private HomePage homePage;
	private SearchResultPage searchResultPage;
	
	@Given("User opens application")
	public void user_opens_application() {
		
		driver = DriverFactory.getDriver();
		
	}

	@When("User enters valid product {string} into search field")
	public void user_enters_valid_product_into_search_field(String validProductText) {
		
		homePage.enterProductIntoSearchBox(validProductText);
	}

	@And("User clicks on Search button")
	public void user_clicks_on_search_button() {
		
		searchResultPage = homePage.clickOnSearchButton();		
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
				
		Assert.assertTrue(searchResultPage.displayStatusOfValidProduct());
	}

	@When("User enters invalid product {string} into search field")
	public void user_enters_invalid_product_into_search_field(String invaliProductText) {
		
		homePage.enterProductIntoSearchBox(invaliProductText);
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		
		Assert.assertEquals("There is no product that matches the search criteria.", searchResultPage.getMessageText());
		
	}

	@When("User dont enter any product name into search bos field")
	public void user_dont_enter_any_product_name_into_search_bos_field() {
		
		//intentionally kept blank
		homePage = new HomePage(driver);
	}




}

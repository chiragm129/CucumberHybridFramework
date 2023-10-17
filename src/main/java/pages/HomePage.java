package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAcccountDropMenu;

	@FindBy(linkText = "Login")
	private WebElement loginOption;

	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	@FindBy(name = "search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//button[contains(@class,'btn-default')]")
	private WebElement searchButton;

	public void clickOnMyAccount() {

		elementUtils.clickOnElement(myAcccountDropMenu,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public LoginPage selectLoginOptions() {

		elementUtils.clickOnElement(loginOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new LoginPage(driver);
	}

	public RegisterPage selectRegisterOptions() {
		
		elementUtils.clickOnElement(registerOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new RegisterPage(driver);
	}
	
	public void enterProductIntoSearchBox(String ProductText) {
		
		elementUtils.typeTextIntoElement(searchBoxField, ProductText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public SearchResultPage clickOnSearchButton() {
		
		elementUtils.clickOnElement(searchButton,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new SearchResultPage(driver);
	}
}

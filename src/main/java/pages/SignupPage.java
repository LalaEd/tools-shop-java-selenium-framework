package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class SignupPage extends BasePage {
	
	
	//Locators
	
	private By firstNameTextBox = By.id("customer.firstName");
	private By lastNameTextBox = By.id("customer.lastName");
	private By addressTextBox = By.id("customer.address.street");
	private By cityTextBox = By.id("customer.address.city");
	private By stateTextBox = By.id("customer.address.state");
	private By zipCodeTextBox = By.id("customer.address.zipCode");
	private By phoneTextBox = By.id("customer.phoneNumber");
	private By socialNumberTextBox = By.id("customer.ssn");
	private By userNameTextBox = By.id("customer.username");
	private By passwordTextBox = By.id("customer.password");
	private By confirmPassTextBox = By.id("repeatedPassword");
	private By registerButton = By.cssSelector("input.button[value='Register']");
	private By usernameErrorMessage = By.id("customer.username.errors");
	private By lastNameErrorMessage = By.id("customer.lastName.errors");
	private By confirmationPasswortErrorMessage = By.id("repeatedPassword.errors");
	private By SocialSecurityNumberErrorMessage = By.id("customer.ssn.errors");
	
	//Actions
	
	public SignupPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void enterFirstName(String firstName) {
		driver.findElement(firstNameTextBox).clear();
		driver.findElement(firstNameTextBox).sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		driver.findElement(lastNameTextBox).clear();
		driver.findElement(lastNameTextBox).sendKeys(lastName);
	}
	
	public void enterAddress(String address) {
		driver.findElement(addressTextBox).clear();
		driver.findElement(addressTextBox).sendKeys(address);
	}
	
	public void enterCity(String city) {
		driver.findElement(cityTextBox).clear();
		driver.findElement(cityTextBox).sendKeys(city);
	}
	
	public void enterState(String state) {
		driver.findElement(stateTextBox).clear();
		driver.findElement(stateTextBox).sendKeys(state);
	}
	
	public void enterZip(String zipCode) {
		driver.findElement(zipCodeTextBox).clear();
		driver.findElement(zipCodeTextBox).sendKeys(zipCode);
	}
	
	public void enterPhone(String phoneNumber) {
		driver.findElement(phoneTextBox).clear();
		driver.findElement(phoneTextBox).sendKeys(phoneNumber);
	}
	
	public void enterSocialNumber(String socialNumber) {
		driver.findElement(socialNumberTextBox).clear();
		driver.findElement(socialNumberTextBox).sendKeys(socialNumber);
	}
	
	public void enterUsername(String username) {
		driver.findElement(userNameTextBox).clear();
		driver.findElement(userNameTextBox).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordTextBox).clear();
		driver.findElement(passwordTextBox).sendKeys(password);
	}
	
	public void enterPasswordConfirm(String passwordConfirm) {
		driver.findElement(confirmPassTextBox).clear();
		driver.findElement(confirmPassTextBox).sendKeys(passwordConfirm);
	}
	
	public void clickRegisterButton() {
		driver.findElement(registerButton).click();
	}
	
	public String validateUsernameError() {
		String actualText = wait.waitForElementVisible(usernameErrorMessage, 5).getText();
		return actualText;
	}
	
	public String validateLastNameError() {
		String actualText = wait.waitForElementVisible(lastNameErrorMessage, 5).getText();
		return actualText;
		
	}
	
	public String validateConfirationPasswordError() {
		String actualText = wait.waitForElementVisible(confirmationPasswortErrorMessage, 5).getText();
		return actualText;
		
	}
	
	public String validateSsnError() {
		String actualText = wait.waitForElementVisible(SocialSecurityNumberErrorMessage, 5).getText();
		return actualText;
		
	}
	

}

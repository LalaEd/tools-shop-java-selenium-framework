package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import base.BasePage;

public class HomePage extends BasePage {
	
	//Locators
	
	private By usernameTextBox = By.name("username");
	private By passwordTextBox = By.name("password");
	private By loginButton = By.xpath("//input[@value='Log In']");
	private By usernamePasswordErrorMessage = By.xpath("//p[@class='error']");
	private By logOutLink = By.linkText("Log Out");
	
	
	//Actions
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	public void enterUsername(String userName) {
		driver.findElement(usernameTextBox).clear();
		driver.findElement(usernameTextBox).sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordTextBox).clear();
		driver.findElement(passwordTextBox).sendKeys(password);
	}
	
	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
	
	public void clickLogoutLink() {
		driver.findElement(logOutLink).click();
	}
	
	
	public String validateUsernamePasswordErrorMessage() {
		String actualText = wait.waitForElementVisible(usernamePasswordErrorMessage, 5).getText();
		return actualText;
	}
	
	public String validatePageTitle() {
	    return wait.waitForPageTitle(5);
	}

	
	

}

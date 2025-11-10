package tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import utils.JsonDataReader;

public class LoginTest extends BaseTest {
	
	private HomePage homePage;
	
	@BeforeMethod
    public void navigateToHomePage() {
        driver.get(BASE_URL + "index.htm"); 
        homePage = new HomePage(driver);
    }
	
//	Test Data is located in folder  /src/test/resources/testdata/testData.json
	
	JSONObject validLoginData = JsonDataReader.getTestData("validUsernamePassword");
	JSONObject invalidLoginData = JsonDataReader.getTestData("invalidUsernamePassword");
	JSONObject pageTitles = JsonDataReader.getTestData("pageTitles");
	JSONObject errorMessages = JsonDataReader.getTestData("errorMessages");
	
	
//  There's a possibility that database is refreshed, so this test needs to be re-runned after Sign-up tests are executed
	
	@Test
	public void testValidLogin() {
		homePage.enterUsername((String) validLoginData.get("username"));
		homePage.enterPassword((String) validLoginData.get("password"));
		homePage.clickLoginButton();
		
		Assert.assertEquals(homePage.validatePageTitle(), pageTitles.get("accountsOwerview"));
		
		
	}
	
	@Test
	public void testValidLoginAndLogout() {
		homePage.enterUsername((String) validLoginData.get("username"));
		homePage.enterPassword((String) validLoginData.get("password"));
		homePage.clickLoginButton();
		Assert.assertEquals(homePage.validatePageTitle(), pageTitles.get("accountsOwerview"));
		homePage.clickLogoutLink();
		Assert.assertEquals(homePage.validatePageTitle(), pageTitles.get("welcomeTitle"));
		
		
	}
	
	@Test
	public void testInvalidLoginMissingUsername() {
		homePage.enterPassword((String) validLoginData.get("password"));
		homePage.clickLoginButton();
		
		Assert.assertEquals(homePage.validateUsernamePasswordErrorMessage(), errorMessages.get("missingUserNamePassword"));
		
		
	}
	
	@Test
	public void testInvalidLoginMissingPassword() {
		homePage.enterUsername((String) validLoginData.get("username"));
		homePage.clickLoginButton();
		
		Assert.assertEquals(homePage.validateUsernamePasswordErrorMessage(), errorMessages.get("missingUserNamePassword"));
		
		
	}
	
	@Test
	public void testInvalidLoginIncorrectPassword() {
		homePage.enterUsername((String) validLoginData.get("username"));
		homePage.enterPassword((String) invalidLoginData.get("password"));
		homePage.clickLoginButton();
		
		Assert.assertEquals(homePage.validateUsernamePasswordErrorMessage(), errorMessages.get("invalidUserNamePassword"));
		
		
	}
	
	@Test
	public void testInvalidLoginIncorrectUsername() {
		homePage.enterUsername((String) invalidLoginData.get("username"));
		homePage.enterPassword((String) validLoginData.get("password"));
		homePage.clickLoginButton();
		
		Assert.assertEquals(homePage.validateUsernamePasswordErrorMessage(), errorMessages.get("invalidUserNamePassword"));
		
		
	}

}

package tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import base.BaseTest;
import models.User;
import pages.SignupPage;
import utils.JsonDataReader;
import pages.HomePage;

public class SignupTest extends BaseTest {
    
    private SignupPage signupPage;
    private HomePage homePage;
    
    
    @BeforeMethod
    public void navigateToSignupPage() {
        driver.get(BASE_URL + "register.htm"); 
        signupPage = new SignupPage(driver);
        homePage = new HomePage(driver);
    }
    
//	Test Data is located in folder  /src/test/resources/testdata/testData.json
    
    JSONObject signupData = JsonDataReader.getTestData("signupData");
    JSONObject pageTitles = JsonDataReader.getTestData("pageTitles");
    JSONObject errorMessages = JsonDataReader.getTestData("errorMessages");
    
    
    public static User createRandomUser() {
    	
    	Faker faker = new Faker();
    	
    	 return new User(
    	            faker.name().firstName(),
    	            faker.name().lastName(),
    	            faker.address().streetAddress(),
    	            faker.address().city(),
    	            faker.address().state(),
    	            faker.address().zipCode(),
    	            faker.phoneNumber().cellPhone(),
    	            faker.idNumber().valid(),
    	            faker.name().username() + faker.number().randomNumber(3, true),
    	            faker.internet().password(8, 12, true, true, true)
    	        );
    	
    }
    
  
    @Test
    public void testValidSignupWithRandomData() {
    	User user = createRandomUser();
        signupPage.enterFirstName(user.getFirstName());
        signupPage.enterLastName(user.getLastName());
        signupPage.enterAddress(user.getAddress());
        signupPage.enterCity(user.getCity());
        signupPage.enterState(user.getState());
        signupPage.enterZip(user.getZip());
        signupPage.enterPhone(user.getPhone());
        signupPage.enterSocialNumber(user.getSsn());
        signupPage.enterUsername(user.getUsername());
        signupPage.enterPassword(user.getPassword());
        signupPage.enterPasswordConfirm(user.getPassword());
        signupPage.clickRegisterButton();

        Assert.assertEquals(homePage.validatePageTitle(), pageTitles.get("customerCreated"));
    }
    
//    Phone isn't a mandatory field
    
    @Test
    public void testValidSignupWithoutPhone() {
    	User user = createRandomUser();
        signupPage.enterFirstName(user.getFirstName());
        signupPage.enterLastName(user.getLastName());
        signupPage.enterAddress(user.getAddress());
        signupPage.enterCity(user.getCity());
        signupPage.enterState(user.getState());
        signupPage.enterZip(user.getZip());
        signupPage.enterSocialNumber(user.getSsn());
        signupPage.enterUsername(user.getUsername());
        signupPage.enterPassword(user.getPassword());
        signupPage.enterPasswordConfirm(user.getPassword());
        signupPage.clickRegisterButton();

        Assert.assertEquals(homePage.validatePageTitle(), pageTitles.get("customerCreated"));
    }
    
//  There's a possibility that database is refreshed, so this test needs to be re-runned from time to time
    
    @Test
    public void testExistingUserInvalidSignup() {
        
    	signupPage.enterFirstName((String) signupData.get("firstName"));
    	signupPage.enterLastName((String) signupData.get("lastName"));
    	signupPage.enterAddress((String) signupData.get("address"));
    	signupPage.enterCity((String) signupData.get("city"));
    	signupPage.enterState((String) signupData.get("state"));
    	signupPage.enterZip((String) signupData.get("zip"));
    	signupPage.enterPhone((String) signupData.get("phone"));
    	signupPage.enterSocialNumber((String) signupData.get("socialNumber"));
    	signupPage.enterUsername((String) signupData.get("username"));
    	signupPage.enterPassword((String) signupData.get("password"));
    	signupPage.enterPasswordConfirm((String) signupData.get("passwordConfirm"));
        signupPage.clickRegisterButton();
        
        Assert.assertEquals(signupPage.validateUsernameError(), errorMessages.get("existingUser"));
        
    }
    
    @Test
    public void testMissingLastNameInvalidSignup() {
    	
    	signupPage.enterFirstName((String) signupData.get("firstName"));
    	signupPage.enterAddress((String) signupData.get("address"));
    	signupPage.enterCity((String) signupData.get("city"));
    	signupPage.enterState((String) signupData.get("state"));
    	signupPage.enterZip((String) signupData.get("zip"));
    	signupPage.enterPhone((String) signupData.get("phone"));
    	signupPage.enterSocialNumber((String) signupData.get("socialNumber"));
    	signupPage.enterUsername((String) signupData.get("username"));
    	signupPage.enterPassword((String) signupData.get("password"));
    	signupPage.enterPasswordConfirm((String) signupData.get("passwordConfirm"));
        signupPage.clickRegisterButton();
        
        Assert.assertEquals(signupPage.validateLastNameError(), errorMessages.get("missingLastName"));
    }
    
    @Test
    public void testMissingPasswordConfirmationInvalidSignup() {
    	
    	signupPage.enterFirstName((String) signupData.get("firstName"));
    	signupPage.enterLastName((String) signupData.get("lastName"));
    	signupPage.enterAddress((String) signupData.get("address"));
    	signupPage.enterCity((String) signupData.get("city"));
    	signupPage.enterState((String) signupData.get("state"));
    	signupPage.enterZip((String) signupData.get("zip"));
    	signupPage.enterPhone((String) signupData.get("phone"));
    	signupPage.enterSocialNumber((String) signupData.get("socialNumber"));
    	signupPage.enterUsername((String) signupData.get("username"));
    	signupPage.enterPassword((String) signupData.get("password"));
        signupPage.clickRegisterButton();
        
        Assert.assertEquals(signupPage.validateConfirationPasswordError(),  errorMessages.get("missingPasswordConfirmation"));
    }
    
    @Test
    public void testMissingSsnInvalidSignup() {
    	
    	signupPage.enterFirstName((String) signupData.get("firstName"));
    	signupPage.enterLastName((String) signupData.get("lastName"));
    	signupPage.enterAddress((String) signupData.get("address"));
    	signupPage.enterCity((String) signupData.get("city"));
    	signupPage.enterState((String) signupData.get("state"));
    	signupPage.enterZip((String) signupData.get("zip"));
    	signupPage.enterPhone((String) signupData.get("phone"));
    	signupPage.enterUsername((String) signupData.get("username"));
    	signupPage.enterPassword((String) signupData.get("password"));
    	signupPage.enterPasswordConfirm((String) signupData.get("passwordConfirm"));
        signupPage.clickRegisterButton();
        
        Assert.assertEquals(signupPage.validateSsnError(),  errorMessages.get("missingSsn"));
    }
}

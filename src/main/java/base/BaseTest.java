package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
	
	protected WebDriver driver;

	protected final String BASE_URL = "https://parabank.parasoft.com/parabank/";
	
	@BeforeMethod
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(BASE_URL);
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		if (driver != null) {
			driver.quit();
		}
	}

}

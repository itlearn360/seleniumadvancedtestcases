package tstsuite;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class CloseDriver {
	private InitalizeDriver init;
	private WebDriver driver; 
	@BeforeTest
	public void init(){
		init = new InitalizeDriver();
	  driver = init.getDriver();
	}
	
	@AfterTest
	public void closeDriver(){
	  init.closeDriver();
	}
	
}

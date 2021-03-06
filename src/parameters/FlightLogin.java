package parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlightLogin {
     private WebDriver driver;
     private String url;
	@BeforeTest
	public void init(){
		System.setProperty("webdriver.gecko.driver", "E:\\Softwares\\geckodriver\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  url = "http://newtours.demoaut.com";
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
	@Parameters({"username","password"})
	public void executeTest(String username, String Password) {
		driver.get(url);
	    driver.findElement(By.name("userName")).clear();
	    driver.findElement(By.name("userName")).sendKeys(username);
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys(Password);
	    driver.findElement(By.name("login")).click();
	    driver.findElement(By.linkText("SIGN-OFF")).click();
	    
	}
	
	@AfterTest
	public void destroy(){
		driver = null;
		url = "";
		driver.close();
	}
}

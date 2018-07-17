package tstsuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlightLogin {
	 private InitalizeDriver init;
     private WebDriver driver;
     private String url;
	@BeforeTest
	public void init(){
		init = new InitalizeDriver();
		driver = init.getDriver();
		url = "http://newtours.demoaut.com";
	}
	@Test
	public void executeTest() {
		driver.get(url + "/");
	    driver.findElement(By.name("userName")).clear();
	    driver.findElement(By.name("userName")).sendKeys("jayant");
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("jayant");
	    driver.findElement(By.name("login")).click();
	    driver.findElement(By.linkText("SIGN-OFF")).click();
	}
	
	@AfterTest
	public void destroy(){
		driver = null;
		url = "";
	}
}

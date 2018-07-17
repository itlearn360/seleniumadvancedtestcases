package junitcon;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightLogin {
     private WebDriver driver;
     private String url;
	@Before
	public void init(){
		driver = JunitController.getDriver();
		url = JunitController.getUrl();
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
	
	@After
	public void destroy(){
		driver = null;
		url = "";
	}
}

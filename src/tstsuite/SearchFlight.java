package tstsuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchFlight {
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
	    driver.findElement(By.xpath("(//input[@name='tripType'])[2]")).click();
	    new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("Frankfurt");
	    new Select(driver.findElement(By.name("fromDay"))).selectByVisibleText("25");
	    driver.findElement(By.cssSelector("font > font > input[name=\"servClass\"]")).click();
	    new Select(driver.findElement(By.name("airline"))).selectByVisibleText("Unified Airlines");
	    driver.findElement(By.name("findFlights")).click();
	    driver.findElement(By.linkText("SIGN-OFF")).click();
	}
	
	@AfterTest
	public void destroy(){
		driver = null;
		url = "";
	}
}

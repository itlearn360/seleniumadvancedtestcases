package tstsuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InitalizeDriver {
	private static WebDriver driver;

	public InitalizeDriver() {
		if (driver == null) {
			System.setProperty("webdriver.gecko.driver", "E:\\Softwares\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}
	public WebDriver getDriver(){
		return driver;
	}
	public void closeDriver() {
		driver.quit();
		
	}
}

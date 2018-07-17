package junitcon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.xml.sax.SAXException;

public class JunitController {
	private static ConfigBean bean;
	private static ArrayList<String> classes;
	private static WebDriver driver;
	public static void main(String[] args) {
		JUnitCore junit = new JUnitCore();
		InputStream is;
		try {
			is = new FileInputStream(new File(".\\src\\junitcon\\config.xml"));
			Configuration fc = new Configuration(is);
			bean = fc.getConfiguration();
			classes = bean.getClassname();
			initDriver();
			for (int i = 0; i < classes.size(); i++) {
				Class classname = Class.forName(classes.get(i));
				Result test1res = junit.run(classname);
				if (test1res.wasSuccessful()) {
					System.out.println("Pass: " + classname.getName());
				} else {
					System.out.println("Fail: " + classname.getName());
				}
			}
			driver.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getUrl() {
		return bean.getUrl();
	}
	public static void initDriver() {
		System.setProperty("webdriver.gecko.driver", "E:\\Softwares\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(bean.getSteptime(), TimeUnit.SECONDS);

	}
	public static WebDriver getDriver(){
		return driver;
	}
}

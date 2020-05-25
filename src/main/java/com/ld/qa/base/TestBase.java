package com.ld.qa.base;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ld.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;

	Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase() throws FileNotFoundException {

		prop = new Properties();

		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/ld/qa/config/config.properties");
		try {
			prop.load(fis);
		} catch (IOException e) {
			System.out.println("The message from config file "+e.getMessage());
			e.printStackTrace();
		}
	}



	public void initialization() throws FileNotFoundException { //get the browser name from config file

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium JARS\\chromedriver_win32\\chromedriver.exe");

			driver = new ChromeDriver();

		}

		else if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","E:\\Selenium JARS\\geckodriver-v0.26.0-win64\\geckodriver.exe");

			driver = new FirefoxDriver();

		}
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}





}


package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.EventListener;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.util.TimeUtils;

import com.crm.qa.util.Testutil;
import com.crm.qa.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	 public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistener;
	
	public TestBase()  {
		prop=new Properties();
		try {
		FileInputStream fis=new FileInputStream("C:\\Sravanthi\\myworkspace\\FreeCRMTest\\"
				+ "src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(fis);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
	}
		
		e_driver=new EventFiringWebDriver(driver);
		eventlistener=new WebEventListener();
		e_driver.register(eventlistener);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.Page_Load_TimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.Implicit_Wait_TimeOut, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
}
}	
	

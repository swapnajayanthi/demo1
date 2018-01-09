package com.jayanthi.automation.driverengine;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jayanthi.automation.supporters.ScreenShotUtility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class DriverUtility {
	
	private static WebDriver webdriver;
	public static ExtentReports er;
	public static ExtentTest et;
	public static Logger log;
	@Parameters("browser")
	@BeforeSuite
	public void OpenBrowser(@Optional("firefox")String browser) // whenever we are run in testcase
	//public void OpenBrowser(String browser) // run in testng.xml
	{
		er = new ExtentReports("D:\\reports\\login.html");
		PropertyConfigurator.configure("C:\\Users\\jayanthi\\workspace\\Mysampleframework\\Log4j.propeties");
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			webdriver = new FirefoxDriver();
			webdriver.manage().window().maximize();
			webdriver.manage().deleteAllCookies();
			webdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files selenium\\chromedriver_win32\\chromedriver.exe");
			webdriver = new ChromeDriver();
			webdriver.manage().window().maximize();
			webdriver.manage().deleteAllCookies();
			webdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	   }
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Program Files selenium\\IEDriverServer_x64_3.7.0\\IEDriverServer.exe");
			webdriver = new InternetExplorerDriver();
			webdriver.manage().window().maximize();
			webdriver.manage().deleteAllCookies();
			webdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
	}
	public static WebDriver getWebDriver()
	{
		return webdriver;
	}
	@BeforeMethod
	public void beforeMethod(Method m) {
		m.getClass();
		et = er.startTest(m.getName());
		log = Logger.getLogger(m.getName());
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		er.endTest(et);
		er.flush();
		if(ITestResult.FAILURE==result.getStatus())
		{
			ScreenShotUtility.getScreenShot(result.getName(), webdriver);
		}
	}
		public static ExtentTest getExtentTest()
		{
			return et;	
		}
		public static Logger getLog()
		{
			return log;
			
		}
	@AfterSuite
	public void closeBrowser()
	{
		if(webdriver!=null)
		{
			webdriver.close();
			System.out.println("webdriver close");
		}else
		{
			System.out.println("webdriver is null");
		}
	}
	public static void main(String[] args) {
		{
			DriverUtility du = new DriverUtility();
			du.OpenBrowser("chrome");
			du.closeBrowser();
		}
	}

}

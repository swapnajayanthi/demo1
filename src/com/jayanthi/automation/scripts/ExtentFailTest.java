package com.jayanthi.automation.scripts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.MediaSize.Other;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jayanthi.automation.driverengine.DriverUtility;
import com.jayanthi.automation.reporters.ReportFunctions;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentFailTest{
	public static WebDriver d;
	public ExtentReports er;
	public ExtentTest et;
	 
	
	
	@BeforeTest
	public void browserLaunch()
	{
	  er = new ExtentReports("D:\\reports\\fail.html");
	}
	 @BeforeMethod
	 public void startTest()
	 {
		 System.setProperty("webdriver.chrome.driver", "C:\\Program Files selenium\\chromedriver_win32\\chromedriver.exe");
		 d = new ChromeDriver();
		 d.manage().window().maximize();
		 d.manage().deleteAllCookies();
		 d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS); 
	 }
	 @Test
	 public void gmailTest()
	 {
		 et = er.startTest("gmailTest");
		 d.get("https://www.gmail.com");
		 d.findElement(By.id("identifierId")).sendKeys("jayanthiashamolla@gmail.com");
		 et.log(LogStatus.INFO, "username entered");
		 d.findElement(By.xpath("//span[text()='Nex']")).click();
		 et.log(LogStatus.INFO, "next button clicked");
		 d.findElement(By.xpath("password")).sendKeys("abcd123");
		 et.log(LogStatus.INFO, "password entered");
	 }
	 
	 @Test
	 public void fbTest()
	 {
		 et = er.startTest("fbTest");
		 d.get("https://www.facebook.com");
		 d.findElement(By.xpath("//input[@id='email']")).sendKeys("jayanthiashamolla@gmail.com");
		 et.log(LogStatus.INFO, "fb username entered");
		 d.findElement(By.xpath("//input[@id='pass']")).sendKeys("abcd123");
		 et.log(LogStatus.INFO, "password entered");
	 }
	 public static String getScreenShot(String image, WebDriver driver) throws IOException
	 {
		TakesScreenshot ts =  (TakesScreenshot)d;
		File f = ts.getScreenshotAs(OutputType.FILE);
		String pic="D:\\screenshots\\"+image+".jpeg";
	    FileUtils.copyFile(f, new File(pic));
		
		return pic;
	 }
	 
	 @AfterMethod
	 public void reportswithScreenShot(ITestResult result) throws IOException
	 {
		 if(result.getStatus()==ITestResult.FAILURE)
		 {
			 System.out.println(result.getStatus());
			 et.log(LogStatus.FAIL, "failed method" +result.getMethod());
			 et.log(LogStatus.FAIL, "failed exceptions" +result.getThrowable());
			 String src = ExtentFailTest.getScreenShot(result.getName(), d);
			 et.log(LogStatus.FAIL, "screenshot" +et.addScreenCapture(src));
			 
		 }
		 else if(result.getStatus()==ITestResult.SUCCESS)
		 {
			 System.out.println(result.getStatus());
			 et.log(LogStatus.PASS, "pass method" +result.getMethod());
		 }
		 String src = ExtentFailTest.getScreenShot(result.getName(), d);
		 er.endTest(et);

	}
	 
	 
	@AfterTest
	 public void afterTest()
	 {
		 er.flush();
		 er.close();
	 }
}

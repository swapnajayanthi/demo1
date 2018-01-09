package com.jayanthi.automation.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportTest 
{
	public static void main(String[] args)
	{
		WebDriver driver=new FirefoxDriver();
		ExtentReports er=new ExtentReports("D:\\reports\\gmail.html");
		ExtentTest et=er.startTest("main");
		driver.get("https://www.gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys("jayanthiashamolla@gmail.com");
		et.log(LogStatus.INFO, "id entered");
		
		driver.findElement(By.id("identifierNext")).click();
		et.log(LogStatus.INFO,"sucessfullydone");
		er.endTest(et);
		er.flush();	
	}

}

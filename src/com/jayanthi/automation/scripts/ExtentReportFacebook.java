package com.jayanthi.automation.scripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.jayanthi.automation.driverengine.DriverUtility;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportFacebook extends DriverUtility {
	
	@Test
	public void login()
	{
	 getWebDriver().get("https://www.facebook.com");
	 DriverUtility.getExtentTest().log(LogStatus.INFO, "url is entered");
	 getWebDriver().findElement(By.xpath("//input[@id='email']")).sendKeys("jayanthiashamolla@gmail.com");
	 getWebDriver().findElement(By.xpath("//input[@id='pass']")).sendKeys("abcd123");
	 getWebDriver().findElement(By.xpath("//input[@id='u_0_2']")).click(); 
	 
	}

}

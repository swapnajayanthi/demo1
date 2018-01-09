package com.jayanthi.automation.scripts;

import org.testng.annotations.Test;

import com.jayanthi.automation.driverengine.DriverUtility;
import com.jayanthi.automation.reporters.ReportFunctions;
import com.relevantcodes.extentreports.LogStatus;

public class Log4jGmail extends DriverUtility{
	@Test
	public void login()
	{
		getWebDriver().get("https://www.gmail.com");
		DriverUtility.getExtentTest().log(LogStatus.INFO, "url is entered");
	    ReportFunctions.logInfo("url is entered");
	    ReportFunctions.lginfo("enter url", "entering url into the browser");
		
	}
}

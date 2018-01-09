package com.jayanthi.automation.reporters;

import com.jayanthi.automation.driverengine.DriverUtility;
import com.relevantcodes.extentreports.LogStatus;

public class ReportFunctions {
	static public void logInfo(String stepDetails)
	{
		DriverUtility.getExtentTest().log(LogStatus.INFO, stepDetails);
	}
	public static void lginfo(String stepName,String stepDetails) {
		DriverUtility.getExtentTest().log(LogStatus.INFO, stepName, stepDetails);
	}
}

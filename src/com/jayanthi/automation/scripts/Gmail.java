package com.jayanthi.automation.scripts;

import org.testng.annotations.Test;

import com.jayanthi.automation.driverengine.DriverUtility;

public class Gmail {
	@Test
	public void login()
	{
		DriverUtility du = new DriverUtility();
		du.getWebDriver().get("https://www.gmail.com");
	}

}

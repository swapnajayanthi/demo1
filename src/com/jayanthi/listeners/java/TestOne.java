package com.jayanthi.listeners.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestOne {
	@Test(retryAnalyzer==IretryTest.class)
	public void login()
	{
		WebDriver d = new FirefoxDriver();
		d.get("https://www.gmail.com");
		String actualTitle = d.getTitle();
		Assert.assertEquals(actualTitle, "mail");
	}

}

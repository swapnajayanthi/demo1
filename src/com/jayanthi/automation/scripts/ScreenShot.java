package com.jayanthi.automation.scripts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.jayanthi.automation.driverengine.DriverUtility;
import com.sun.jna.platform.FileUtils;
public class ScreenShot {
	public static void main(String[] args) throws IOException {
		WebDriver d;
	 d = new FirefoxDriver();
     d.get("https://www.gmail.com");
	    TakesScreenshot t = (TakesScreenshot)d;
		File f = t.getScreenshotAs(OutputType.FILE);
		org.apache.commons.io.FileUtils.copyFile(f, new File("D:\\Drivers\\xyz.jpeg"));
	}
	
}

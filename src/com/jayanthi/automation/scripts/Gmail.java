package com.jayanthi.automation.scripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;
import com.jayanthi.automation.driverengine.DriverUtility;
import com.jayanthi.automation.reporters.ReportFunctions;
import com.jayanthi.automation.utilities.PropertiesFunction;
import com.relevantcodes.extentreports.LogStatus;

public class Gmail extends DriverUtility {
	@Test
	public void login() throws IOException, EncryptedDocumentException, InvalidFormatException
	{
	getWebDriver().get("https://www.gmail.com");
	DriverUtility.getExtentTest().log(LogStatus.INFO, "url is entered");
	ReportFunctions.logInfo("url is entered");
	ReportFunctions.lginfo("url entered", "enter into the browser");
	FileInputStream fis = new FileInputStream("C:\\Users\\jayanthi\\workspace\\Mysampleframework\\src\\com\\jayanthi\\automation\\objectrepository\\OR.Gmail_Test.properties");
	Properties p = new Properties();
	p.load(fis);
	String gmail_username = p.getProperty("username");
    ReportFunctions.logInfo(gmail_username);
	String gmail_data = p.getProperty("data");
    ReportFunctions.logInfo(gmail_data);
	getWebDriver().findElement(By.cssSelector(gmail_username)).sendKeys(gmail_data);
	ReportFunctions.lginfo(gmail_username, gmail_data);
	String gmail_next = p.getProperty("next");
	getWebDriver().findElement(By.xpath(gmail_next)).click();

	String gmail_password = p.getProperty("password");
	String gmail_pwddata = p.getProperty("pwddata");
	getWebDriver().findElement(By.xpath(gmail_password)).sendKeys(gmail_pwddata);
	ReportFunctions.lginfo(gmail_password, gmail_pwddata);
      
	String gmail_signIn = p.getProperty("signIn");
    getWebDriver().findElement(By.xpath(gmail_signIn)).click();
	ReportFunctions.logInfo(gmail_signIn);
	
	
	
	
	
	
	
	
	
	
	}

}

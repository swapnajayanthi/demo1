package com.jayanthi.automation.scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.jayanthi.automation.driverengine.DriverUtility;
import com.jayanthi.automation.supporters.ValidationsUtility;

public class GmailTest2 extends DriverUtility {

	@Test
	public void test() throws IOException
	{
		String email=null;
		getWebDriver().get("https://www.gmail.com");
		FileInputStream fis = new FileInputStream("C:\\Users\\jayanthi\\workspace\\Mysampleframework\\src\\com\\jayanthi\\automation\\objectrepository\\OR.Gmail_Test.properties");
		Properties p = new Properties();
		p.load(fis);
		/*String username = p.getProperty("username_css");
		System.out.println("gmail username is:"+username);*/
		WebElement username = getWebDriver().findElement(By.cssSelector("username"));
		String beforeValue = username.getAttribute("Value");
		System.out.println("before DTA :"+beforeValue);
		username.sendKeys("username_data");
		String afterValue = username.getAttribute("Value");
		System.out.println("after DTA:"+afterValue);
		if(afterValue.equalsIgnoreCase(email))
		{
			System.out.println("entered our test data properly");
		}
		else
		{
			System.out.println("not done properly");
		}
		er.startTest(
		

		
		
		
		
		
		
	}


}

package com.jayanthi.automation.scripts;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.jayanthi.automation.driverengine.DriverUtility;
import com.jayanthi.automation.utilities.PropertiesFunction;
import com.jayanthi.automation.utilities.TextFilesUtility;

public class AmazonTest extends DriverUtility  {
	@Test
public void test() throws IOException

	{

	getWebDriver().get("https://www.amazon.com");
    PropertiesFunction pf = new PropertiesFunction("C:\\Users\\jayanthi\\workspace\\Mysampleframework\\src\\com\\jayanthi\\automation\\objectrepository\\OR.Amazon.properties");
    String dept = pf.getProperty("amazon_dept");
   WebElement departments =  getWebDriver().findElement(By.xpath(dept));
   Actions a = new Actions(getWebDriver());
   a.moveToElement(departments).build().perform();
   System.out.println("mouse over on departments");
   String text = departments.getText();
   
   TextFilesUtility tf = new TextFilesUtility("C:\\Users\\jayanthi\\workspace\\Mysampleframework\\src\\com\\jayanthi\\automation\\objectrepository\\Amazon.txt");
    tf.writeData(text);
    tf.getData();
 
  	}
    
}


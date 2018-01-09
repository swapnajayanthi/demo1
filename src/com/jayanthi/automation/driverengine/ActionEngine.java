package com.jayanthi.automation.driverengine;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.jayanthi.automation.driverengine.DriverUtility;


public class ActionEngine extends DriverUtility {
	static Actions actions = new Actions(getWebDriver());
	static WebElement element;
	public ActionEngine()
	{
		
	}
	//locatorMechanism = element location type(id,xpath,css....)
	//testData = data files
	//locator = element location (id,name,classname..etc)
	public static void sendKeysAction(String locatorMechanism, String testData, String locator)
	{
		String locMech = locatorMechanism;
		switch(locMech)
		{
		case "id":
			           element = getWebDriver().findElement(By.id(locator));
			           if (element.isDisplayed()&&element.isEnabled())
			           {
				       element.clear();
				       element.sendKeys(testData);
			           }
			         break;
		case "css":
			           element = getWebDriver().findElement(By.cssSelector(locator));
	                   if (element.isDisplayed()&&element.isEnabled()) 
	                  {
		               element.clear();
		               element.sendKeys(testData);
	                   }
	                 break;
		case "xpath":
			           element = getWebDriver().findElement(By.xpath(locator));
			           if(element.isDisplayed() && element.isEnabled())
			           {
			        	   element.clear();
			        	   element.sendKeys(testData);
			           }
			           break;
		case "className":
			          element = getWebDriver().findElement(By.className(locator));
			          if(element.isDisplayed() && element.isEnabled())
			          {
			        	  element.clear();
			        	  element.sendKeys(testData);
			          }
			          break;
		case "name":
	                   element = getWebDriver().findElement(By.name(locator));
	                   if(element.isDisplayed() && element.isEnabled())
	                  {
	        	       element.clear();
	        	       element.sendKeys(testData);
	                  }
	                  break;
		case "linkText":
                      element = getWebDriver().findElement(By.linkText(locator));
                      if(element.isDisplayed() && element.isEnabled())
                      {
 	                 element.clear();
 	                 element.sendKeys(testData);
                       }
                    break;
		case "partialLinkText":
                    element = getWebDriver().findElement(By.partialLinkText(locator));
                    if(element.isDisplayed() && element.isEnabled())
                    {
 	               element.clear();
 	               element.sendKeys(testData);
                 }
                  break;
		}
	}
	public static void clickAction(String locatorMechanism, String locator)
	{
		String locMech = locatorMechanism;
		switch(locMech)
		{
		case "id":
			           element = getWebDriver().findElement(By.id(locator));
			           if (element.isDisplayed()&&element.isEnabled())
			           {
				       element.click();
			           }
			         break;
		case "css":
			           element = getWebDriver().findElement(By.cssSelector(locator));
	                   if (element.isDisplayed()&&element.isEnabled()) 
	                  {
	                   element.click();
		             
	                   }
	                 break;
		case "xpath":
			           element = getWebDriver().findElement(By.xpath(locator));
			           if(element.isDisplayed() && element.isEnabled())
			           {
			        	   element.click();
			           }
			           break;
		case "className":
			          element = getWebDriver().findElement(By.className(locator));
			          if(element.isDisplayed() && element.isEnabled())
			          {
			        	  element.click();
			        	  
			          }
			          break;
		case "name":
	                   element = getWebDriver().findElement(By.name(locator));
	                   if(element.isDisplayed() && element.isEnabled())
	                  {
	        	       element.click();
	        	       
	                  }
	                  break;
		case "linkText":
                      element = getWebDriver().findElement(By.linkText(locator));
                      if(element.isDisplayed() && element.isEnabled())
                      {
 	                 element.click();
 	                
                       }
                    break;
		case "partialLinkText":
                    element = getWebDriver().findElement(By.partialLinkText(locator));
                    if(element.isDisplayed() && element.isEnabled())
                    {
 	               element.click();
 	              
                 }
                  break;
		}
	}
	public static void windowHandles(int index)
	{
		Set<String> windows = getWebDriver().getWindowHandles();
		List<String> list = new ArrayList<String>(windows);
	   String	 windowName = list.get(index);
	   getWebDriver().switchTo().window(windowName);
	}
	public static List<WebElement> getAllFrames()
	{
		List<WebElement> frames = getWebDriver().findElements(By.tagName("iframe"));
		return frames;
	}
	public static void switchToFrame (String locatorMech, String locator)
	{
		switch(locatorMech)
		{
		case "idORname": 
			              getWebDriver().switchTo().frame(locator);
			              break;
		case "index":
			             if(getAllFrames().size()>=Integer.parseInt(locator))
			             {
			            	 getWebDriver().switchTo().frame(locator);
			             }
			             break;
		case "webelement":
			            getWebDriver().switchTo().frame(locator);
			            break;
		}
	}
	public static void screenShot(String imgName) throws IOException
	{
		TakesScreenshot t = (TakesScreenshot)getWebDriver();
		File f = t.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File(""));
		
	}

	public static void dropDown(WebElement elementone,String dropDownSelect,String dropDownData)
	{
		String tagName = elementone.getTagName();
		if (tagName.equalsIgnoreCase("select")) {
			Select select = new Select(elementone);

switch(dropDownSelect)
{
case "value":
	select.selectByValue(dropDownData);
	break;
case "text":
	select.selectByVisibleText(dropDownData);
	break;
case "index":
	select.selectByIndex(Integer.parseInt(dropDownData));
	break;
}
		}
	}
	
	public static void mouseOver(WebElement elementone)
	{
		actions.moveToElement(elementone).build().perform();
	}
	
	public static void rightClick(WebElement elementOne)
	{
		
		actions.contextClick(elementOne).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).perform();
	}

	public static boolean isDisplayed(WebElement element)
	{
		boolean flag=true;
		if (element.isDisplayed()&&element.isEnabled());
		else
			flag=false;
		return flag;
	}
	
	public static void enterUrl(String url)
	{
		getWebDriver().get(url);
	}
	public static void  clickableActions(WebElement elementOne, String locator)
	{
		actions.click(elementOne).sendKeys().build().perform();
       getWebDriver().findElement(By.id(locator));
      // actions.clickAndHold(elementOne).build().perform();
      // actions.doubleClick(elementOne).perform();
      // actions.dragAndDrop(elementOne, element).build().perform();
       actions.sendKeys(locator, Keys.ENTER).build().perform(); 
	}
	public void DataTypingActions(String value1, String value2, String locator)
	{
		String beforeValue = value1;
		String afterValue = value2;
		
		WebElement ele = getWebDriver().findElement(By.id(locator));
		
		if(afterValue.equalsIgnoreCase(locator))
				{
			System.out.println("datatyping action is performed");
				}
		else
		{
			System.out.println("datatyping action not performed");
		}

	}
	
	

}

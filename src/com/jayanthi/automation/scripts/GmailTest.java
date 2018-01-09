package com.jayanthi.automation.scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.jayanthi.automation.utilities.PropertiesFunction;

public class GmailTest  {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver d = new FirefoxDriver();
		d.get("https://www.gmail.com");
		FileInputStream fis = new FileInputStream("C:\\Users\\jayanthi\\workspace\\Mysampleframework\\src\\com\\jayanthi\\automation\\objectrepository\\OR.Gmail_Test.properties");
		Properties p = new Properties();
		p.load(fis);
	String gmail_username = p.getProperty("username_css");
	String gmail_next = p.getProperty("next_xpath");
	String gmail_password = p.getProperty("password_xpath");
	String gmail_signIn = p.getProperty("signIn_css");
	
	/*System.out.println("gmail username css is:"+gmail_username);
	System.out.println("gmail next xpath is:"+gmail_next);
	System.out.println("gmail password xpath is:"+gmail_password);
	System.out.println("gmail signIn css is:"+gmail_signIn);*/
	
	d.findElement(By.cssSelector(gmail_username)).sendKeys("swapna");
	d.findElement(By.xpath(gmail_next)).click();
	Thread.sleep(3000);
	d.findElement(By.xpath(gmail_password)).sendKeys("abc123");
	d.findElement(By.cssSelector(gmail_signIn)).click();
		
	
	
	
	}

}

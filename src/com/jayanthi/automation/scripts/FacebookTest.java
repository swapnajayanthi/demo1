package com.jayanthi.automation.scripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FacebookTest {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver d = new FirefoxDriver();
		d.get("https:www.facebook.com");
		FileInputStream fis = new FileInputStream("C:\\Users\\jayanthi\\workspace\\utilities\\src\\com\\rameshsoft\\selenium\\objectrepository\\OR.facebook.properties");
		Properties p = new Properties();
		p.load(fis);
		
		String fb_email = p.getProperty("email");
		System.out.println("fb email xpath is:"+fb_email);
		String fb_emaildata = p.getProperty("emaildata");
		System.out.println("fb email data is:"+fb_emaildata);
		d.findElement(By.xpath(fb_email)).sendKeys(fb_emaildata);;
		
		String fb_pwd = p.getProperty("password");
		System.out.println("fb password xpath is:"+fb_pwd);
		String fb_pwddata = p.getProperty("pwddata");
		d.findElement(By.xpath(fb_pwd)).sendKeys(fb_pwddata);
		
		String fb_login = p.getProperty("login");
		System.out.println("fb login xpath is:"+fb_login);
		d.findElement(By.xpath(fb_login)).click();
		Thread.sleep(4000);
		d.quit();
	
		}
	}

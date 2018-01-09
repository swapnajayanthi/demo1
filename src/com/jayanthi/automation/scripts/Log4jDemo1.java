package com.jayanthi.automation.scripts;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Log4jDemo1 {
public static void main(String[] args) {
	WebDriver d = new FirefoxDriver();
	d.manage().window().maximize();
	
	PropertyConfigurator.configure("C:\\Users\\jayanthi\\workspace\\Mysampleframework\\Log4j.propeties");
	Logger log = Logger.getLogger("Log4jDemo1");
	log.info("browser is maximised");
    d.get("https://www.gmail.com");
    log.info("gmail page is opened");
	
	
}
}

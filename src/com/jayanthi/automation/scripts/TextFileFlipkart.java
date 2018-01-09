package com.jayanthi.automation.scripts;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.jayanthi.automation.driverengine.DriverUtility;

public class TextFileFlipkart 
{
	public static void main(String[] args) throws IOException {
		WebDriver d;
	    d = new FirefoxDriver();
	    d.get("https://www.flipkart.com");
	  WebElement electronics = d.findElement(By.xpath("//*[text()='Electronics']"));
	  Actions a = new Actions(d);
	  a.moveToElement(electronics).build().perform();
	  String etext = electronics.getText();
	  File f = new File("C:\\Users\\jayanthi\\workspace\\Mysampleframework\\src\\com\\jayanthi\\automation\\objectrepository\\Flipkart.txt");
	boolean b =   f.createNewFile();
	if(b)
	{
		System.out.println("file is created");
	}
	else
	{
		System.out.println("file is already existed");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(etext);
		bw.flush();
	}
}
}
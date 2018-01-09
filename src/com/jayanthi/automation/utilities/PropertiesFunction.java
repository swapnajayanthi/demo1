package com.jayanthi.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesFunction {
	static Properties p = new Properties();
	String filename;
	String value;
	
	public PropertiesFunction (String filename)
	{
		this.filename = filename;
	}
	public String getProperty(String key) throws IOException
	{
		File file = new File("C:\\Users\\jayanthi\\workspace\\Mysampleframework\\src\\com\\jayanthi\\automation\\objectrepository\\OR.Pf.properties");
		FileInputStream fis = new FileInputStream(file);
		p.load(fis);
		value = p.getProperty(key);
		return value;		
	}
	public void setProperty(String key, String value) throws IOException
	{
		File file = new File("C:\\Users\\jayanthi\\workspace\\Mysampleframework\\src\\com\\jayanthi\\automation\\objectrepository\\OR.Pf.properties");
	    FileInputStream fis = new FileInputStream(file);
	    p.load(fis);
	    p.setProperty(key, value);
	    p.store(new FileOutputStream(file), null);
		
	}
   public void removeproperty(String key) throws IOException
   {
	   File file = new File("C:\\Users\\jayanthi\\workspace\\Mysampleframework\\src\\com\\jayanthi\\automation\\objectrepository\\OR.Pf.properties");
	   FileInputStream fis = new FileInputStream(file);
	   p.load(fis);
	   p.remove(key);
	   p.store(new FileOutputStream(file), null);
   }
   public Map<String, String> getAllProperties()
   {
	   LinkedHashMap<String, String> m = new LinkedHashMap<>();
	   Set keys = p.keySet();
	   for(Object s:keys)
		{
			String key = (String) s;
			String value = p.getProperty(key);
			m.put(key, value);
		}
		return m;
	}
	   
   }
 

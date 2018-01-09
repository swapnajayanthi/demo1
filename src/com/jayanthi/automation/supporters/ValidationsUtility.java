package com.jayanthi.automation.supporters;

import static org.testng.Assert.expectThrows;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jayanthi.automation.customisedexcetion.FrameworkException;

public class ValidationsUtility extends FrameworkException
{
	
	boolean b;
	public boolean ValidateNumber(String phonenum)
	{
		
		Pattern p = Pattern.compile("([0|[+]91]?[789][0-9]{9}");
		Matcher m = p.matcher(phonenum);
		if(m.find() && m.group().equals(phonenum))
		{
			b=true;
			System.out.println("phone number is valid");
		}
		else
		{
			Exception FrameworkException;
		}
		return b;
		}
    public static void ValidateEmail(String email)
    {
    	Pattern p = Pattern.compile("([a-z A-Z]*[0-9 a-z A-Z]@[.][a-z]+)");
    	Matcher m = p.matcher(email);
    }
}

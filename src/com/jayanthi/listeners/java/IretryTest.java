package com.jayanthi.listeners.java;

import org.testng.ITestResult;

public class IretryTest implements IRetryAnalyzer {
	
int retryCount = 0;
int maxCount = 4;
public boolean retry(ITestResult result) throws InterruptedException
{
	if(result.getStatus()==ITestResult.FAILURE&&retryCount<=maxCount)
{
		try
		{
	Thread.sleep(5000);
	System.out.println("retry count is :"+retryCount+".......executing...."+result.getName());
	retryCount++;
}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	return true;
}
	return false;
}
}
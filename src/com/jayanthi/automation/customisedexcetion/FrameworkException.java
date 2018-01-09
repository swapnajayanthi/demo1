package com.jayanthi.automation.customisedexcetion;

public class FrameworkException extends Exception{
	public FrameworkException()
	{
		super();
		System.out.println("got exception1");
	}
	public FrameworkException (String exceptionmessage)
	{
	   super(exceptionmessage);
	   System.out.println("got exception2");
		
	}

}

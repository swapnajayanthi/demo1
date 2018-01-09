package com.jayanthi.automation.customisedexcetion;



public class TestDemo {

	public static void main(String[] args) throws FrameworkException {
		int a=10, b=30;
		if(a==b)
		{
			System.out.println("a,b are equal");
		}
		else
		{
			FrameworkException f = new FrameworkException("a,b are not  equal");
			throw f;
			//throw new FrameworkException("a,b are not equal");
			
		}

	}

}

package com.guru99bank.testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99bank.pageObject.LoginPage;

public class L  extends BaseClass{
	
	
	  LoginPage login;
	  
	  @Test(dataProvider="aaaa")
		public void login_datadriven(String uid , String PAssword) throws InterruptedException
		{
			

			login = new LoginPage(driver);
			logger.info("Entered User name for DDT");
			login.setUsername(uid);
			logger.info("Entered password for DDT");
			login.setPassword(PAssword);
			logger.info("Clicked Loginfor DDT");
			login.clickLogin();
			
			if (driver.getCurrentUrl().contains("http://practice-pad.com/users"))
			{
				logger.info("Logout for DDT");
			login.logOut();	
				
			}
		 
			else 
			
			 {
				
				login.errorMsg();
				System.out.println("For this cardential login is Invalid  " +"userid::"+uid+" And Password is :::"+PAssword);
				
			}
			
			
	
		
		
		
	}
	
	@DataProvider(name="aaaa")
	
	public String[][] datasource()
	{
		
		
		return readdata("C:\\Users\\dkunal\\Desktop\\test.xls", "Sheet1");
		
	}
	

}

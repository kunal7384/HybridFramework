package com.practice.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.pageobject.pages.InvalidLoginPage;

public class InvalidLoginTest extends BaseClass {
	
	InvalidLoginPage invalidlogin;
	
// Without Entering Any data Click on Login Button 
	
	@Test(priority =6,description="Invalid Login - Bank data click on Login button")
	
	public void balnk_fields() throws InterruptedException
	{
	invalidlogin = new InvalidLoginPage(driver)	;
	
     invalidlogin.click_Login();
   
		invalidlogin.click_Submmit();
		
		  Thread.sleep(2000);
		if(isAlertisPresent()==true)
		{
		Alert ale = driver.switchTo().alert();
		String capture_msg = ale.getText();
		System.out.println(capture_msg);	
		ale.accept();
		Assert.assertTrue(true);
			
		}
		else
		{
			Assert.assertTrue(false);
			
			
		}
		
	}
	
	
	
	// Enter Email and Keep Password field balnk 
	
		@Test(priority=7,description="Invalid Login-Enter valid Email and Keep password Blank")
		
		public void balnk_password_fields() throws InterruptedException
		{
		
	     
	     invalidlogin.enter_Email(userName);
	   
			invalidlogin.click_Submmit();
			
			  Thread.sleep(2000);
			if(isAlertisPresent()==true)
			{
			Alert ale = driver.switchTo().alert();
			String capture_msg = ale.getText();
			System.out.println(capture_msg);	
			ale.accept();
			Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
				
				
			}
			
			
		}
			
			// Enter  Password and Keep Bank Email filed 
			
			@Test(priority=8,description="Invalid Login-Enter valid PAssword and Keep Email Blank")
			
			public void balnk_Email_fields() throws InterruptedException
			{
			
		     
		     invalidlogin.enter_Email(userName);
		   
		     invalidlogin.clear_Email(userName);
		     invalidlogin.enter_Password(passWord);
		     
				invalidlogin.click_Submmit();
				
				  Thread.sleep(2000);
				if(isAlertisPresent()==true)
				{
				Alert ale = driver.switchTo().alert();
				String capture_msg = ale.getText();
				System.out.println(capture_msg);	
				ale.accept();
				Assert.assertTrue(true);
					
				}
				else
				{
					Assert.assertTrue(false);
					
					
				}
			
		}
		
		
	}



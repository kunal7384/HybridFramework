package com.practice.testcases;


import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.pageobject.pages.SignUpPage;

public class SignUpTest extends BaseClass{
	
	SignUpPage signup ;
	String excepted1 ="email: can't be blank\n" + 
			"password: can't be blank\n" + 
			"first_name: can't be blank\n" + 
			"last_name: can't be blank";
			
	
	String excepted2 ="first_name: can't be blank"; 
			
	
	
	String excepted3 ="last_name: can't be blank"; 
	
	
	String excepted4 ="email: can't be blank"; 
	
	String excepted5 ="password: can't be blank\n" +
			                "password_confirmation: doesn't match Password";
	
	
	// Without Entering Any data Click On Create Account 
	@Test(priority=1,description="Sign up-Balnk Data and click on Sign up Button")
	
	public void without_entering_click_createAccount() throws InterruptedException, IOException
	{
		signup = new SignUpPage(driver);
		
		signup.click_signUp();
		Thread.sleep(1000);
		signup.click_createacc();
		Thread.sleep(1000);
		if(isAlertisPresent()==true)
		{
			
			Alert ale = driver.switchTo().alert();
			String capture_msg = ale.getText();
			System.out.println(capture_msg);
			System.out.println("=========TC1=======================");
			Thread.sleep(1000);
			ale.accept();
			add_screenShot(driver, "WithoutEntering data");
			Assert.assertEquals(capture_msg, excepted1);
		
			
		}
		
		
		else
		{
			
			System.out.println("Alert is not Present and Test CAses Failed");
			
		}
		
	}
         @Test(priority=2,description="Sign Up:Filled out all fields and Remove the first name field")
      // Remove the first name File 
	public void remove_firstname() throws InterruptedException, IOException
	{
		
		signup.enter_lastName("narola");
		signup.enter_email("abc@gmail.com");
		signup.enter_password("password");
		signup.enter_cpassword("password");
		signup.click_createacc();
		Thread.sleep(2000);
		if(isAlertisPresent()==true)
		{
			Thread.sleep(2000);
			Alert ale = driver.switchTo().alert();
			String capture_msg = ale.getText();
			System.out.println(capture_msg);
			
			System.out.println("=========TC2=======================");
			Thread.sleep(2000);
			ale.accept();
			add_screenShot(driver, "WithoutEnteringfirstname");
			Assert.assertEquals(capture_msg, excepted2);
			
		}
		
		
		else
		{
			
			System.out.println("Alert is not Present and Test CAses Failed");
			
		}
		
	}
	
         @Test(priority=3,description="Sign Up:Filled out all fields and Remove the Last name field")
         // Remove the Last name File 
   	public void remove_lasttname() throws InterruptedException, IOException
   	{
   		
   	    signup.enter_firstName("Kunal");
   		signup.enter_lastName("");
   		signup.enter_email("abc@gmail.com");
   		signup.enter_password("password");
   		signup.enter_cpassword("password");
   		signup.click_createacc();
   		Thread.sleep(2000);
   		if(isAlertisPresent()==true)
   		{
   			Thread.sleep(2000);
   			Alert ale = driver.switchTo().alert();
   			String capture_msg = ale.getText();
   			System.out.println(capture_msg);
   			
   			System.out.println("=========TC3=======================");
   			Thread.sleep(2000);
   			ale.accept();
   			add_screenShot(driver, "WithoutEnteringlastname");
			Assert.assertEquals(capture_msg, excepted3);
   			
   		}
   		
   		
   		else
   		{
   			
   			System.out.println("Alert is not Present and Test CAses Failed");
   			
   		}
   		
   	}

         @Test(priority=4,description="Sign Up:Filled out all fields and Remove the email field")
         // Remove the Email from Email Filed 
   	public void remove_email() throws InterruptedException, IOException
   	{
   		
   	    signup.enter_firstName("Kunal");
   		signup.enter_lastName("Dhote");
   		signup.enter_email("");
   		signup.enter_password("password");
   		signup.enter_cpassword("password");
   		signup.click_createacc();
   		Thread.sleep(2000);
   		if(isAlertisPresent()==true)
   		{
   			Thread.sleep(2000);
   			Alert ale = driver.switchTo().alert();
   			String capture_msg = ale.getText();
   			System.out.println(capture_msg);
   			System.out.println("=========TC4=======================");
   			Thread.sleep(2000);
   			ale.accept();
   			add_screenShot(driver, "Without Email");
			Assert.assertEquals(capture_msg, excepted4);
   			
   		}
   		
   		
   		else
   		{
   			
   			System.out.println("Alert is not Present and Test CAses Failed");
   			
   		}
   		
   	}
         
         
         
         @Test(priority=5,description="Sign Up:Filled out all fields and Remove the password field")
         // Remove the password
   	public void remove_password() throws InterruptedException, IOException
   	{
   		
   	    signup.enter_firstName("Kunal");
   		signup.enter_lastName("Dhote");
   		signup.enter_email("kd@gmail.com");
   		signup.enter_password("");
   		signup.enter_cpassword("password");
   		signup.click_createacc();
   		Thread.sleep(2000);
   		if(isAlertisPresent()==true)
   		{
   			Thread.sleep(2000);
   			Alert ale = driver.switchTo().alert();
   			String capture_msg = ale.getText();
   			System.out.println(capture_msg);
   			System.out.println("=========TC5=======================");
   			Thread.sleep(2000);
   			ale.accept();
   			add_screenShot(driver, "Without password");
			Assert.assertEquals(capture_msg, excepted5);
   			
   		}
   		
   		
   		else
   		{
   			
   			System.out.println("Alert is not Present and Test CAses Failed");
   			
   		}
   		
   	}
         
         
}

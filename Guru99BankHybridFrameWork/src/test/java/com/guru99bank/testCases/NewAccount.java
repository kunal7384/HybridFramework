package com.guru99bank.testCases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99bank.pageObject.AddnewCustomerPage;
import com.guru99bank.pageObject.LoginPage;
import com.guru99bank.pageObject.NewAccountPage;

public class NewAccount extends BaseClass {
	
	LoginPage login;
	NewAccountPage newaccount;
	String excepted = "Please fill all fields";
	String exceptedcid ="Customer does not exist!!";
	String exceptedintialdeposite ="Intial deposite must be Rs. 500 or more";
	String validaccount ="Account Generated Successfully!!!";
	
	
	@Test(priority=8 ,description="Login to the account")
	
	public void logintoaccount()
	{
		
		login = new LoginPage(driver);
		login.setUsaername(userName);
		login.setPassword(passWord);
		login.setLogin();
		
		
	}
	
	@Test(priority=9 ,description="Without Enteringg data into the fields and click on Submmit link")
	
	public void invalid_new_account()
	{
		newaccount = new NewAccountPage(driver);	
		newaccount.click_newAccount();
		newaccount.clicksubmmit();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert text:::" +alertText);
		alert.accept();
		if(excepted.equals(alertText))
		{
			
			Assert.assertTrue(true);
			
		}
		
		
		else
		{
			Assert.assertTrue(false);
			
		}
	}
	
	
	
	

	@Test(priority=10 ,description="Enter INvalid Customer id ")
	
	public void invalid_new_account_invalidcustomerid() throws InterruptedException
	{
		//newaccount = new NewAccountPage(driver);	
		newaccount.click_newAccount();
		Thread.sleep(2000);
		newaccount.setCustomerid("2222");
		Thread.sleep(2000);
		newaccount.enterIntialDeposit("5000");
		Thread.sleep(2000);
		newaccount.clicksubmmit();
		Thread.sleep(2000);
		
		Alert alert1 = driver.switchTo().alert();
		String alertText1 = alert1.getText();
		System.out.println("Alert text:::" +alertText1);
		alert1.accept();
		if(exceptedcid.equals(alertText1))
		{
			
			Assert.assertTrue(true);
			
		}
		
		
		else
		{
			Assert.assertTrue(false);
			
		}
	
	
	
	}  

	@Test(priority=11 ,description="Validate Intial Deposit Field Enter less than 500 rupess to deposit ")
	
	public void invalid_new_account_intialdeposite() throws InterruptedException
	{
		
	    	//newaccount = new NewAccountPage(driver);	
			newaccount.click_newAccount();
			Thread.sleep(2000);
		newaccount.setCustomerid("55426");
		newaccount.enterIntialDeposit("200");
		newaccount.clicksubmmit();
		
		int a=200;	
		
		if( a<500)
		{	
		//txt_initialdepo.sendKeys(String.valueOf(a))	;
		
	Alert alert3 = driver.switchTo().alert();
	
	   String alert3Text=alert3.getText();
	   alert3.accept();
	   System.out.println("Alert is display ::"+alert3Text);
	   
	   
	  Assert.assertEquals(alert3Text, exceptedintialdeposite);
	   
		
		}
		else 
		{
			
			System.out.println("Alert is not Display");
			Assert.assertTrue(false);
		}
		
	}
	
	@Test(priority=12 ,description="Creating Valid New Account ")
	public void verify_newAccount() throws InterruptedException
	{
	//newaccount = new NewAccountPage(driver);	
		//newaccount.click_newAccount();
		Thread.sleep(2000);
	

	newaccount.setCustomerid("55426");
	newaccount.enterIntialDeposit("500");
	newaccount.clicksubmmit();
	newaccount.gettextAccount();
	boolean resultacc= driver.getPageSource().contains("Account Generated Successfully!!!");
	
	if(resultacc==true )
	{
		
		Assert.assertTrue(true);
		System.out.println("1");
		
		
	
	}	
	else 
	{
		
		Assert.assertTrue(true);
		System.out.println("11");
		//BaseClass.isAlertPresent();
		System.out.println("Test cases failed");
		
	}
	
	}
}

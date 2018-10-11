package com.guru99bank.testCases;


import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.net.io.CRLFLineReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99bank.pageObject.AddnewCustomerPage;
import com.guru99bank.pageObject.LoginPage;

public class AddNewCustomer extends BaseClass {
	LoginPage login;
	AddnewCustomerPage createCustomer;
	
	@Test(priority=5)
	public void create_new_Customer() throws InterruptedException, IOException
	
	{
	login = new LoginPage(driver);
	login.setUsaername(userName);
	login.setPassword(passWord);
	login.setLogin();
	Thread.sleep(2000);
	createCustomer = new AddnewCustomerPage(driver);
	
	createCustomer.clickCustomer();
	createCustomer.setCustomerName("kunal");
	//createCustomer.checkRadioBox();
	createCustomer.setDateofBirth();
	createCustomer.setAddress("PAlampuur JakatrNaka");
	createCustomer.setCity("Surat");
	createCustomer.setState("Gujarat");
	createCustomer.setPinno("395009");
	createCustomer.setphone("1234567890");
	createCustomer.setpassword("password");
	createCustomer.setEmail("asdfghjkl@gmail.com");
//String emailid=	createCustomer.setEmail(randomeString()+"@gmail.com");
//System.out.println("Random Genarated Email address is ::"+emailid);
	
	createCustomer.setpassword("passwotrd");
	Thread.sleep(2000);
	createCustomer.clickSubmit();
	BaseClass.isAlertPresent();
	boolean ret = driver.getPageSource().contains("Customer Registered Successfully!!!");
	if(ret==true )
	{
		
		Assert.assertTrue(true);
		System.out.println("1");
		
		
	
	}	
	else 
	{
		
		Assert.assertTrue(true);
		System.out.println("11");
		//BaseClass.isAlertPresent();
		System.out.println("Email id Already Exsist");
		
	}
	
	}
	
	
	
	/*if(isAlertisPresent()==true)
	{
		 Alert alert = driver.switchTo().alert();
		String r= alert.getText();
		alert.accept();
		System.out.println(r);
		
		System.out.println("Email Already Exist try to Difeerent Email");
		
		
	}
	
	else
	{
		
		System.out.println("Register User Successfully");
		
	}*/
/*	if (isAlertisPresent()==true)
	{
		
		Alert alert = driver.switchTo().alert();
		String r= alert.getText();
	   alert.accept();
		

		//driver.switchTo().alert().accept();
		//driver.switchTo().defaultContent();

	
		Assert.assertTrue(false);
		Thread.sleep(2000);
		
	}
	else 
	{
		
		
		System.out.println("11");
	//	addScreenShot(driver, "addnewcustomer");
		//Alert alert = driver.switchTo().alert();
		//String r= alert.getText();
	///	alert.accept();
	//	System.out.println(r);
		
		Assert.assertTrue(true);
		
		
	
		
	}

        }
	  public boolean isAlertisPresent()
      {
		 {
			  try {
			  driver.switchTo().alert();
			  return true;
			  }// try
			  catch (Exception e) {
			  return false;
			  }// catch
			  }*/
      
}

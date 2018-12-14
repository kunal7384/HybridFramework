package com.guru99bank.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.guru99bank.pageObject.LoginPage;

public class LoginTest extends  BaseClass {
	
	
	 LoginPage login;
	
   
	
	@Test(priority =1 ,description ="Valid Loogin")
	public void validlogin() throws IOException
	{
        
		login = new LoginPage(driver);
		login.setUsaername(userName);
		login.setPassword(passWord);
		login.setLogin();
		System.out.println("Done");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			
			Assert.assertTrue(true);
			
		}
		
		else
		{
			addScreenShot(driver, "login");
			Assert.assertTrue(false);
			
			
		}
	}
	
	
	
	
}

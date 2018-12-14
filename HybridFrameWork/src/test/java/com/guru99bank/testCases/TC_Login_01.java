package com.guru99bank.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.guru99bank.pageObject.LoginPage;
import com.sun.jna.platform.win32.Netapi32Util.User;

public class TC_Login_01 extends BaseClass {
	
	LoginPage login;
	
	
	
	@Test()
	
	public void validLogin() throws IOException
	{
		
		login = new LoginPage(driver);
		logger.info("Entered Username");
		login.setUsername(username);
		logger.info("Entered password");
		login.setPassword(password);
		logger.info("Clicked on Login");
		login.clickLogin();
		
		if(driver.getTitle().equals("Practice Pa"))
		{
			logger.info("Verifying Title");
			Assert.assertTrue(true);
			
		}
		
		else
		{
			captureScreenshot(driver, "Login");
			Assert.assertTrue(false);
		
			
		}
	}
	


}

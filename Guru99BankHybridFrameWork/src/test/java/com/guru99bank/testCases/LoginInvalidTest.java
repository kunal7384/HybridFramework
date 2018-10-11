package com.guru99bank.testCases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99bank.pageObject.LoginInvalid;

public class LoginInvalidTest extends BaseClass {
	 
	LoginInvalid invalidlogin ;
	
	@Test(priority =2 ,description="Without Entering Any data into the field click on Login button")

	public void verify_Invalid_Login() 
	{
		// With out Entering Any data into the Username and Password field
		invalidlogin = new LoginInvalid(driver);
		
		invalidlogin.click_Login();
		
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		alert.accept();
		System.out.println("Captured Error Message by Keeping username and password field blank:::::"+alertMsg);
		
		
	}
     // Enter USename and clikc on login button 
		
		@Test(priority=3 ,description="Enter username and Keep password field Blank")
		public void enterUsername()
		{
			invalidlogin = new LoginInvalid(driver);
			invalidlogin.setPassword("mngr139454");
			
			invalidlogin.click_Login();
			BaseClass.isAlertPresent();
			String currenturl = driver.getCurrentUrl();
			System.out.println(currenturl);
			if(currenturl.equals("https://demo.guru99.com/v4/index.php"))
			{
				
				Assert.assertTrue(true);
				
			}
			
			else
			{
				Assert.assertTrue(false);
				
				
			}
			
		}
		
		
	
	

}

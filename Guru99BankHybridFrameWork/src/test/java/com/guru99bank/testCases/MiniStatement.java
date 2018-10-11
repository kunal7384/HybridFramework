package com.guru99bank.testCases;

import org.testng.annotations.Test;

import com.guru99bank.pageObject.LoginPage;
import com.guru99bank.pageObject.MiniStatementPage;

public class MiniStatement extends BaseClass {
	
	
	LoginPage login;
	MiniStatementPage ministatement;
	
	@Test(priority=15 ,description="Verifying MiniStatement Module")
	public void verifyMinistatement() throws InterruptedException
	{
		login = new LoginPage(driver);
		login.setUsaername(userName);
		login.setPassword(passWord);
		login.setLogin();
		
		Thread.sleep(2000);
		
		ministatement = new MiniStatementPage(driver);
		
		ministatement.click_ministatement();
		ministatement.enterAccountno("49730");
		ministatement.click_submmit();
	}

}

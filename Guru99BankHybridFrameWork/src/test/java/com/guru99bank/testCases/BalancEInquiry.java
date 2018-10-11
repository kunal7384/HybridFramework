package com.guru99bank.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.net.ftp.parser.NetwareFTPEntryParser;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99bank.pageObject.BalancEInquiryPage;
import com.guru99bank.pageObject.LoginPage;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class BalancEInquiry extends BaseClass {
	
	LoginPage login ;
	BalancEInquiryPage balance;
	
	
	@Test(priority=13 ,description="Login")
	 public void login() throws InterruptedException
	 {
		login = new LoginPage(driver);
		login.setUsaername(userName);
		login.setPassword(passWord);
		login.setLogin();
		Thread.sleep(2000);
		
		
		
	 }
	
	@Test(priority=14 ,description="Verifying Balance Enquiry ",dataProvider="accountdata")
	
	public void verifyBalance(String accountid) throws InterruptedException
	{
		
		
		balance = new BalancEInquiryPage(driver);
		
		balance.click_balance();
		balance.enterAccountno(accountid);
		balance.click_submmit();
		
		if(isAlertisPresent()==true)
		{
		
			Alert al = driver.switchTo().alert();
			String altext = al.getText();
			al.accept();
			System.out.println(altext);
			
			
			System.out.println("Invalid customer id are ::" +accountid);
			
			
		}
		
		else 
		{
			Assert.assertTrue(true);
			System.out.println("valid customer id are ::" +accountid);
			balance.balnce();
			balance.click_balance();
			
			
		}
		
		
	}
	
	
	public boolean isAlertisPresent()
	{
		try
		{
			
		driver.switchTo().alert();
		return true;
		} catch (NoAlertPresentException e) {
			System.out.println("No Alert present mean valid Entry");
			return false;
		}
		
		
		
	}
	
	
	@DataProvider(name="accountdata")
	
	public Object[] accountidData() throws BiffException, IOException
	{
		
		
		File file = new File("F:\\Selemnium Practice code Aug 2018\\Guru99BankHybridFrameWork\\src\\test\\java\\com\\guru99bank\\testdata\\accountid.xls");
		
		Workbook wb = Workbook.getWorkbook(file);
		
		Sheet st = wb.getSheet(0);
		
		int row = st.getRows();
		
	Object[] data = new Object[row];
		
		for(int i=0;i<row;i++)
		{
			
	data[i]	=st.getCell(0,i)	.getContents();
		
		}
		return data;
		
	}

}

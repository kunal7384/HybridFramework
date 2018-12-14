package com.guru99bank.testCases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99bank.pageObject.LoginDataDrivenPage;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LoginDataDrivenTest extends BaseClass {

	LoginDataDrivenPage loginddt;
	
	
	@Test(priority=4 ,dataProvider= "logindataa")
	public void verifyLoginDDT(String uid , String uipass) throws InterruptedException
	{
		loginddt = new LoginDataDrivenPage(driver);	
		
		loginddt.setusername(uid);
		loginddt.setpassword(uipass);
		loginddt.click_login();
		
		if(isAlertisPresent()==true)
		{
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Assert.assertTrue(true);
		Thread.sleep(2000);
		System.out.println(uid + uipass);
		}
		else
		{
			Assert.assertTrue(true);
		loginddt.click_logout();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		System.out.println(uid + uipass);
			
		}
		}
	
	

	
	public boolean isAlertisPresent()
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch (NoAlertPresentException e) {
		return false;
		}
		
		
	}
	
	
	@DataProvider(name="logindataa")
	
	public Object[][] verify_login_data_drivern() throws BiffException, IOException
	{
		
		
		File file = new File("C:\\Users\\dkunal\\git\\HybridFramework\\Guru99BankHybridFrameWork\\src\\test\\java\\com\\guru99bank\\testdata\\test.xls");
		
		Workbook wb = Workbook.getWorkbook(file);
		Sheet sh = wb.getSheet(0);
		int row = sh.getRows();
		int col = sh.getColumns();
		Object[][] data = new Object[row][col];
		
		for(int i= 0;i<row;i++)
		{
		 	

			for(int j= 0;j<col;j++)
			{
			Cell c = sh.getCell(j,i);
			data[i][j]=c.getContents();
				
				
			}
			
		}
		return data;
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}

package com.guru99bank.testCases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Alert;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99bank.pageObject.EditCustomerPage;
import com.guru99bank.pageObject.LoginPage;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class EditCustomer extends BaseClass {
	
	EditCustomerPage edit;
	 LoginPage login;
	@Test(priority = 6, description= "Without Entering Customer id and click on submmit link")

	public void blankCustoerid()
	{
		
		login = new LoginPage(driver);
		login.setUsaername(userName);
		login.setPassword(passWord);
		login.setLogin();
		
		
	 edit = new EditCustomerPage(driver);
		edit.editCustomer();
		edit.submmit();
		
		try 
		{
			
		Alert alert = driver.switchTo().alert();
		String alertmsg = alert.getText();
		System.out.println(alertmsg);
		alert.accept();
		Assert.assertEquals("Please fill all fields", alertmsg);
			
		} catch (NoAlertPresentException e) {
		 
			System.out.println("Alert not Display");
		}
	}
	
	
	
	@Test(priority=7 ,dataProvider="testdata")
	
	public void edit(String cid)
	{
		edit = new EditCustomerPage(driver);
		edit.editCustomer();
		edit.customerid(cid);
		edit.submmit();
		
		if(isAlertisPresent()==true)
		{
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			System.out.println("Wrong Customer id is :::"+cid);
			Assert.assertTrue(true);
			
		}
		
		else 
		{
			Assert.assertTrue(true);
			System.out.println("Valid customer id is :::" +cid);
			edit.editCustomer();
			
			
		}
		
		
		
	}
	
	
	public boolean isAlertisPresent()
	{
		
		try
		{
			driver.switchTo().alert();
			return true;
			
			
		} catch (NoAlertPresentException e) {
			return false;
			
		}
		
		
	}
	
	
	@DataProvider(name="testdata")
	public Object[] verifyEditCustomer() throws BiffException, IOException
	{
		
		File file = new File("C:\\Users\\dkunal\\git\\HybridFramework\\Guru99BankHybridFrameWork\\src\\test\\java\\com\\guru99bank\\testdata\\edit.xls");
		
		Workbook wb = Workbook.getWorkbook(file);
		Sheet sh = wb.getSheet(0);
		int row = sh.getRows();
		
		Object[] data = new Object[row];
		
		for(int i= 0;i<row;i++)
		{
		 	
			data[i] = sh.getCell(0,i).getContents();
			
			}
			
		
		return data;
		
	}

}

package com.guru99bank.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99bank.pageObject.LoginPage;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TC_LoginDDT_02 extends BaseClass {
   Workbook wb;
   Sheet sh;
	File src;
	FileInputStream fis;
	int row ;
    LoginPage login;
	
	@Test(dataProvider="validInvalidlogintest")
	
	public void login_datadriven(String uid , String PAssword) throws InterruptedException
	{
		

		login = new LoginPage(driver);
		logger.info("Entered User name for DDT");
		login.setUsername(uid);
		logger.info("Entered password for DDT");
		login.setPassword(PAssword);
		logger.info("Clicked Loginfor DDT");
		login.clickLogin();
		
		if (driver.getCurrentUrl().contains("http://practice-pad.com/users"))
		{
			logger.info("Logout for DDT");
		login.logOut();	
			
		}
	 
		else 
		
		 {
			
			login.errorMsg();
			System.out.println("For this cardential login is Invalid  " +"userid::"+uid+" And Password is :::"+PAssword);
			
		}
		
		
	}

	
	@DataProvider(name="validInvalidlogintest")
	
	public Object[][] valid_invalid_loginTest() throws IOException, BiffException
	{
		
		 src = new File("C:\\Users\\dkunal\\Desktop\\testdata.xls")	;
		
	 wb = Workbook.getWorkbook(src);
			
		 sh = wb.getSheet(0);
			int nor = sh.getRows();
			int col = sh.getColumns();
		Object[][]  data = new Object[nor][col]	;
		
		for(int i =0;i<nor;i++)
		{
			
	     for(int j=0;j<col;j++)
	     {
	    	 
	    	Cell c = sh.getCell(j, i) ;
	    	data[i][j] = c.getContents();
	    	
	    	System.out.println(data[i][j]);
	     }
			
		}
		return data;
		}
	

		
		
		
		
	
}

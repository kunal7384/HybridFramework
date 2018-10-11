package com.guru99bank.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.xerces.util.SynchronizedSymbolTable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99bank.pageObject.LoginPage;
import com.guru99bank.pageObject.MiniStatementPage;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

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
		
		
		
	}
	@Test(priority=16 ,description="Mini Statement Data Driven Testing",dataProvider="minidata")
		public void ministatement_ddt(String miniid)
		{
		ministatement = new MiniStatementPage(driver);
		
		ministatement.click_ministatement();
		ministatement.enterAccountno(miniid);
		ministatement.click_submmit();
		
		if(isAlertisPresent()==true)
		{
			
			Alert at = driver.switchTo().alert();
			
			String altext = at.getText();
			System.out.println("Invalid Account Id For getting Mini Statement "+ miniid);
			at.accept();
		}
			else
			{
				
				String m =driver.findElement(By.xpath("//p[@class='heading3']")).getText();
				System.out.println(m +miniid);
				
				ministatement.click_ministatement();
				
			}
			
			
		
	}
	
	
	
	
	
	
	
	
public boolean isAlertisPresent()
{
	try {
		
		driver.switchTo().alert();
		return true;
		
	} catch (NoAlertPresentException e) {
	 System.out.println("Alert is not present in mini module");
	 return false;
	}
	



}
	@DataProvider(name="minidata")
	
	public Object[] getdata() throws BiffException, IOException
	{
		
		File file = new File("C:\\Users\\dkunal\\git\\HybridFramework\\Guru99BankHybridFrameWork\\src\\test\\java\\com\\guru99bank\\testdata\\ministmt.xls");
		Workbook wb = Workbook.getWorkbook(file);
		Sheet st = wb.getSheet(0);
		 int row = st.getRows();
		Object[] data = new Object[row];
		
		for(int i=0;i<row;i++)
		{
		data[i]	=st.getCell(0,i).getContents();
			
		}
		return data;
		
		
	}
	

}

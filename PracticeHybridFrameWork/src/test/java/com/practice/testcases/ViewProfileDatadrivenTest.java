package com.practice.testcases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.practice.pageobject.pages.LoginDataDrivenPage;
import com.practice.pageobject.pages.ViewProfileDataDrivenPage;

public class ViewProfileDatadrivenTest extends BaseClass {
	
	
	ViewProfileDataDrivenPage view;
	public static LoginDataDrivenPage logindtt;


	
	@Test(priority =12 ,description="Data Driven Testing for View Profile")
	public void viewprofile_login()
	{
		           logindtt= new LoginDataDrivenPage(driver);
	
                    logindtt.click_homelogin();
	}
	
	@Test(priority =13 ,dataProvider="viewprofiledata")
	public void viewprofile_datadriven(String viewmuserid ,String viewmpassword) throws InterruptedException {
		
		 view = new ViewProfileDataDrivenPage(driver);
	         Thread.sleep(2000);
	         logindtt.set_email(viewmuserid);
	          Thread.sleep(2000);
	          logindtt.set_pass(viewmpassword);
             	Thread.sleep(2000);
                logindtt.click_login();
	            Thread.sleep(2000);
	       
	 if(isAlertisPresemt()==true)
	{
		
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
	
		String alerttext=	alert.getText();
		alert.accept();
	
	
		System.out.println("Alert is Present " + alerttext);	
	}
	
	
	else if(driver.findElement(By.xpath("//li[@class='myaccount']//a[@href='#']")).isDisplayed())
	{	
		Thread.sleep(2000);
	driver.findElement(By.xpath("//li[@class='myaccount']//a[@href='#']")).click();
	view.clickon_viewprofile();
	view.edit_firstname("kunal");
	 
	
//	view.edit_mobile("1234567895");
	 
	 Thread.sleep(1000);
	view.edit_currentassword("password");
	 
	
	view.clickon_savechenges();
	
	 Thread.sleep(1000);
	 view.click_logoutAvtar();
	 
	 Thread.sleep(1000);
	 
	 driver.findElement(By.xpath("//div[@class='dropdown-menu show']//a[5]")).click();
	 
	 Thread.sleep(2000);
	 
	 driver.findElement(By.xpath("//a[@class='signup-btn signin']")).click();
	 
	 Thread.sleep(2000);
	}
	else
	{
	
		
		
		System.out.println("222222222");
		System.out.println(" Both condition false is false jfknfvjdnv jn");
		
		
	}
	
	
	
	
	}

	
	@DataProvider(name="viewprofiledata")
	
	public String[][] getdatafor_viewProfile() throws IOException
	{
		
		return getExceldataforlogin(System.getProperty("user.dir")+"/src/test/java/com/practice/testdata/logindata.xls", "Sheet1");
		
	}
	
	
	public boolean isAlertisPresemt()
	{
		
		try
		{
		driver.switchTo().alert();
	
	return true;
		} catch (NoAlertPresentException e) {
		
			return false;
		}
		
			
		
	
	
	
	}
}

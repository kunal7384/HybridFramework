package com.guru99bank.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginDataDrivenPage {
	
	
	public static WebDriver driver;
	
	@FindBy(name="uid")
	WebElement txt_username;
	
	@FindBy(name="password")
	WebElement txt_password;
	
	
	@FindBy(name="btnLogin")
	WebElement btn_login;
	
	@FindBy(xpath=" //a[contains(text(),'Log out')]")
	WebElement btn_logout;
	
	
	public LoginDataDrivenPage(WebDriver driver)
	{
		
	this.driver= driver;
	PageFactory.initElements(driver, this);
		
		
	}
	
	public void setusername(String uname)
	{
		
		txt_username.sendKeys(uname);
		
	}
	
	
	public void setpassword(String upass)
	{
		
		txt_password.sendKeys(upass);
		
	}

   public void click_login()
   {
	   btn_login.click();
	   
	   
   }
   
   
   public void click_logout()
   {
	   btn_logout.click();
	   
	   
   }
}

package com.guru99bank.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public static WebDriver driver;
	
	@FindBy(name="uid")
	WebElement txt_username;
	
	@FindBy(name="password")
	WebElement txt_password;
	
	
	@FindBy(name="btnLogin")
	WebElement btn_login;
	
	
	public LoginPage(WebDriver driver)
	{
		
	this.driver =driver;
	PageFactory.initElements(driver, this);
		
	}
    
	public void setUsaername(String name)
	{
		txt_username.sendKeys(name);
		
		
	}
	
	public void setPassword(String pass)
	{
		txt_password.sendKeys(pass);
		
		
	}
	
	public void setLogin()
	{
	 btn_login.click();
		
		
	}
}

package com.guru99bank.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginInvalid {
	
	public static WebDriver driver;
	
	
	// Without Entering Any Data click On Login Button 
	
	
	
	@FindBy(name="uid")
	WebElement txt_username;
	
	
	@FindBy(name="password")
	WebElement txt_password;
	
	
	@FindBy(name="btnLogin")
	WebElement btn_Login;
	

	public  LoginInvalid(WebDriver driver)
	{
		
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	public void setusername(String userid)
	{
		
		txt_username.sendKeys(userid);
		
		
	}
	
	
	
	public void setPassword(String userpassword)
	{
		
        txt_password.sendKeys(userpassword);
		
		
	}
	
	
	public void click_Login()
	{
		
		btn_Login.click();
		
		
	}

}

package com.practice.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginDataDrivenPage {
	
	public static WebDriver driver;
	
	@FindBy(id="signin-email")
	WebElement txt_uname;
	
	
	@FindBy(id="signin-password")
	WebElement txt_upass;
	
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btn_login;
	
	
	
	@FindBy(xpath="//*[@class='myaccount']")
	WebElement btn_logoutavtar;
	
	
	@FindBy(xpath="//div[@class='dropdown-menu show']//a[5]")
	WebElement btn_logout;
	
	
	
	@FindBy(xpath=" //a[@class='signup-btn signin']")
	WebElement btn_homelogin;
	
	
	public LoginDataDrivenPage(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	

	public void set_email(String email)
	{
		
		txt_uname.clear();
		txt_uname.sendKeys(email);
		
	}

	
	public void set_pass(String pass)
	{
		
		txt_upass.clear();
		txt_upass.sendKeys(pass);
		
	}
	
	
	public void click_login()
	{
		btn_login.click();
		
		
	}
	
	
	public void click_logout()
	{
		
		btn_logoutavtar.click();
		btn_logout.click();
		
		
	}
	
	
	public void click_homelogin()
	{
		
		btn_homelogin.click();
		
	}

}

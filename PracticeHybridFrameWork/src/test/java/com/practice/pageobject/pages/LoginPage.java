package com.practice.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(xpath="//*[text()='Login']")
	WebElement btn_login;
	
	
	@FindBy(id="signin-email")
	WebElement txt_Email;
	
	
	@FindBy(id="signin-password")
	WebElement txt_password;
	
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btn_submit;
	
	public LoginPage(WebDriver driver)
	{
		
	this.driver = driver;
    PageFactory.initElements(driver, this);
		
	}
	
	
	public void click_Login()
	{
		
		btn_login.click();
		
		
	}
	
	
	
	public void enter_Email(String uname)
	{

		txt_Email.sendKeys(uname);
		
	}
	
	

	public void enter_Password(String upassword)
	{

	txt_password.sendKeys(upassword);
		
	}
	
	public void click_Submmit()
	{
		
	btn_submit.click();
		
		
	}
	
	

}

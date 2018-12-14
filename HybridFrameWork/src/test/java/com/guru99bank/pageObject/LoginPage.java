package com.guru99bank.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public static WebDriver driver;
	
	@FindBy(id="username_or_email")
	WebElement txt_username;
	
	
	@FindBy(id="login_password")
	WebElement txt_password;
	
	
	@FindBy(name="commit")
	WebElement btn_login;
	
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	WebElement btn_bhavesh;
	
	
	
	@FindBy(xpath="//*[text()='Log Out']")
	WebElement btn_logout;
	
	
	@FindBy(xpath="//div[@class='alert alert-danger text-center']")
	WebElement error;
	
	
	public LoginPage(WebDriver driver)
	{
		
	this.driver = driver;	
	PageFactory.initElements(driver, this);	
		
	}
	
	public void setUsername(String uname)
	{
		txt_username.sendKeys(uname);
		
		
	}
	
	public void setPassword(String pass)
	{
		txt_password.sendKeys(pass);
		
		
	}
	
	public void clickLogin()
	{
		btn_login.click();
		
		
	}
	
	public void logOut() throws InterruptedException
	{
		btn_bhavesh.click();
		Thread.sleep(1000);
		btn_logout.click();
		
	}
	 
	public void errorMsg()
	{
		
		String capture = error.getText();
		System.out.println("===========" +capture+"=============");
		
		
	}

}

package com.practice.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	
	public static WebDriver driver;
	
	
	@FindBy(xpath="//a[@class='signup-btn signup']")
	WebElement btn_signup;
	
	
	@FindBy(id="signup-firstname")
	WebElement txt_firstname;
	
	@FindBy(id="signup-lastname")
	WebElement txt_lastname;
	
	@FindBy(id="signup-email")
	WebElement txt_email;
	
	@FindBy(id="signup-password")
	WebElement txt_pass;
	
	@FindBy(id="signup-password2")
	WebElement txt_cpass;

	@FindBy(xpath="//input[@value='Create account']")
	WebElement btn_createacc;
	
	
	
	
	public SignUpPage(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	public void click_signUp()
	{
		
		btn_signup.click();
		
	}
	
	
    public void enter_firstName(String fname)
    {
   txt_firstname.clear();
   txt_firstname.sendKeys(fname);
    	
    }
	
    
    public void enter_lastName(String lname)
    {
    	txt_lastname.clear();
   txt_lastname.sendKeys(lname);
    	
    }
    
    
    public void enter_email(String email)
    {
    	txt_email.clear();
   txt_email.sendKeys(email);
    	
    }
    
    public void enter_password(String password)
    {
    	txt_pass.clear();
   txt_pass.sendKeys(password);
    	
    }
    
    
    public void enter_cpassword(String cpassword)
    {
    	txt_cpass.clear();
   txt_cpass.sendKeys(cpassword);
    	
    }
    
    
    public void click_createacc()
    {
btn_createacc.click();
    	
    }
	
	
}

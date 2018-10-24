package com.practice.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewProfileDataDrivenPage {
	WebDriver driver;

	@FindBy(xpath="//li[@class='myaccount nav-item active']//a[@href='#']")
	WebElement btn_logoutavtar_viewProfileddt;
	
	
	
	@FindBy(xpath="	//*[@href='/users/edit']")
	WebElement btn_viewProfileddt;
	
	
	
	@FindBy(id="user_first_name")
	WebElement txt_firstname_viewProfileddt;
	
	
	@FindBy(id="user_last_name")
	WebElement txt_lastname_viewProfileddt;
	
	
	
	@FindBy(id="user_email")
	WebElement txt_email_viewProfileddt;
	
	
	
	@FindBy(id="user_phone")
	WebElement txt_mobile_viewProfileddt;
	
	
	@FindBy(id="user_password")
	WebElement txt_newpassword_viewProfileddt;
	
	
	@FindBy(id="user_password_confirmation")
	WebElement txt_conirmpassword_viewProfileddt;
	
	
	@FindBy(id="user_current_password")
	WebElement txt_currentpassword_viewProfileddt;
	
	
	
	@FindBy(xpath="//button[@class='btn link save-button']")
	WebElement btn_savechenges_viewProfileddt;
	
	
	
	public ViewProfileDataDrivenPage(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	

	
	public void click_logoutAvtar()
	{
		
	btn_logoutavtar_viewProfileddt.click();	
		
	}
	
	
	public void clickon_viewprofile()
	{
		
	btn_viewProfileddt.click();	
		
		
	}
	
	
	public void edit_firstname(String fname)
	{
		txt_firstname_viewProfileddt.clear();
		txt_firstname_viewProfileddt.sendKeys(fname);
		
		
	}
	
	public void edit_lastname(String lname)
	{
		txt_lastname_viewProfileddt.clear();
		
		txt_lastname_viewProfileddt.sendKeys(lname);
	}

	

	public void edit_email(String emial)
	{
		txt_email_viewProfileddt.clear();
		txt_email_viewProfileddt.sendKeys(emial);
	}
	
	
	public void edit_mobile(String mob)
	{
		txt_mobile_viewProfileddt.clear();
		txt_conirmpassword_viewProfileddt.sendKeys(mob);
	}
	
	public void edit_newpassword(String newPassword)
	{
		txt_newpassword_viewProfileddt.clear();
        txt_newpassword_viewProfileddt.sendKeys(newPassword);
	}
	
	public void edit_confirmnewpassword(String confirmnewPassword)
	{
		txt_conirmpassword_viewProfileddt.clear();
		txt_conirmpassword_viewProfileddt.sendKeys(confirmnewPassword);
	}
	
	public void edit_currentassword(String currentPassword)
	{
		txt_currentpassword_viewProfileddt.clear();
		txt_currentpassword_viewProfileddt.sendKeys(currentPassword);
	}
	
	
	
	public void clickon_savechenges()
	{
		
		btn_savechenges_viewProfileddt.click();
		
		
	}
	
}

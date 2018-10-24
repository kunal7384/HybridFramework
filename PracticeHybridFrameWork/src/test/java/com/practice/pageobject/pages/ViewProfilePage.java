package com.practice.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewProfilePage {
	WebDriver driver;
	

	@FindBy(xpath="//*[@class='myaccount']")
	WebElement btn_logoutavtar_viewProfile;
	
	
	
	@FindBy(xpath="	//*[@href='/users/edit']")
	WebElement btn_viewProfile;
	
	
	
	@FindBy(id="user_first_name")
	WebElement txt_firstname_viewProfile;
	
	
	@FindBy(id="user_last_name")
	WebElement txt_lastname_viewProfile;
	
	
	
	@FindBy(id="user_email")
	WebElement txt_email_viewProfile;
	
	
	
	@FindBy(id="user_phone")
	WebElement txt_mobile_viewProfile;
	
	
	@FindBy(id="user_password")
	WebElement txt_newpassword_viewProfile;
	
	
	@FindBy(id="user_password_confirmation")
	WebElement txt_conirmpassword_viewProfile;
	
	
	@FindBy(id="user_current_password")
	WebElement txt_currentpassword_viewProfile;
	
	
	
	@FindBy(xpath="//button[@class='btn link save-button']")
	WebElement btn_savechenges_viewProfile;
	
	
	
	public ViewProfilePage(WebDriver driver)
	{
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	
	public void click_logoutAvtar()
	{
		
	btn_logoutavtar_viewProfile.click();	
		
	}
	
	
	public void clickon_viewprofile()
	{
		
	btn_viewProfile.click();	
		
		
	}
	
	
	public void edit_firstname(String fname)
	{
		txt_firstname_viewProfile.clear();
		txt_firstname_viewProfile.sendKeys(fname);
		
		
	}
	
	public void edit_lastname(String lname)
	{
		txt_lastname_viewProfile.clear();
		
		txt_lastname_viewProfile.sendKeys(lname);
	}

	

	public void edit_email(String emial)
	{
		txt_email_viewProfile.clear();
		txt_email_viewProfile.sendKeys(emial);
	}
	
	
	public void edit_mobile(String mob)
	{
		txt_mobile_viewProfile.clear();
		txt_mobile_viewProfile.sendKeys(mob);
	}
	
	public void edit_newpassword(String newPassword)
	{
		txt_newpassword_viewProfile.clear();
        txt_newpassword_viewProfile.sendKeys(newPassword);
	}
	
	public void edit_confirmnewpassword(String confirmnewPassword)
	{
		txt_conirmpassword_viewProfile.clear();
		txt_conirmpassword_viewProfile.sendKeys(confirmnewPassword);
	}
	
	public void edit_currentassword(String currentPassword)
	{
		txt_currentpassword_viewProfile.clear();
		txt_currentpassword_viewProfile.sendKeys(currentPassword);
	}
	
	
	
	public void clickon_savechenges()
	{
		
		btn_savechenges_viewProfile.click();
		
		
	}
	
	
	
	
	
	

}

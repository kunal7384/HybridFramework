package com.guru99bank.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99bank.testCases.BaseClass;

public class NewAccountPage {
	public static WebDriver driver;
	
	
	@FindBy(xpath="//*[text()='New Account']")
	WebElement btn_newaccount;
	
	
	@FindBy(name="cusid")
	WebElement txt_custid;
	

	
	
	@FindBy(name="inideposit")
	WebElement txt_initialdepo;;
	
	
	@FindBy(name="button2")
	WebElement btn_submmit;
	
	@FindBy(xpath="//*[@id='account']")
	WebElement txt_account;
	
	
	
	
	public  NewAccountPage(WebDriver driver)
	{
		this.driver = driver;
        PageFactory.initElements(driver, this);
		
	
	}
	
	public void click_newAccount()
	{
		
		btn_newaccount.click();
		
	}
	

	public void setCustomerid(String cusid)
	{
		
		txt_custid.sendKeys(cusid);
		
	}
	
	
	public void clicksubmmit()
	{
		
		btn_submmit.click();
		
	}

	public void enterIntialDeposit(String deposit)
	{
	
	txt_initialdepo.sendKeys(deposit);	
	}
	
	
	public void gettextAccount()
	{
		
	String accountText =txt_account.getText();	
	
	System.out.println("====="+accountText);
		
	}
}

package com.guru99bank.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MiniStatementPage {
	
	public static WebDriver driver;
	
	@FindBy(xpath="//*[text()='Mini Statement']")
	WebElement btn_mini;
	
	
	@FindBy(name="accountno")
	WebElement txt_accountno;
	
	
	@FindBy(name="AccSubmit")
	WebElement btn_submmit;
	
	public MiniStatementPage(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void click_ministatement()
	{
		
		btn_mini.click();
		
	}
	
	
	public void enterAccountno(String aid)
	{
		txt_accountno.sendKeys(aid);
		
		
	}
	
	public void click_submmit()
	{
		btn_submmit.click();
		
	}

}

package com.guru99bank.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BalancEInquiryPage {
	public static WebDriver driver;
	
	
	
	@FindBy(xpath="//*[text()='Balance Enquiry']")
	WebElement btn_balance;
	
	
	@FindBy(name="accountno")
	WebElement txt_accno;
	
	
	
	@FindBy(name="AccSubmit")
	WebElement btn_submmit;
	
	
	
	@FindBy(name="balenquiry")
	WebElement txt_balen;
	
	public BalancEInquiryPage(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	public void click_balance()
	{
		
		btn_balance.click();
		
	}
	

	public void enterAccountno(String accno)
	{
		
		txt_accno.sendKeys(accno);
		
	}

	public void click_submmit()
	{
		
		btn_submmit.click();
		
	}
	
	public void balnce()
	{
	String bal =	txt_balen.getText();
		
		System.out.println("Text Message " + bal);
	}

}

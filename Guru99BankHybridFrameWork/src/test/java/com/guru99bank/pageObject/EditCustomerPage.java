package com.guru99bank.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99bank.testCases.BaseClass;

public class EditCustomerPage  {
	public static WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'Edit Customer')]")
	WebElement btn_editCustomer;
	
	
	
	@FindBy(name="cusid")
	WebElement txt_cusid;
	
	
	@FindBy(name="AccSubmit")
	WebElement btn_submmit;
	
	
	public  EditCustomerPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	public void editCustomer()
	{
		
		btn_editCustomer.click();
		
	}
	
	public void customerid(String cusid)
	{
		
      txt_cusid.sendKeys(cusid);
		
	}
	
	
	public void submmit()
	{
		
		btn_submmit.click();
		
	}

}

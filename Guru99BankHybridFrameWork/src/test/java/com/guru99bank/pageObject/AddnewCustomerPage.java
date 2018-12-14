package com.guru99bank.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddnewCustomerPage {
	
	public static WebDriver driver;
	@FindBy(xpath="//*[text()='New Customer']")
	WebElement btn_newcustomer;
	
	
	
	@FindBy(name="name")
	WebElement txt_customername;
	
	
	
	
	@FindBy(name="rad1")
	WebElement rad_male;
	
	
	@FindBy(name="dob")
	WebElement txt_dob;
	
	
	@FindBy(name="addr")
	WebElement txt_address;
	
	
	
	@FindBy(name="city")
	WebElement txt_city;
	
	
	
	@FindBy(name="state")
	WebElement txt_state;
	
	
	

	@FindBy(name="pinno")
	WebElement txt_pinno;
	
	

	@FindBy(name="telephoneno")
	WebElement txt_telphone;
	
	

	@FindBy(name="emailid")
	WebElement txt_email;
	
	

	@FindBy(name="password")
	WebElement txt_password;
	
	
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement btn_submmit;
	
	public  AddnewCustomerPage(WebDriver driver)
	{
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void clickCustomer()
	{
	btn_newcustomer.click();	
		
		
	}
	
	public void setCustomerName(String firstname)
	{
	 txt_customername.sendKeys(firstname);
	}

	
	public void checkRadioBox()
	{
		
	boolean result = rad_male.isDisplayed()	;
	System.out.println("Check Box is Displayed " + result);
	
	boolean result1 = rad_male.isEnabled();
	
	
	System.out.println("Check Box is Enable " + result1);
	
	
	boolean result2 = rad_male.isSelected();
	
	System.out.println("Check Box Before click is selected " + result1);
	rad_male.click();	
	

	boolean result3 = rad_male.isSelected();
	
	System.out.println("Check Box After click is selected " + result1);
		
	}
	
	
	public void setDateofBirth()
	{
	txt_dob.sendKeys("01");
	txt_dob.sendKeys("02");	
	txt_dob.sendKeys("1990");
	}
	  
	public void setAddress(String add)
	{
		
		
		txt_address.sendKeys(add);
	}
	
	public void setCity(String city)
	{
		
		
		txt_city.sendKeys(city);
	}
	
	
	public void setState(String state)
	{
		
		
		txt_state.sendKeys(state);
	}
	
	
	public void setPinno(String pin)
	{
		
		
		txt_pinno.sendKeys(pin);
	}
	
	
	public void setphone(String phone)
	{
		
		
		txt_telphone.sendKeys(phone);
	}
	
	public String setEmail(String email)
	{
		
		
		txt_email.sendKeys(email);
		return email;
	}
	
	
	public void setpassword(String password)
	{
		
		
		txt_password.sendKeys(password);
	}
	
	public void clickSubmit()
	{
		
		btn_submmit.click();
		
		System.out.println("checking");
		
	}
	
}

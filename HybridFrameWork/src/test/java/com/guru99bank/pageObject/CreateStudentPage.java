package com.guru99bank.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateStudentPage {
	
	public static WebDriver driver;
	
	@FindBy(id="Layer_1")
	WebElement link_student;
	
	@FindBy(id="user_fname")
	WebElement txt_fname ;
	
	
	
	@FindBy(id="user_lname")
	WebElement txt_lname;
	
	
	@FindBy(id="user_username")
	WebElement txt_username ;
	
	
	@FindBy(id="user_email")
	WebElement txt_email;
	
	@FindBy(id="user_password")
	WebElement txt_password ;

	@FindBy(id="user_password_confirmation")
	WebElement txt_cpassword;
	
	
	

	@FindBy(id="user_favorites")
	WebElement txt_fav;
	
	
	@FindBy(id="user_notes")
	WebElement txt_notes;
	

	public CreateStudentPage(WebDriver driver)
	{
		
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	public void createStudent()
	{
		link_student.click();
	
	
	}
	
	public void setFirstname(String name)
	{
		txt_fname.sendKeys(name);
	
	}
	
	public void setLastname(String lastname)
	{
		txt_lname.sendKeys(lastname);
	
	}
	
	public void setUsername(String username)
	{
		txt_username.sendKeys(username);
	
	}
	
	public void setEmail(String email)
	{
		txt_email.sendKeys(email);
	
	}
	public void setpassword(String pass , String cpass)
	{
		txt_password.sendKeys(pass);
		txt_cpassword.sendKeys(cpass);
	
	}
	
	public void enterFavoritr(String fave)
	{
		txt_fav.sendKeys(fave);
	
	}

	public void setnote(String note)
	{
		txt_notes.sendKeys(note);
	
	}
	
}

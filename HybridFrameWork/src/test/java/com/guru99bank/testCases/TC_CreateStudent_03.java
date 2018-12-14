package com.guru99bank.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99bank.pageObject.CreateStudentPage;
import com.guru99bank.pageObject.LoginPage;

public class TC_CreateStudent_03 extends BaseClass {
	
	
	
	@Test
	public void createStudent() throws IOException
	{
	LoginPage login = new LoginPage(driver)	;
		
	login = new LoginPage(driver);
	logger.info("Entered Username for creating Student");
	login.setUsername(username);
	logger.info("Entered password for creating Student");
	login.setPassword(password);
	logger.info("Clicked on Login for Creating new Student");
	login.clickLogin();
	
	if(driver.getTitle().equals("Practice Pad"))
	{
		logger.info("verifying Title");
		Assert.assertTrue(true);
		
	}
	
	else
	{
		captureScreenshot(driver, "Login");
		Assert.assertTrue(false);
	
		
	}
		
		CreateStudentPage create = new CreateStudentPage(driver);
		
		create.createStudent();
		logger.info("Entered First name");
		create.setFirstname("kd");
		logger.info("Entered lastt name");
		create.setLastname("kdd");
		logger.info("Entered Userr name");;
		create.setUsername("bmm");
		logger.info("Entered Email");
		create.setEmail("kdd@gmail.com");
		logger.info("Entered password and Confirm password");
		create.setpassword("password", "password");
		logger.info("Entered Favorite Thing");
		create.enterFavoritr("jshfjdhjfhdjf");
		logger.info("Entered Notes");
		create.setnote("fbdhvfhdvbhbdhb");
		
	}

}

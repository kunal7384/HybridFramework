package com.practice.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.pageobject.pages.LoginPage;

public class LoginTest extends BaseClass {
	
	LoginPage login;
	String excepted = "kd@narola.email";
	
       @Test(priority=9,description="Valid Login")
       public void verifu_Login() throws InterruptedException, IOException
       {
    	   
    	
    	login = new LoginPage(driver);
    	login.click_Login();
    	login.enter_Email(userName);
    	login.enter_Password(passWord);
    
    	login.click_Submmit();
    	
    String actualmsg = driver.findElement(By.xpath("//*[@class='myaccount']")).getText();
    
    System.out.println(actualmsg);
    
    
    	
   if(excepted!="kd@narola.email")
   {
	  
	   System.out.println("Login Invalid");
	 add_screenShot(driver, "login");;  
	 Assert.assertTrue(false);
	
	   
   }
   else
   {
	   Assert.assertEquals(actualmsg, excepted);
	   System.out.println("Login Sucessfully");
   }
       }
	

}

package com.practice.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.pageobject.pages.LoginPage;
import com.practice.pageobject.pages.ViewProfilePage;

public class ViewProfileTest extends BaseClass{
	
	LoginPage login;
	
	ViewProfilePage viewpage;
	
	String excepted ="First name can't be blank";
	 String excepted1 = "Last name can't be blank";
	  
	 String excepted2="Mobile can't be empty";
	 String excepted3="First name can't be blank\n" + 
	 		              "Current password can't be blank";

	 
	 String excepted4="Last name can't be blank\n" + 
	 		                        "Current password can't be blank";
	 
	 
	 String excepted5 ="Mobile can't be empty\n" + 
	 		"Current password can't be blank" ;
	 		
	 
      @Test(priority=13,description="Login for View Profile")

   public void login()
   {
	login = new LoginPage(driver);
	login.click_Login();
	login.enter_Email(userName);
	login.enter_Password(passWord);
	
	login.click_Submmit();
     } 
	
	

      @Test(priority=14,description="View Profile -Remove First NAme")

   public void edit_profile_remove_firstname() throws InterruptedException
   {
    	  Thread.sleep(2000);
    viewpage= new ViewProfilePage(driver);  
     

    viewpage.click_logoutAvtar();
    
    viewpage.clickon_viewprofile();
    Thread.sleep(1000);
    viewpage.edit_firstname("");
    
    viewpage.edit_currentassword("password");
    
    Thread.sleep(1000);
    viewpage.clickon_savechenges();
    String actual = driver.findElement(By.xpath("//li[contains(text(),\"First name can't be blank\")]")).getText();
    System.out.println(actual);
    System.out.println("======================================");
    
    if(actual.contains(excepted))
    
    {
    	Assert.assertTrue(true);
    	
    }
    
    else
    {
    	
    Assert.assertTrue(false);
    	
    }
        
   }
	
      @Test(priority=15,description="View Profile -Remove LAst NAme")
      public void remove_lastName() throws InterruptedException
      {
    	  Thread.sleep(2000);
     viewpage.edit_firstname("jigar"); 
    	  viewpage.edit_lastname("");
    	  viewpage.edit_currentassword("password");
    	  viewpage.clickon_savechenges();
    	  
  String actualmsg = driver.findElement(By.xpath("//li[contains(text(),\"Last name can't be blank\")]")).getText();
  
  System.out.println(actualmsg);
  System.out.println("======================================");
  
  if(actualmsg.contains(excepted1))
  {
	  Assert.assertTrue(true);
	  
  }
  
  
  else
  {
	  
	    Assert.assertTrue(false); 
	  
  }
    	  
      }


      @Test(priority=16,description="View Profile -Remove Mobile")
      public void remove_mobile() throws InterruptedException
      {
    	  Thread.sleep(2000);
    	  viewpage.edit_firstname("jigar"); 
    	  viewpage.edit_lastname("Narola");
    	  
    	  viewpage.edit_mobile("");
    	  
    	  viewpage.edit_currentassword("password");
    	  viewpage.clickon_savechenges(); 
    	  
    String actualmsg1=	driver.findElement(By.xpath("//li[contains(text(),\"Mobile can't be empty\")]")).getText();
    
    System.out.println(actualmsg1);
    
    System.out.println("======================================");
    	  
    	  if(actualmsg1.contains(excepted2))
    	  {
    		  Assert.assertTrue(true);
    		  
    	  }
    	  
    	  
    	  else
    	  {
    		  
    		    Assert.assertTrue(false); 
    		  
    	  }
    	  
      }
      
   /*   @Test(priority=4)
      public void mobile_validation()
      {
    	  
    	for(int i=0;i<10;i++)  
    	{
    		
    		
    		for(int s=0;s<i;s++)
    		{
    			
    			System.out.print(s);
    		
    			
    		}
    		System.out.println("");
    	
    WebElement ele = driver.findElement(By.id("user_phone"));
    ele.clear();
    ele.sendKeys("System.out.println(\"\")");
    
    	}

		
    	  
      }*/
      
      
      @Test(priority=17,description="View Profile -Remove First NAme and do not enter current password ")
      public void remove_firstname_withoutfilling_cutrrent_password() throws InterruptedException
      {
      Thread.sleep(2000);
    	  viewpage.edit_firstname(""); 
    	//  viewpage.edit_lastname("narola");
    	  
    	  viewpage.edit_mobile("0123456789");
    	  
    	 
    	  viewpage.clickon_savechenges();
    	  
    	 String actualmsg2 = driver.findElement(By.xpath("//div[@id='error_explanation']//ul")).getText();
    	 System.out.println(actualmsg2);
    	
    	 System.out.println("======================================");
    	  if(actualmsg2.contains(excepted3))
    	  {
    		  Assert.assertTrue(true);
    		  
    	  }
    	  
    	  
    	  else
    	  {
    		  
    		    Assert.assertTrue(false); 
    		  
    	  }
    	  
          }
      @Test(priority=18,description="View Profile -Remove last NAme and do not enter current password ")
      public void remove_lasname_withoutfilling_cutrrent_password() throws InterruptedException
      {
    	  Thread.sleep(2000);
    	  viewpage.edit_firstname("Jigar"); 
    	  viewpage.edit_lastname("");
    	  
    	 // viewpage.edit_mobile("0123456789");
    	  
    	 
    	  viewpage.clickon_savechenges();
    	  
    	  String actualmsg3 = driver.findElement(By.xpath("//div[@id='error_explanation']//ul")).getText();
     	 System.out.println(actualmsg3);
     	 
     	System.out.println("======================================");
     	
     	  
     	  if(actualmsg3.contains(excepted4))
     	  {
     		  Assert.assertTrue(true);
     		  
     	  }
     	  
     	  
     	  else
     	  {
     		  
     		    Assert.assertTrue(false); 
     		  
     	  }
      
      }
      
      @Test(priority=19,description="View Profile -Remove mobile and do not enter current password ")
      public void remove_mobile_withoutfilling_cutrrent_password() throws InterruptedException
      {
    	  Thread.sleep(2000);
    	  
    	  viewpage.edit_firstname("Jigar"); 
    	  viewpage.edit_lastname("narola");
    	  viewpage.edit_mobile("");
    	  
    	  viewpage.clickon_savechenges();
    	  
    	  
    	  String actualmsg4 = driver.findElement(By.xpath("//div[@id='error_explanation']//ul")).getText();
     	 System.out.println(actualmsg4);
     	System.out.println("======================================");
     	 
     	 if(actualmsg4.contains(excepted5))
    	  {
    		  Assert.assertTrue(true);
    		  
    	  }
    	  
    	  
    	  else
    	  {
    		  
    		    Assert.assertTrue(false); 
    		  
    	  }
     	 
      }

}

package com.guru99bank.testCases;

import java.io.File;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.guru99bank.utilities.ConfigReader;

public class BaseClass {
	ConfigReader cf = new ConfigReader();
	public static WebDriver driver;
	public  String baseUrl=cf.geturl();
	public  String userName =cf.getUsername();
	public  String passWord =cf.getPAssWord();
	
	 @Parameters("browser")
	 @BeforeClass
		public void setup(String browsername)
		{
		if(browsername.equalsIgnoreCase("chrome"))	
		{
		    driver = new ChromeDriver();	
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
		}
		
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			
			System.setProperty("webdriver.gecko.driver","F:\\Selemnium Practice code Aug 2018\\HybridFrameWork\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		
		
		
		
		 driver.get(baseUrl); 
		}
	 
	 
	 public static String randomeString()
		{
			
			String genarateString1 = RandomStringUtils.randomAlphabetic(8);
			return genarateString1;
			
			
		}
	 @AfterClass
		
		public void tearDown()
		{
			
		driver.close();	
			
		} 
		
     
	 public void addScreenShot(WebDriver driver ,String tname) throws IOException
	 {
		 
		 TakesScreenshot  ts = (TakesScreenshot)driver;
		  File source = ts.getScreenshotAs(OutputType.FILE);
		//  File target = new File(System.getProperty("user.dir") + "/screenshot/" +tname +".png");
		  
		  File target = new File("F:\\Selemnium Practice code Aug 2018\\Guru99BankHybridFrameWork\\ScreenShot\\" +tname +".png");
		  FileUtils.copyFile(source, target); 
		 
	  
	 }
	 
	 
	 public static boolean isAlertPresent(){
		    try{
		    Alert alert = driver.switchTo().alert();
		    System.out.println(alert.getText()+" Alert is Displayed");
		    alert.accept();
		    return true;
		    }
		    catch(NoAlertPresentException ex){
		    System.out.println("Alert is NOT Displayed");
		    return false;
		    }
			
		    }
}

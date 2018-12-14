package com.guru99bank.testCases;

import java.io.File;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.guru99bank.utilities.ConfigReader;
import com.guru99bank.utilities.ExcelReader;

public class BaseClass {
	public static WebDriver driver;
	
	ConfigReader config  = new ConfigReader();
	public String username= config.getUsername();
	public String password = config.getPassword();
	public String baseUrl = config.getBaseurl();
   public static  Logger logger;
	@Parameters("browser")
	@BeforeClass
	public void setup(String browsername)
	{
		logger =Logger.getLogger("Baseclass");
		  PropertyConfigurator.configure("log4j.properties");

		config = new ConfigReader();
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			logger.info("Open Chrome Browser");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		}
		
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","F:\\Selemnium Practice code Aug 2018\\HybridFrameWork\\Driver\\geckodriver.exe");
			logger.info("Open FireFox Browser");
			driver = new FirefoxDriver();
			
			
			
		}
		
		logger.info("Opening URL ");
		
		driver.get(baseUrl);
		 
	}
	  public void captureScreenshot(WebDriver driver , String tname) throws IOException
	  {
		TakesScreenshot  ts = (TakesScreenshot)driver;
		  File source = ts.getScreenshotAs(OutputType.FILE);
		//  File target = new File(System.getProperty("user.dir") + "/screenshot/" +tname +".png");
		  
		  File target = new File("F:\\Selemnium Practice code Aug 2018\\HybridFrameWork\\screenshotTaken\\" +tname +".png");
		  FileUtils.copyFile(source, target);
		
	  }
	
	 
	  public String[][] readdata(String excelname , String sheetname)
	  {
		  
		 ExcelReader excel = new ExcelReader();
		return excel.getexceldata("C:\\Users\\dkunal\\Desktop\\test.xls", "Sheet1");
		 
		  
		  
		  
		  
	  }
	
	/*@AfterClass

	public void close()
	{
		
	driver.close();
	}*/

}

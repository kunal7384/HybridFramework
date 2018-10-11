package com.guru99bank.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	
	public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;
    public static WebDriver driver;
     
   
    public void onStart(ITestContext testContext)
    {
    	
    	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/Guru99 Bank.html");
    //	htmlReporter = new  ExtentHtmlReporter("extent.html");
    	htmlReporter.loadXMLConfig(new File("F:\\Selemnium Practice code Aug 2018\\Guru99BankHybridFrameWork\\Config\\extentconfig.xml"));
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("OS", " Win10");
        extent.setSystemInfo("Host Name", "kd");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "kd");
         
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("AutomationTesting.in Demo Report");
        htmlReporter.config().setReportName("Guru99 Bank Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }
    public void onTestSuccess(ITestResult tr)
    
    
    
    {
    	

    	logger = extent.createTest(tr.getName());
    	
    	
    	 logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName()+" Test Case PASSED", ExtentColor.GREEN));
    	 
    	 
    }
    
    public void onTestFailure(ITestResult tr) {
    	
    	logger = extent.createTest(tr.getName());
    	
    	 logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
    	  logger.fail(tr.getThrowable());
    	 
    	 String screenshotPath = "F:\\Selemnium Practice code Aug 2018\\Guru99BankHybridFrameWork\\ScreenShot\\" +tr.getName() +".png";
    	 
    	 File f = new File(screenshotPath);
    	 
    	 if(f.exists())
    	 {
    		 try {
				logger.fail("Screenshot is below" +logger.addScreenCaptureFromPath(screenshotPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("not taken Screen Shot");
			}
    		 
    	 }
    	
      }
    	 
    	 
    public void onTestSkipped(ITestResult tr) {
    	logger = extent.createTest(tr.getName());
    	
    	 logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
    	 
    	  logger.fail(tr.getThrowable());
      }
    	 
    	 
    public void onFinish(ITestContext testContext)
    {
    	extent.flush();
    	
    
    	
    }

}

package com.guru99bank.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting  extends TestListenerAdapter
{

	public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;
    public static WebDriver driver;
     
   @BeforeSuite
    public void onStart(ITestContext testContext)
    {
    	
    	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/MyOwnReport.html");
    //	htmlReporter = new  ExtentHtmlReporter("extent.html");
    	htmlReporter.loadXMLConfig(new File("F:\\Selemnium Practice code Aug 2018\\HybridFrameWork\\config\\extentconfig.xml"));
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("OS", " Win10");
        extent.setSystemInfo("Host Name", "kd");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "kd");
         
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("AutomationTesting.in Demo Report");
        htmlReporter.config().setReportName("My Own Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }
   
   @AfterMethod
    public void onTestSuccess(ITestResult tr)
    
    
    
    {
    	

    	logger = extent.createTest(tr.getName());
    	
    	
    	 logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName()+" Test Case PASSED", ExtentColor.GREEN));
    	 
    	 
    }
   @AfterMethod
    public void onTestFailure(ITestResult tr) {
    	
    	logger = extent.createTest(tr.getName());
    	
    	 logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
    	  logger.fail(tr.getThrowable());
    	 
    	 String screenshotPath = "F:\\Selemnium Practice code Aug 2018\\HybridFrameWork\\screenshotTaken\\" +tr.getName() +".png";
    	 
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
    	 
   @AfterMethod
    public void onTestSkipped(ITestResult tr) {
    	logger = extent.createTest(tr.getName());
    	
    	 logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
    	 
    	  logger.fail(tr.getThrowable());
      }
    	 
   @AfterClass 	 
    public void onFinish(ITestContext testContext)
    {
    	extent.flush();
    	
    
    	
    }
    	
    
  
   /* public void getResult(ITestResult result)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        else
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
            
            
        }*/
        
       
    
     
   
   
}

	/*ExtentReports report;
	ExtentTest logger; 
	WebDriver driver;
	
	
	public void onTestStart(ITestContext context) {
		
		String timeStmap = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		String repName = "Test -Report -" + timeStmap +".html";
		
		report=new ExtentReports("F:\\Selemnium Practice code Aug 2018\\HybridFrameWork\\test-output" +repName );
		
	//	report=new ExtentReports(System.getProperty("user.dir") + "/extentconfig.xml");
		
	   report.loadConfig(new File("F:\\Selemnium Practice code Aug 2018\\HybridFrameWork\\config\\extentconfig.xml"));
		  
	   report.addSystemInfo("User Name", System.getProperty("user.name"));
	   report.addSystemInfo("Time Zone", System.getProperty("user.timezone"));
	   report.addSystemInfo("Machine", 	"Windows 10" + "64 Bit");
	   report.addSystemInfo("Selenium", "3.7.0");
	   report.addSystemInfo("Maven", "3.5.2");
	   report.addSystemInfo("Java Version", "1.8.0_151");
	
	
	 

			report.endTest(logger);
			report.flush();
			driver.get("F:\\Selemnium Practice code Aug 2018\\HybridFrameWork\\test-output\\repName");
		} */
		
		
		


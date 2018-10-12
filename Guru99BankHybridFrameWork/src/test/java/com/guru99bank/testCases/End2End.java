package com.guru99bank.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.guru99bank.pageObject.LoginDataDrivenPage;
import com.guru99bank.pageObject.LoginPage;

import jxl.read.biff.BiffException;

public class End2End extends BaseClass{
	
	LoginTest logintest;
	EditCustomer editcustomer;
	LoginDataDrivenTest logindatadriven;
	LoginDataDrivenPage loginddt;
	
	   NewAccount newaccount;
	   BalancEInquiry balanceenquiry;
	AddNewCustomer addnewcustomer;
	MiniStatement ministmt;
	@Test(priority=1,dataProvider= "logindata",dataProviderClass=LoginDataDrivenTest.class)
	public void login_using_datadriveren(String uid ,String uipass) throws IOException, BiffException, InterruptedException {
		logindatadriven = new LoginDataDrivenTest();
		
		
		logindatadriven.verifyLoginDDT(uid, uipass);
		loginddt = new LoginDataDrivenPage(driver);
		
		System.out.println("=======login Data Driven Finished============");
	}
		@Test(priority=2)
		public void login_valid() throws IOException, InterruptedException
		{
			
			System.out.println("=======login Start============");
		logintest =new LoginTest();
		logintest.validlogin();
		
		
		System.out.println("=======login Finished============");
		//Add NEw customer
		 addnewcustomer = new AddNewCustomer();
		 addnewcustomer.create_new_Customer();
		   
		 
		 System.out.println("=======Add New Customer  Finished============");
	}	
		   @Test(priority=3 ,dataProvider="testdata",dataProviderClass=EditCustomer.class)
			public void editcustomer_using_datadriven(String cid ) throws IOException
			{
			editcustomer = new EditCustomer();
		editcustomer.editaccount(cid);
		
		System.out.println("=======Edit Account Finished============");
		
		
	}
		   
		   @Test(priority=4)
		   public void createnewaccount() throws InterruptedException
		   {
			   System.out.println("=======Create New Account Start1============");
			  newaccount= new NewAccount(); 
			   System.out.println("=======Create New Account Start2============");
			   newaccount.invalid_new_account();
			  newaccount.invalid_new_account_invalidcustomerid();
			   System.out.println("=======Create New Account Start3============");
			  newaccount.invalid_new_account_intialdeposite();
			   System.out.println("=======Create New Account Start4============");
			  newaccount.verify_newAccount();
			 
		   }
	
	

		   @Test(priority=5 ,dataProvider="accountdata",dataProviderClass=BalancEInquiry.class)
			public void balance_enquiry_datadriven(String accountid ) throws InterruptedException
			{
			   
			   balanceenquiry= new BalancEInquiry();
			   balanceenquiry.verifyBalance(accountid);
			   
			}
			   
		   

		   @Test(priority=6 ,dataProvider="minidata",dataProviderClass=MiniStatement.class)
			public void ministmt_using_datadriven(String miniid)
			
			{
	       ministmt = new MiniStatement();
		   ministmt.ministatement_ddt(miniid);
	
	
	   
}

}

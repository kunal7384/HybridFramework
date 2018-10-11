package com.guru99bank.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	File file ;
	 FileInputStream fis;
	 Properties pro;
	 
	 
	public ConfigReader() 
	{
	try {
		file = new File("F:\\Selemnium Practice code Aug 2018\\Guru99BankHybridFrameWork\\Config\\config.properties")	;
		fis= new FileInputStream(file);
		pro = new Properties();
		pro.load(fis);
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}
	
	public String getUsername()
	{
	String uname = pro.getProperty("Username");
	return uname;

	}
	
	public String getPAssWord()
	{
	String upass = pro.getProperty("Password");
	return upass;

	}
	
	
	public String geturl()
	{
String url = pro.getProperty("baseUrl");

return url;

	}

}

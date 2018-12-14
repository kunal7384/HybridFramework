package com.guru99bank.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	File file ;
	FileInputStream fis ;
	Properties pro;
	
	
	
	
	
	
	public ConfigReader()
	{
		
	try {
		file = new File("F:\\Selemnium Practice code Aug 2018\\HybridFrameWork\\config\\config.properties"); 	
			fis = new FileInputStream(file);
			pro = new Properties();
			pro.load(fis);
	
	} catch (IOException e) {
		
		e.printStackTrace();
	}
		
	}

	public String getUsername()
	{
		String name = pro.getProperty("Username");
		return name;
		
		
		
	}
	
	public String getPassword()
	{
		String Pass = pro.getProperty("Password");
		return Pass;
		
		
		
	}
	
	public String getBaseurl()
	{
		String url = pro.getProperty("baseUrl");
		return url;
		
		
		
	}
	
	// For Extent Report
	
	
	public String gextentReport()
	{
	String extent_report_path =pro.getProperty("extentpath");
	
	if(extent_report_path!= null) return extent_report_path;
	else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:extent_report_path");
		
		
		
	}
	
}

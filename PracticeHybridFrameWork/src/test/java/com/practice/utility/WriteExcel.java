package com.practice.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcel {
	
	@Test
	
	public void writeexcel() throws IOException, InvalidFormatException
	{
		
		
		File file = new File("F:\\Selemnium Practice code Aug 2018\\PracticeHybridFrameWork\\src\\test\\java\\com\\practice\\testdata\\logindata.xls");
		FileInputStream fis = new FileInputStream(file);
		
		//XSSFWorkbook wb = new XSSFWorkbook();
		
		 org.apache.poi.ss.usermodel.Workbook wb = WorkbookFactory.create(fis);
		
	//	XSSFSheet st = wb.getSheetAt(0);
		
		 
		 org.apache.poi.ss.usermodel.Sheet st = wb.getSheet("Sheet1");
		st.getRow(0).createCell(2).setCellValue("LoginType");
		
		st.getRow(1).createCell(2).setCellValue("Valid Login");
		
		
		st.getRow(2).createCell(2).setCellValue("InValid Login");
		
		
		st.getRow(3).createCell(2).setCellValue("InValid Login");
		
		
		st.getRow(4).createCell(2).setCellValue("InValid Login");
		
		
		st.getRow(5).createCell(2).setCellValue("Valid Login");
		
		FileOutputStream fos = new FileOutputStream(file);
		
		wb.write(fos);
		
		
	}

}

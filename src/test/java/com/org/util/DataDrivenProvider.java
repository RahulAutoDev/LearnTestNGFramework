package com.org.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenProvider {
	
	static File file;
	static FileInputStream fis;
	static XSSFSheet testDataSheet;
	static XSSFWorkbook myExcel;
	
	public static Object[][] getDataProvider()
	{
		try {
			file = new File("/Users/rahulsingh/Desktop/MyComputer/Automation/TestNgDataDrivenTest.xlsx");
			fis = new FileInputStream(file);
			myExcel = new XSSFWorkbook(fis);
			testDataSheet = myExcel.getSheet("TestData1");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		int rowCount = testDataSheet.getPhysicalNumberOfRows();
		XSSFRow rownum =  testDataSheet.getRow(0);
		int colCount = rownum.getLastCellNum();
		XSSFCell cell;
		
		Object Data[][]= new Object[rowCount-1][colCount];
		
		for(int i=1; i < rowCount; i++)
		{	
			for(int j=0; j < colCount; j++)
			{
				XSSFRow row =  testDataSheet.getRow(i);
				cell = row.getCell(j);
				Data[i-1][j] = cell.getStringCellValue();
			}
		}
		
		return Data;

	}

	

}

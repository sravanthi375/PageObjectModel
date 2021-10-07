package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.crm.qa.base.TestBase;

public class Testutil extends TestBase {

	public  WebDriver driver;
	
	public Testutil(WebDriver driver) {
	
		this.driver=driver;
	}
	
	public static long Page_Load_TimeOut=50;
	public static long Implicit_Wait_TimeOut=50;
	
	
	
	public static ArrayList<Object[]> getFreeCRMTestData(String sheetname) throws IOException{
		
		ArrayList<Object[]> list=new ArrayList<Object[]>();
		
		FileInputStream fis=new FileInputStream("C:\\Sravanthi\\myworkspace\\FreeCRMTest\\src\\"
				+ "main\\java\\com\\crm\\qa\\testdata\\FreeCRM_TestData.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		 int rows=sheet.getLastRowNum();
		for(int i=1;i<=rows;i++) {
			String fstname=sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println(fstname);
			String lstname=sheet.getRow(i).getCell(1).getStringCellValue();
			System.out.println(lstname);
			String ctgry=sheet.getRow(i).getCell(2).getStringCellValue();
			System.out.println(ctgry);
			String status=sheet.getRow(i).getCell(3).getStringCellValue();
			System.out.println(status);
			
			Object[] obj= {fstname,lstname,ctgry,status};
			list.add(obj);
		}
		return list;
	}
	
	public  void takeScreenshotAtEndOfTest(String testMethodName) {
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(file, new File("C:\\Sravanthi\\myworkspace\\"
					+ "FreeCRMTest\\src\\test\\java\\screenshots\\"+testMethodName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}


package com.qa.Extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.crm.qa.base.TestBase;

public class ExtentReportNG extends TestBase{
	
	static ExtentReports extent;
	
	public static synchronized ExtentReports getReportObject() {
		
		String path = "C:\\Sravanthi\\myworkspace\\FreeCRMTest\\reports\\"+"index.html";

		ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);

		reporter.config().setReportName("Web Automation Results");

		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Tester", "Sravanthi");
		
		return extent;
		
	}
	
}
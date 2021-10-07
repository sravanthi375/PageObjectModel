package com.crm.qa.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.Testutil;
import com.qa.Extentreport.ExtentReportNG;

public class CustomListener extends TestBase implements ITestListener {

	Testutil testutil;

	public CustomListener() {
		driver = initialization();
		testutil = new Testutil(driver);
	}

	ExtentReports extent = ExtentReportNG.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> local = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());
		local.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		local.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		local.get().fail(result.getThrowable());

		testutil.takeScreenshotAtEndOfTest(result.getMethod().getMethodName());
		try {

			local.get().addScreenCaptureFromPath(
					"C:\\Sravanthi\\myworkspace\\FreeCRMTest\\src\\test\\java\\screenshots",
					result.getMethod().getMethodName());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
	   extent.flush();
	}

	


}

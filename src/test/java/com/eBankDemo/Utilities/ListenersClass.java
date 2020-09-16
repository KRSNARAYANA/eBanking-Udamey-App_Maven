package com.eBankDemo.Utilities;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.eBankDemo.testCases.BaseClass;

public class ListenersClass extends BaseClass implements ITestListener {
	
	public ExtentReports extent = ExtentManager.createInstance();
	public ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
	
		ExtentTest test = extent.createTest(result.getClass().getName()+" @ Test Case : : "+result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Case Passed is: "+result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().log(Status.FAIL, "Test Case Failed is: "+result.getMethod().getMethodName());
		extentTest.get().log(Status.FAIL, "Test Case Failed is: "+Arrays.toString(result.getThrowable().getStackTrace()));
		
		try {
			String screenPath=captureScreen(driver, result.getMethod().getMethodName());
			extentTest.get().fail("<b><font color=red>"+"Screenshot for Failure"+"</font></b>", 
						MediaEntityBuilder.createScreenCaptureFromPath(screenPath).build());			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
		extentTest.get().log(Status.SKIP, "Test Case Skipped is: "+result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		if(extent!=null) {
			extent.flush();
		}
		
	}

}

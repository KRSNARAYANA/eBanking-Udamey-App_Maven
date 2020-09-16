package com.eBankDemo.Utilities;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	public static ExtentReports createInstance() {
		
		Date date = new Date();
		String fileName = "ExtentReport_"+date.toString().replace(":", "_").replace(" ", "_")+".html";
		String path = System.getProperty("user.dir")+"/ExtentReports/"+fileName;
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("eBankingDemoProject");
		htmlReporter.config().setReportName("DemoProject Extent Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("HostName", "LocalHost");
        extent.setSystemInfo("ProjectName", "TestProject");
        extent.setSystemInfo("Tester", "Surya");
        extent.setSystemInfo("OS", "Win10");
        extent.setSystemInfo("Browser", "Chrome");
        
        return extent;
	}
	

}

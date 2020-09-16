package com.eBankDemo.testCases;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eBankDemo.Utilities.XLUtility;
import com.eBankDemo.pageObjects.LoginPage;


public class TC_DDLogin_TC002 extends BaseClass{
		
	@Test(dataProvider = "testData")
	public void loginDDTest(String uid, String pwd1) throws InterruptedException {
		driver.get(url);
		logger.info("Navigate the Login page with Given URL");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(uid);
		logger.info("Entered the User Name");
		lp.setPassword(pwd1);
		logger.info("Entered the Password");
		lp.clickSubmit();
		logger.info("Click on Submit Button");
		Thread.sleep(3000);
		if(driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			Assert.assertTrue(true);
			logger.info("Verified the DashBoard Page and Login Passed");
			Reporter.log("Verified the DashBoard Page and Login Passed");
			System.out.println("PASS");
			lp.clickLogOut();
		}
		else {
			System.out.println("FAIL");
			logger.info("Verified the DashBoard Page and Login Failed");
			Reporter.log("Verified the DashBoard Page and Login Failed");
			Assert.assertTrue(false);
		}
	}
	
	@DataProvider(name = "testData")
	public String[][] testDate(){
		String filePath = "./src/test/java/com/eBankDemo/TestData/LoginTestData.xlsx";
		String sheetName = "DDData";
		XLUtility excel =new XLUtility(filePath, sheetName);
		int rowCount=excel.getRowCount();
		int columnCount=excel.getColumnCount(0);
		System.out.println(rowCount);
		System.out.println(columnCount);
		String xldata [][]  = new String [rowCount][columnCount];
		for(int r=1;r<=rowCount;r++) {
			for(int c=0;c<columnCount;c++) {
				xldata[r-1][c] = excel.getCellDate(r, c);
			}
		}
		return xldata;
	
	}

}

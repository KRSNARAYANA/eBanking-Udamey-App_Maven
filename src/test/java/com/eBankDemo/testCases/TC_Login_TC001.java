package com.eBankDemo.testCases;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.eBankDemo.pageObjects.LoginPage;


public class TC_Login_TC001 extends BaseClass{
	
	@Test
	public void TC_Login() throws Exception {
		driver.get(url);
		logger.info("Navigate the Login page with Given URL");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("Entered the User Name");
		lp.setPassword(Password);
		logger.info("Entered the Password");
		lp.clickSubmit();
		logger.info("Click on Submit Button");
		Thread.sleep(3000);
		if(driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			Assert.assertTrue(true, "Test Case Passed");
			logger.info("Verified the DashBoard Page and Login Passed");
			Reporter.log("Verified the DashBoard Page and Login Passed");
			System.out.println("PASS");
			lp.clickLogOut();
		}
		else {
			System.out.println("FAIL");
			logger.info("Verified the DashBoard Page and Login Failed");
			Reporter.log("Verified the DashBoard Page and Login Failed");
		}
	}
	
	

}

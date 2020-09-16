package com.eBankDemo.testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.eBankDemo.pageObjects.AddCustomersPage;
import com.eBankDemo.pageObjects.LoginPage;

public class TC_AddCustomers_TC003 extends BaseClass {
	
	@Test
	public void addCustomer() throws Exception {
		driver.get(url);
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(Password);
		lp.clickSubmit();
		Thread.sleep(3000);
		
		AddCustomersPage acp = new AddCustomersPage(driver);
		acp.ClickCustomerOut();
		acp.ClickCustomerIn();
		acp.ClickAddButton();
		String email= getRandomString()+"@gmail.com";
		acp.setEmail(email);
		acp.setPassword("password123");
		acp.setFirstName("Surya");
		acp.setLastName("Ram");
		acp.setGender("Male");
		acp.setDateOfBirth("01/01/1985");
		acp.setCompanyName("HCL");
		acp.clickIsTax();
		acp.setNewsLetter("Your store name");
		acp.setVendorRole("Vendors");
		acp.setVendorManger("Vendor 1");
		acp.clickActive();
		acp.setAdminComments("This is Admin Comments");
		Thread.sleep(5000);
		acp.ClickSave();
		
		if(acp.getSucceMesssage().contains("added successfully")){
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
			
		}
		
	}
	
	
	
	

}

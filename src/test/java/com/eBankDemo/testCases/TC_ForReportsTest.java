package com.eBankDemo.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TC_ForReportsTest extends BaseClass{
	 	
		@Test(priority = 2)
	    public void googleLogoTitleTest(){

	        driver.get("https://www.google.com/");
	        Reporter.log("Url Opened");
	        logger.info("Url Opened");
	        WebElement LogoTitle=driver.findElement(By.id("hplogo"));
	        Reporter.log("Find the Google Logo");
	        logger.info("Find the Google Logo");
	        Assert.assertTrue(LogoTitle.isDisplayed());
	        Reporter.log("Verified the Logo is Displayed or Not");
	        logger.info("Verified the Logo is Displayed or Not");

	    }
	    @Test(priority = 1)
	    public void orangeHRMTest(){
	        driver.get("https://opensource-demo.orangehrmlive.com/");
	        Reporter.log("Url Opened");
	        logger.info("Url Opened");
	        Assert.assertEquals(driver.getTitle(),"OrangeHRM");
	        Reporter.log("Verified the Title of Web Page");
	        logger.info("Verified the Logo is Displayed or Not");
	    }
	    @Test(priority =3)
	    public void googleEditTest() throws Exception {
	        driver.get("https://www.google.com/");
	        Reporter.log("Url Opened");
	        logger.info("Url Opened");
	        WebElement LogoTitle=driver.findElement(By.id("hplogo"));
	        Reporter.log("Find the Google Logo");
	        logger.info("Find the Google Logo");
	        Assert.assertTrue(LogoTitle.isDisplayed());
	        Reporter.log("Verified the Logo is Displayed or Not");
	        logger.info("Verified the Logo is Displayed or Not");
	        driver.findElement(By.name("q")).sendKeys("surya");
	        Reporter.log("Enter the Search String as Surya");
	        logger.info("Enter the Search String as Surya");
	        Thread.sleep(3000);
	        Assert.fail();
	        Reporter.log("Fail The Test");
	        logger.info("Fail The Test");
	    }
	    @Test(priority = 4)
	    public void skippedTest(){
	        driver.get("https://opensource-demo.orangehrmlive.com/");
	        Reporter.log("Url Opened");
	        logger.info("Url Opened");
	       throw new SkipException("This is Skipped Test");
	    }

}

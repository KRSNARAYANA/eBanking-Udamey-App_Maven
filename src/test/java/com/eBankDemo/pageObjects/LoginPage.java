package com.eBankDemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	WebDriver lDriver;
	
	public LoginPage(WebDriver rDriver){
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);		
	}
	
	
	@FindBy(how=How.XPATH, using = "//input[@id='Email']") @CacheLookup
	WebElement txtUserNamElement;
	
	@FindBy(how=How.XPATH, using = "//input[@id='Password']") @CacheLookup
	WebElement txtPasswordElement;
	
	@FindBy(how=How.XPATH, using = "//input[@class='button-1 login-button']") @CacheLookup
	WebElement btnSubmitElement;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Logout')]") @CacheLookup
	WebElement btnLogOutElement;
	
	
	public void setUserName(String uName) {
		txtUserNamElement.clear();
		txtUserNamElement.sendKeys(uName);		
	}
	
	public void setPassword(String pwd) {
		txtPasswordElement.clear();
		txtPasswordElement.sendKeys(pwd);
		
	}
	public void clickSubmit() {
		btnSubmitElement.click();
	}

	public void clickLogOut() {
		btnLogOutElement.click();
	}
	
	

}

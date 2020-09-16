package com.eBankDemo.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomersPage {
	
	WebDriver ldriver;
	
	public AddCustomersPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);		
	}
	
	@FindBy(xpath = "/html/body/div[3]/div[2]/div/ul/li[4]") @CacheLookup
	WebElement lnkCustomers_Out;
	
	@FindBy(xpath = "/html/body/div[3]/div[2]/div/ul/li[4]/ul/li[1]") @CacheLookup
	WebElement lnkCustomers_In;
	
	@FindBy(xpath = "//a[@class='btn bg-blue']") @CacheLookup
	WebElement btnAddNew;
	
	@FindBy(xpath = "//input[@id='Email']") @CacheLookup
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='Password']") @CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@id='FirstName']") @CacheLookup
	WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@id='LastName']") @CacheLookup
	WebElement txtLastName;
	
	@FindBy(xpath = "//input[@id='Gender_Male']") @CacheLookup
	WebElement rdMale;
	
	@FindBy(xpath = "//input[@id='Gender_Female']") @CacheLookup
	WebElement rdFemale;
	
	@FindBy(xpath = "//input[@id='DateOfBirth']") @CacheLookup
	WebElement txtDateOfBirth;
	
	@FindBy(xpath = "//input[@id='Company']") @CacheLookup
	WebElement txtCompanyName;
	
	@FindBy(xpath = "//textarea[@id='AdminComment']") @CacheLookup
	WebElement txtAdminComment;
	
	@FindBy(xpath = "//input[@id='IsTaxExempt']") @CacheLookup
	WebElement chkIsTaxExempt;
	
	@FindBy(xpath = "//input[@id='Active']") @CacheLookup
	WebElement chkActive;
	
	@FindBy(xpath = "//*[@id=\"customer-info\"]/div[2]/div[1]/div[9]/div[2]/div/div[1]/div") @CacheLookup
	WebElement drpNewsLetter;
	@FindBy(xpath = "//*[@id='SelectedNewsletterSubscriptionStoreIds_listbox']/li[1]") @CacheLookup
	WebElement optYourStoreName;
	@FindBy(xpath = "//*[@id='SelectedNewsletterSubscriptionStoreIds_listbox']/li[2]") @CacheLookup
	WebElement optTestStore2;
	
	@FindBy(xpath = "//li[1]/span/span[@class='k-icon k-i-close']") @CacheLookup
	WebElement beforeSelectedRole;
	
	@FindBy(xpath = "//*[@id='customer-info']/div[2]/div[1]/div[10]/div[2]/div/div[1]/div") @CacheLookup
	WebElement lstCustomerRoles;
	@FindBy(xpath = "//li[contains(text(),'Administrators')]") @CacheLookup
	WebElement lstAdministrators;
	@FindBy(xpath = "//li[contains(text(),'Forum Moderators')]") @CacheLookup
	WebElement lstForumModerators;
	@FindBy(xpath = "//li[contains(text(),'Guests')]") @CacheLookup
	WebElement lstGuests;
	@FindBy(xpath = "//li[contains(text(),'Registered')]") @CacheLookup
	WebElement lstRegistered;
	@FindBy(xpath = "//li[contains(text(),'Vendors')]") @CacheLookup
	WebElement lstVendors;
	@FindBy(xpath = "//*[@id='SelectedCustomerRoleIds_taglist']") @CacheLookup
	WebElement selectedVendorsfromList;
	
	
	@FindBy(xpath = "//select[@id='VendorId']") @CacheLookup
	WebElement drpMangerOfVendor;
	
	@FindBy(xpath = "//button[@name='save']") @CacheLookup
	WebElement btnSave;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']") @CacheLookup
	WebElement textSuccessMessage;
	
	
	// Action Methods..............
	
	
	public void ClickCustomerOut() {
		lnkCustomers_Out.click();	
	}
	
	public void ClickCustomerIn() {
		lnkCustomers_In.click();	
	}
	
	public void ClickAddButton() {
		btnAddNew.click();	
	}
	
	public void setEmail(String email) {

		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String pwd) {

		txtPassword.sendKeys(pwd);
	}
	
	public void setFirstName(String fName) {

		txtFirstName.sendKeys(fName);
	}
	
	public void setLastName(String lName) {

		txtLastName.sendKeys(lName);
	}


	public void setGender(String gender) {
		
		if(gender.equals("Male")) {
			rdMale.click();
		}
		else if(gender.equals("Female")) {
			rdFemale.click();
			
		}
		else {
			rdMale.click();
		}
	}
	
	public void setDateOfBirth(String dob) {

		txtDateOfBirth.sendKeys(dob);
	}
	
	public void setCompanyName(String company) {

		txtCompanyName.sendKeys(company);
	}
	
	public void setAdminComments(String comments) {

		txtAdminComment.sendKeys(comments);
	}
	
	public void clickActive() {
		chkActive.click();	
	}
	
	public void clickIsTax() {
		chkIsTaxExempt.click();	
	}
	
	public void setVendorManger(String option) {
		
		if(selectedVendorsfromList.getText().contains("Vendors")) {
			Select dd = new Select(drpMangerOfVendor);
			dd.selectByVisibleText(option);
		}
		else {
			Select dd = new Select(drpMangerOfVendor);
			dd.selectByVisibleText("Not a vendor");
		}
	}
	
	public void ClickSave() {
		btnSave.click();	
	}
	
	public String getSucceMesssage() {
		return textSuccessMessage.getText();	
	}
	
	
	public void setNewsLetter(String opt) {
		
		drpNewsLetter.click();
		WebElement listElement;
		switch (opt) {
		case "Your store name":
			listElement=optYourStoreName;break;
		default:
			listElement=optTestStore2;break;
		}
		
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click();", listElement);
	}
	
	public void deSelectedRole() {
		beforeSelectedRole.click();
		
	}
	
	
	public void setVendorRole(String role) {
		
		lstCustomerRoles.click();
		WebElement listOption;
		
		switch (role) {
		case "Administrators": listOption=lstAdministrators;break;
		case "Forum Moderators": listOption=lstForumModerators;break;
		case "Guests": listOption=lstGuests;break;
		case "Registered": listOption=lstRegistered;break;
		default: listOption=lstVendors; break;
		}
		JavascriptExecutor js= (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click();", listOption);
	}
	
}

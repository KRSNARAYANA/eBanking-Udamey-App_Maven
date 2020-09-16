package com.eBankDemo.testCases;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.eBankDemo.Utilities.ReadConfig;

public class BaseClass {
	
	public static WebDriver driver; 
	public static Logger logger;
	
	ReadConfig readConfig = new ReadConfig();

	public String url = readConfig.getAppURL();
	public String userName = readConfig.getUserName();
	public String Password= readConfig.getPassword();	
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String br) {
		
		logger=Logger.getLogger("eBnkingDemo");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver=new ChromeDriver();	
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
			driver=new FirefoxDriver();
		}
		else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readConfig.getIEPath());
			driver=new InternetExplorerDriver();			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	public static String captureScreen(WebDriver driver, String methodName) {
		
		Date date = new Date();
		String fileEndName = date.toString().replace(":", "_").replace(" ", "_")+".png";
		String fileDestPath = System.getProperty("user.dir")+"\\Screenshots\\"+methodName+fileEndName;
		File destination= new File(fileDestPath);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourece= ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(sourece, destination);	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return fileDestPath;
	}
	
	public static String getRandomString() {
		return RandomStringUtils.randomAlphabetic(5);	
	}
	
	public static String getRandomNumber() {
		return RandomStringUtils.randomNumeric(6);	
	}
}

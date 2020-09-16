package com.eBankDemo.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		
		File file = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(file);
			pro= new Properties();
			pro.load(fis);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public String getAppURL() {
		
		return pro.getProperty("baseurl");
	}
	
	public String getUserName() {
		
		return pro.getProperty("username");
	}
	
	public String getPassword() {
		
		return pro.getProperty("password");
	}
	
	public String getChromePath() {
		
		return pro.getProperty("chromePath");
	}
	
	public String getFirefoxPath() {
		
		return pro.getProperty("firefoxPath");
	}
	
	public String getIEPath() {
		
		return pro.getProperty("iePath");
	}
	

}

package eBankDemo.app;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Common {

	static WebDriver driver;

	@Parameters("browser")
	@BeforeMethod
	public static void setUp(String browser) throws Exception {

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/chromedriver.exe");
			driver = new ChromeDriver();
			ChromeOptions options = new ChromeOptions(); driver=new RemoteWebDriver(new
			 URL("http://localhost:4444/wd/hub"),options);
			 
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver.exe");
			driver = new FirefoxDriver();

			 FirefoxOptions options= new FirefoxOptions(); driver = new
			 RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),options);
			 
		} else if (browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "./BrowserDrivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	@AfterMethod
	public static void tearDown() {
		driver.quit();

	}

}

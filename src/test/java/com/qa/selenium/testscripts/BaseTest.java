package com.qa.selenium.testscripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	ReadConfig readconfig = new ReadConfig();
	
	public String baseURl= readconfig.getApplicationURL();
	public static WebDriver Driver;
	public String Category = readconfig.getCategory();
	public String SearchItem = readconfig.getSearchItem();
	public static Logger logger;
	
	
	@Parameters({"browser"})
	@BeforeClass
	public void setUp(String browser) {
		
		logger = Logger.getLogger("Amazon");
		PropertyConfigurator.configure("log4j.properties");
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			Driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			Driver = new FirefoxDriver();
		} else if(browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			Driver = new InternetExplorerDriver();
		}
		
		Driver.get(baseURl);			
	}
	
	@AfterClass
	public void tearDown() {
		Driver.quit();
	}
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
}

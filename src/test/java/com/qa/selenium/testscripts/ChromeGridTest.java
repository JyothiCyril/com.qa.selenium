package com.qa.selenium.testscripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeGridTest {

	public static void main(String[] args) throws MalformedURLException {


		new DesiredCapabilities();
		DesiredCapabilities Cap = DesiredCapabilities.chrome();
		
		Cap.setBrowserName("chrome");
		Cap.setPlatform(Platform.WINDOWS);
		
		
		
		  ChromeOptions Options = new ChromeOptions(); 
		  Options.merge(Cap);
		 
		
		
		
		String HubUrl = "http://192.168.29.62:4444/wd/hub";
		
		WebDriver Driver = new RemoteWebDriver(new URL(HubUrl),Options);
		
		Driver.get("https://www.rediff.com/");
		System.out.println(Driver.getTitle());
		Driver.quit();
	}

}
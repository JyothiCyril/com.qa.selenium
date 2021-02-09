package com.qa.selenium.testscripts;

import static org.testng.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class solutions {
	
	WebDriver webDriver;
	
	//This is already created in webdriver base class under codility
	/// *********** Donot copy this method into codility ***********///////
	
	@Before 
	public void setup() {
		WebDriverManager.chromedriver().setup();
		webDriver = new ChromeDriver();
		webDriver.get("");
	}
	
	
	@Test
	public void a() throws InterruptedException {
		
		
		Thread.sleep(20000);
		assertEquals( "<condition>", true);
		
	}
	
	
	@Test
	public void b() throws InterruptedException {
		
		Thread.sleep(20000);
		
		assertEquals( "<condition>", true);
		
	}
	
	@Test
	public void c() throws InterruptedException {
		
		Thread.sleep(20000);
		
		assertEquals( "<condition>", true);
		
	}

	
	@Test
	public void d() throws InterruptedException {
		
		
		Thread.sleep(20000);
		assertEquals( "<condition>", true);
		
	}
	
	@Test
	public void e() throws InterruptedException {
		
		Thread.sleep(20000);
		assertEquals( "<condition>", true);
		
	}

}

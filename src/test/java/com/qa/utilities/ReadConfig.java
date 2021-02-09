package com.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	public ReadConfig() {
		
			File Src = new File("D:\\SeleniumTraining\\com.qa.selenium\\Configuration\\config.properties");
		try {
			FileInputStream Fileloc = new FileInputStream(Src);
			prop = new Properties();
			prop.load(Fileloc);
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception is " + e.getMessage());
		}
			
			
		
	}
	
	public String getApplicationURL()
	{
		String url=prop.getProperty("baseURL");
		return url;
	}
	
	public String getCategory() {
		String Category=prop.getProperty("Category");
		return Category;
	}
	
	public String getSearchItem() {
		String SearchItem=prop.getProperty("SearchItem");
		return SearchItem;
	}

}

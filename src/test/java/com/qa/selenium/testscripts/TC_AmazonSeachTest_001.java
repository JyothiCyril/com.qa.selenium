package com.qa.selenium.testscripts;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.qa.selenium.pages.AmazonPages;
import com.qa.utilities.ExcelUtils;

public class TC_AmazonSeachTest_001 extends BaseTest{	
	
	
	@Test(dataProvider="DataSource")
	public void searchItem(String Category, String SearchItem) throws IOException 
	{
			
		AmazonPages AmazonOR = new AmazonPages(Driver);
		logger.info("URL opened");
		
		AmazonOR.SetCategoryList(Category);
		logger.info("selected category");
		AmazonOR.setSearchInput(SearchItem);
		logger.info("entered the item to be searched");
		 
		AmazonOR.setMagnifierBtn();
		logger.info("clicked the button to submit the input");
		
		if(Driver.getTitle().contains(SearchItem)) 
		{
			Assert.assertTrue(true);
			logger.info("Correct title loaded");
			
		}else {
			captureScreen(Driver,"searchItem");
			Assert.assertTrue(false);
			logger.warn("Incorrect title loaded");
		}
		
		
	}
	
	
	@DataProvider(name="DataSource")
	public String [][] getData() throws IOException
	{
		//String path=System.getProperty("user.dir")+"src/test/java/com/qa/selenium/testdata/InputData.xlsx";
		
		String path = "D:\\SeleniumTraining\\com.qa.selenium\\src\\test\\java\\com\\qa\\selenium\\testdata\\InputData.xlsx";
		
		int rownum=ExcelUtils.getRowCount(path, "Sheet2");
		int colcount=ExcelUtils.getCellCount(path,"Sheet2",1);
		
		String data[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				data[i-1][j]=ExcelUtils.getCellData(path,"Sheet2", i,j);//1 0
			}
				
		}
	return data;
	}
	
	

}

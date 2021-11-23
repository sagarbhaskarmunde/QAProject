package com.crm.qa.testcases;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;

import com.crm.qa.pages.GoogleSearchPage;


public class FlipkartApp extends TestBase{

	//TestUtil testUtil;
	GoogleSearchPage googleSearchPage;
	
	
	
	public FlipkartApp(){
		super();		
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		//testUtil = new TestUtil();
		googleSearchPage = new GoogleSearchPage();
	}
	
	@Test
	public void verifyFlipkartSearch() {		
		googleSearchPage.GetSearchList();	
		googleSearchPage.Product();
	}
	
	
	 @AfterMethod public void tearDown(){ 
		driver.quit(); 
	 }
	 
}

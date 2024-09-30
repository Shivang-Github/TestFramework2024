package com.qa.opencart.tests;

import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;

public class UITests extends BaseTest{
	
	
	@Test
	public void loginTest() {
		
		System.out.println("its dummy page");
		
		loginPage.getPageLogo();
		loginPage.getPageTitle();
		
	}
	
	
	

}

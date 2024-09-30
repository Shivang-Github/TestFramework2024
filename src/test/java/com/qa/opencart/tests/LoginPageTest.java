package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;

public class LoginPageTest extends BaseTest{
	
	
	
	@Test
	public void loginPageURLTest() {
		
		String actTitle=loginPage.getPageTitle();
		Assert.assertEquals(actTitle, "Account Login");
		
	}
	
	@Test
	public void pageLogoTest() {
		
		loginPage.getPageLogo();
	}
	

}

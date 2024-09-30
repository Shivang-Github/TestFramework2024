package com.qa.opencart.basetest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;

public class BaseTest extends DriverFactory{
	
	WebDriver driver ;
	DriverFactory df;
	protected Properties prop;
	
	protected LoginPage loginPage;
	
	
	
	//@Parameters({"browser"})
	@BeforeTest
	public void Setup() {
		
		prop=new Properties();
		df=new DriverFactory();
		
		//if(browserName !=null) {
			
			prop.setProperty("browser","browserName");
			
		
		
		prop=df.intiProp();
		
		driver=df.initDriver(prop);
		loginPage= new LoginPage(driver);
		
		
		
	}
	
	@AfterTest
	public void TearDown() {
		
		driver.quit();
	}
	
	

}

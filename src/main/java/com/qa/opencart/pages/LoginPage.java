package com.qa.opencart.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	//private ElementUtil eleUtil;
	Properties prop;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		//eleUtil= new ElementUtil(driver);
	}
	
	// Page WebElement locators
	
	private By username=By.id("input-email");
	private By password=By.id("input-password");
	private By signIn=By.xpath("//input[@type='submit']");
	
	By pagelogo=By.xpath("//img[@title='naveenopencart']");
	
	
	//Actions methods for these locators
	
	public String getPageTitle() {
		
		String actTitle=driver.getTitle();
		return actTitle;
	}
	
	public WebElement getPageLogo() {
		
		WebElement plogo=driver.findElement(pagelogo);
		return plogo;
		
	}
	
	public void doLogin() {
		
		driver.findElement(username).sendKeys(prop.getProperty("username"));
		
		driver.findElement(password).sendKeys(prop.getProperty("password"));
		
		driver.findElement(signIn).click();
	}
	

}

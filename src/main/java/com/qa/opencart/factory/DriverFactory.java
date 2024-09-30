package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;


import com.qa.opencart.exceptions.BrowserExceptions;

public class DriverFactory {

	WebDriver driver;
	Properties prop;


	public WebDriver initDriver(Properties prop) {
		
		String browserName=prop.getProperty("browser");
		
		
        
		switch (browserName.toLowerCase()) {

		case "chrome":

			driver = new ChromeDriver();
			break;

		case "edge":

			driver = new EdgeDriver();
			break;

		case "safari":

			driver = new SafariDriver();
			break;

		default:

			throw new BrowserExceptions("----invalid browser----");

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
		return driver;

	}

	
	/*This method is used to intiaize property file method from the config file
	 * 
	 * 
	 * 
	 * 
	 */
     public Properties intiProp() {
    	 
    	 prop=new Properties();
    	 try {
			FileInputStream fis=new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 return prop;
     }
	

}

package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementUtil {

	WebDriver driver;

	public ElementUtil(WebDriver driver) {

		this.driver = driver;

	}

	public void doClick(By locator) {

		getElement(locator).click();

	}

	public void doSendkeys(By locator, String value) {

		getElement(locator).sendKeys(value);
	}

	public String getText(By locator) {

		return getElement(locator).getText();

	}

	public WebElement getElement(By locator) {

		return driver.findElement(locator);

	}

	/*
	 * 1.below utility methods will be useful for multiple FindElements on web page
	 * 
	 */

	public List<WebElement> getElements(By locator) {

		return driver.findElements(locator);

	}

	public int getElementsCount(By locator) {

		return getElements(locator).size();

	}

	public List<String> getElementTextList(By locator) {

		List<WebElement> totalElements = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for (WebElement e : totalElements) {

			String elementsText = e.getText();
			if (elementsText.length() != 0) {

				eleTextList.add(elementsText);

			}

		}
		return eleTextList;
	}

	public void printElementsTextList(By locator) {

		List<String> elements = getElementTextList(locator);
		for (String e : elements) {

			System.out.println(e);

		}

	}

	public void getAttribute(By locator, String AttributeValue) {

		List<WebElement> obj = getElements(locator);
		for (WebElement e : obj) {

			String allAttribute = e.getAttribute(AttributeValue);
			System.out.println(allAttribute);

		}

	}

	/*
	 * FindElements is displayed or not
	 */

	/*
	 * 1.below utility for dropdown using select class
	 * 
	 */
	public void selectDropDownbyText(By locator, String text) {

		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);

	}

	public void selectDropDownbyValue(By locator, String value) {

		Select select = new Select(getElement(locator));
		select.selectByValue(value);

	}

	public void selectDropDownbyIndex(By locator, int index) {

		Select select = new Select(getElement(locator));
		select.selectByIndex(index);

	}

	public int getDropDownOptionList(By locator) {

		Select select = new Select(getElement(locator));
		return select.getOptions().size();
	}

	// *************************Actions Class Util*************8888

	/**
	 * This method is handling two level of parent child menu on the basis of By
	 * locator
	 * 
	 * @param parentMenu
	 * @param childMenu
	 */

	public void ParentChildMenu(By parentMenu, By ChildMenu) throws InterruptedException {

		Actions act = new Actions(driver);

		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(3000);

		doClick(ChildMenu);

		// getElement(ChildMenu).click();

	}

	public void ParentChildMenu(String parentMenu, String ChildMenu) throws InterruptedException {

		Actions act = new Actions(driver);

		act.moveToElement(getElement(By.xpath("//*[text()='" + parentMenu + "']"))).perform();
		Thread.sleep(3000);

		doClick(By.xpath("//*[text()='" + ChildMenu + "']"));

		// getElement(By.xpath("//*[text()='" + ChildMenu + "']")).click();

	}

	public void doSendKeysWithPause(By locator, String s, long pausetime) {
		Actions act = new Actions(driver);
		char ch[] = s.toCharArray();

		for (char c : ch) {

			act.sendKeys(getElement(locator), String.valueOf(c)).pause(pausetime).build().perform();
		}

	}
}

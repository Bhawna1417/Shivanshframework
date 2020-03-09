package com.webdriver.MyAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUs {
	WebDriver driver = null;

	public ContactUs(WebDriver driver) {
		this.driver = driver;
	}
	
	public ContactUs OpenContactUs(WebElement ele, By by) {
		WebElement element = ele.findElement(by);
		if (element != null) {
			element.click();
		}
		return this;
	}
}

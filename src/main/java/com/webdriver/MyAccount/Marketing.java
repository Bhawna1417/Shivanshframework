package com.webdriver.MyAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Marketing {
	WebDriver driver = null;

	public Marketing(WebDriver driver) {
		this.driver = driver;
	}
	
	public Marketing OpenMarketingPreferences(WebElement ele, By by) {
		WebElement element = ele.findElement(by);
		if (element != null) {
			element.click();
		}
		return this;
	}
}

package com.webdriver.MyAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChangePassword {
	WebDriver driver = null;

	public ChangePassword(WebDriver driver) {
		this.driver = driver;
	}

	public ChangePassword OpenChangePassword(WebElement ele, By by) {
		WebElement element = ele.findElement(by);
		if (element != null) {
			element.click();
		}
		return this;
	}
}
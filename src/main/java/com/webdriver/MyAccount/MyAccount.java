package com.webdriver.MyAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccount {
	WebDriver driver = null;

	public MyAccount(WebDriver driver) {
		this.driver = driver;
	}

	public MyAccount UpdateAccountDetails(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {

		}
		return this;
	}

	public MyAccount UpdateContactDetails(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {

		}
		return this;
	}

	public MyAccount ClickElement(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			element.click();
		}
		return this;
	}
}
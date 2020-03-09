package com.webdriver.MyAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeliveryAddressBook {
	WebDriver driver = null;

	public DeliveryAddressBook(WebDriver driver) {
		this.driver = driver;
	}

	public DeliveryAddressBook OpenAddressBook(WebElement ele, By by) {
		if (!ele.getAttribute("class").toLowerCase().trim().contains("active")) {

			WebElement element = ele.findElement(by);
			if (element != null) {
				element.click();
			}
		}
		return this;
	}
}

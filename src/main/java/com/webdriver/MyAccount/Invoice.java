package com.webdriver.MyAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Invoice {
	WebDriver driver = null;

	public Invoice(WebDriver driver) {
		this.driver = driver;
	}
	
	public Invoice OpenInvoice(WebElement ele, By by) {
		WebElement element = ele.findElement(by);
		if (element != null) {
			element.click();
		}
		return this;
	}
}

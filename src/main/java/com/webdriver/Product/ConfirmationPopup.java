package com.webdriver.Product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmationPopup {
	WebDriver driver = null;

	public ConfirmationPopup(WebDriver driver) {
		this.driver = driver;
	}

	public ConfirmationPopup ClickProceedToCart(By locator1, By locator2) {
		WebElement element = driver.findElement(locator1);
		if (element != null) {
			element.findElement(locator2).click();
		}

		return this;
	}

	public ConfirmationPopup ClickContinueShopping(By locator1, By locator2) {
		WebElement element = driver.findElement(locator1);
		if (element != null) {
			element.findElement(locator2).click();
		}

		return this;
	}

	public ConfirmationPopup ClickClosePopup(By locator) {
		WebElement element = driver.findElement(locator);
		if (element != null) {
			element.click();
		}

		return this;
	}
	
	public ConfirmationPopup ClickCancelOrder(By by1, By by2, By by3) {
		WebElement element = driver.findElement(by1);
		if (element != null) {
			element.findElement(by2).findElement(by3).click();
		}

		return this;
	}
}

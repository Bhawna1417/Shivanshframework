package com.webdriver.MyAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginDetails {
	WebDriver driver = null;
	WebElement passwordelement = null;

	public LoginDetails(WebDriver driver) {
		this.driver = driver;
	}

	public LoginDetails OpenAccountDetails(WebElement ele, By by) {
		// System.out.println(ele.getAttribute("class"));
		if (!ele.getAttribute("class").toLowerCase().trim().contains("active")) {

			WebElement element = ele.findElement(by);
			if (element != null) {
				element.click();
			}
		}
		return this;
	}

	public LoginDetails AccountDetails(By by1, By by2) {
		WebElement element = driver.findElement(by1);
		if (element != null) {
			element.click();
			this.passwordelement = element.findElement(by2);
		}
		return this;
	}

	public LoginDetails ClickChangePassword(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			element.click();
		}
		return this;
	}

	public LoginDetails ClickUpdatePassword(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			element.click();
		}
		return this;
	}

	public LoginDetails EnterNewPassword(By by, String string) {
		WebElement element = passwordelement.findElement(by);
		if (element != null) {
			element.clear();
			element.sendKeys(string);
		}
		return this;
	}

	public LoginDetails EnterNewConfirmPassword(By by, String string) {
		WebElement element = passwordelement.findElement(by);
		if (element != null) {
			element.clear();
			element.sendKeys(string);
		}
		return this;
	}

	public LoginDetails RetrieveEmail(By by) {
		WebElement element = passwordelement.findElement(by);
		if (element != null) {
			System.out.println("Member Email is "
					+ element.getAttribute("value"));
		}
		return this;
	}
}
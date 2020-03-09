package com.webdriver.MyAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MemberShipDetails {
	WebDriver driver = null;

	public MemberShipDetails(WebDriver driver) {
		this.driver = driver;
	}

	public MemberShipDetails OpenMemberShipDetails(WebElement ele, By by) {
		// System.out.println(ele.getAttribute("class"));
		if (!ele.getAttribute("class").toLowerCase().trim().contains("active")) {

			WebElement element = ele.findElement(by);
			if (element != null) {
				element.click();
			}
		}
		return this;
	}

}

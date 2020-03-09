package com.webdriver.MyAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.Library.WebDriverHelpers;

public class ContactDetails {
	WebDriver driver = null;
	WebElement profileelement = null;

	public ContactDetails(WebDriver driver) {
		this.driver = driver;
	}

	public ContactDetails OpenProfile(WebElement ele, By by) {
		// System.out.println(ele.getAttribute("class"));
		if (!ele.getAttribute("class").toLowerCase().trim().contains("active")) {

			WebElement element = ele.findElement(by);
			if (element != null) {
				element.click();
			}
		}
		return this;
	}

	public ContactDetails RetrieveFirstName(By by) {
		WebElement element = profileelement.findElement(by);
		if (element != null) {
			System.out
					.println("First Name is " + element.getAttribute("value"));
		}
		return this;
	}

	public ContactDetails RetrieveLastName(By by) {
		WebElement element = profileelement.findElement(by);
		if (element != null) {
			System.out.println("Last Name is " + element.getAttribute("value"));
		}
		return this;
	}

	public ContactDetails RetrieveTitle(By by) throws Exception {
		WebElement element = profileelement.findElement(by);
		if (element != null) {

			System.out.println("Selected Title is "
					+ WebDriverHelpers.GetSelectedTextDropdown(element, by));
		}
		return this;
	}

	public ContactDetails RetrieveContact(By by) {
		WebElement element = profileelement.findElement(by);
		if (element != null) {
			System.out.println("Member Contact is "
					+ element.getAttribute("value"));
		}
		return this;
	}

	public ContactDetails RetrieveGender(By by) throws Exception {
		WebElement element = profileelement.findElement(by);
		if (element != null) {

			System.out.println("Selected Gender is "
					+ WebDriverHelpers.GetSelectedTextDropdown(element, by));
		}
		return this;
	}

	public ContactDetails EnterNewContact(By by, String string) {
		WebElement element = profileelement.findElement(by);
		if (element != null) {
			element.clear();
			element.sendKeys(string);
		}
		return this;
	}

	public ContactDetails EnterNewFirstName(By by, String string) {
		WebElement element = profileelement.findElement(by);
		if (element != null) {
			element.clear();
			element.sendKeys(string);
		}
		return this;
	}

	public ContactDetails EnterNewLastName(By by, String string) {
		WebElement element = profileelement.findElement(by);
		if (element != null) {
			element.clear();
			element.sendKeys(string);
		}
		return this;
	}

	public ContactDetails SelectNewGender(By by) throws Exception {
		WebElement element = profileelement;
		if (element != null) {
			WebDriverHelpers.SelectFromDropDown(element, by);
		}
		return this;
	}

	public ContactDetails SelectNewTitle(By by) throws Exception {
		WebElement element = profileelement;
		if (element != null) {
			WebDriverHelpers.SelectFromDropDown(element, by);
		}
		return this;
	}

	public ContactDetails ClickUpdateDetails(By by) {
		WebElement element = profileelement.findElement(by);
		if (element != null) {
			element.click();
		}
		return this;
	}

	public ContactDetails ProfileDetails(By by, By by2, By by3) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			element.click();
			this.profileelement = element.findElement(by2);
		}
		return this;
	}

}
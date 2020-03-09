package com.webdriver.MyAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.Library.WebDriverHelpers;
import com.webdriver.UtilSection.GetRandom;
import com.webdriver.UtilSection.Timestamp;

public class AddNewAddress {
	WebDriver driver = null;
	WebElement form = null;

	public AddNewAddress(WebDriver driver, WebElement ele) {
		this.driver = driver;
		this.form = ele;
	}

	public AddNewAddress DeliveryAddressAlias(By by) throws Exception {
		WebElement element = form.findElement(by);
		if (element != null) {
			if (element.isEnabled()) {
				WebDriverHelpers.SelectFromDropDown(driver, by);
			}
		}
		return this;
	}

	public AddNewAddress DeliveryAddressName(By by) throws Exception {
		WebElement element = form.findElement(by);
		if (element != null) {
			if (element.isEnabled()) {
				element.sendKeys("test" + Timestamp.current_timestamp());
			}
		}
		return this;
	}

	public AddNewAddress DeliveryAddressGender(By by1, By by2) throws Exception {
		WebElement element1 = form.findElement(by1);
		WebElement element2 = form.findElement(by2);

		if (element1 != null && element2 != null) {

			if ((GetRandom.value(2, 0) % 2) == 0) {
				element1.click();
			} else {
				element2.click();
			}
		}
		return this;
	}

	public AddNewAddress DeliveryAddressTitle(By by) throws Exception {
		WebElement element = form.findElement(by);
		if (element != null) {
			if (element.isEnabled()) {
				WebDriverHelpers.SelectFromDropDown(driver, by);
			}
		}
		return this;
	}

	public AddNewAddress DeliveryAddressFirstName(By by) {
		WebElement element = form.findElement(by);
		if (element != null) {
			element.sendKeys("test");
		}
		return this;
	}

	public AddNewAddress DeliveryAddressLastName(By by) {
		WebElement element = form.findElement(by);
		if (element != null) {
			element.sendKeys("test");
		}
		return this;
	}

	public AddNewAddress DeliveryAddressCompanyName(By by) {
		WebElement element = form.findElement(by);
		if (element != null) {
			element.sendKeys("test");
		}
		return this;
	}

	public AddNewAddress DeliveryAddressHouseNo(By by) {
		WebElement element = form.findElement(by);
		if (element != null) {
			element.sendKeys("test");
		}
		return this;
	}

	public AddNewAddress DeliveryAddressCountry(By by) throws Exception {
		WebElement element = form.findElement(by);
		if (element != null) {
			if (element.isEnabled()) {
				WebDriverHelpers.SelectFromDropDown(driver, by);
			}
		}
		return this;
	}

	public AddNewAddress DeliveryAddressStreet(By by) {
		WebElement element = form.findElement(by);
		if (element != null) {
			element.sendKeys("test");
		}
		return this;
	}

	public AddNewAddress DeliveryAddressTown(By by) {
		WebElement element = form.findElement(by);
		if (element != null) {
			element.sendKeys("test");
		}
		return this;
	}

	public AddNewAddress DeliveryAddressCounty(By by) throws Exception {
		WebElement element = form.findElement(by);
		if (element != null) {
			if (element.isEnabled()) {
				WebDriverHelpers.SelectFromDropDown(driver, by);
			}
		}
		return this;
	}

	public AddNewAddress DeliveryAddressMobile(By by) {
		WebElement element = form.findElement(by);
		if (element != null) {
			element.sendKeys("95326598236");
		}
		return this;
	}

	public AddNewAddress DeliveryAddressOtherContact(By by) {
		WebElement element = form.findElement(by);

		if (element != null) {
			element.sendKeys("1234567890");
		}
		return this;
	}

	public AddNewAddress DeliveryAddressCity(By by) throws Exception {
		WebElement element = form.findElement(by);

		if (element != null) {
			WebDriverHelpers.SelectFromDropDown(driver, by);
		}
		return this;
	}

	public AddNewAddress DeliveryAddressPostCode(By by) throws Exception {
		WebElement element = form.findElement(by);
//		System.out.println("Select PostCode");
		if (element != null) {
			element.sendKeys("CH1 4HP");
		}
		return this;
	}

	public AddNewAddress DeliveryAddressAddress1(By by) {
		WebElement element = form.findElement(by);
		System.out.println("Fill address Line1");
		if (element != null) {
			element.sendKeys("test");
		}
		return this;
	}

	public AddNewAddress DeliveryAddressAddress2(By by) {
		WebElement element = form.findElement(by);
		System.out.println("Fill address Line2");
		if (element != null) {
			element.sendKeys("test");
		}
		return this;
	}

	public AddNewAddress DeliveryAddressSaveAddress(By by) {
		WebElement element = form.findElement(by);
		if (element != null) {
			element.click();
		}
		return this;
	}

	public AddNewAddress DeliveryAddressCheckout(By by) {
		WebElement element = form.findElement(by);
		if (element != null) {
			if (element.isEnabled()) {
				element.click();
			} else {
				throw new RuntimeException("Button disabled");
			}
		}
		return this;
	}

	public AddNewAddress DeliveryAddressManualEntry(By by, By by1) {
		WebElement element = form.findElement(by);
		if (element != null) {
			if (element.isEnabled()) {
				WebElement ele = element.findElement(by1);
				if (ele != null) {
					ele.click();
				}
			} else {
				throw new RuntimeException("Button disabled");
			}
		}
		return this;
	}
}
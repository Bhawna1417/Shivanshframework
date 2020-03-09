package com.webdriver.Payment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.webdriver.Library.WebDriverHelpers;

public class PaymentDetails {
	WebDriver driver = null;

	Payment payment = new Payment();

	public PaymentDetails(WebDriver driver) {
		this.driver = driver;
	}

	public PaymentDetails SelectPaymentType(By by, String value) {
		Select element = new Select(driver.findElement(by));

		if (element != null) {
			element.selectByValue(value);
		}

		return this;
	}

	public PaymentDetails FillPaymentCard(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			element.sendKeys("4111111111111111");
		}
		return this;
	}

	public PaymentDetails FillCardHolderName(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			element.sendKeys("test");
		}
		return this;
	}

	public PaymentDetails SelectCardExpiryMonth(By by) throws Exception {
		WebElement element = driver.findElement(by);
		if (element != null) {
			if (element.isEnabled()) {
				WebDriverHelpers.SelectFromDropDown(driver, by);
			}
		}
		return this;
	}

	public PaymentDetails SelectCardExpiryYear(By by) throws Exception {
		WebElement element = driver.findElement(by);
		if (element != null) {
			if (element.isEnabled()) {
				WebDriverHelpers.SelectFromDropDown(driver, by);
			}
		}
		return this;
	}

	public PaymentDetails FillCardCVV(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			element.sendKeys("123");
		}
		return this;
	}

	public PaymentDetails ClickSubmit(By by) {
		List<WebElement> element = driver.findElements(by);
		
		if (!element.isEmpty()) {
			for (WebElement ele : element) {
				if (ele != null) {
					ele.click();
					break;
				} else {
					throw new RuntimeException("Payment button not visible");
				}
			}
		}

		return this;
	}
}
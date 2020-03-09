package com.webdriver.TyresSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.Library.WebDriverHelpers;
import com.webdriver.SetupData.MappingData;

public class PerformSearchBySize extends MappingData {
	WebDriver driver = null;

	TyreSearch tyresearch = new TyreSearch();
	
	WebElement form = null;

	public PerformSearchBySize(WebDriver driver, WebElement ele) {
		this.driver = driver;
		this.form = ele;
	}

	public PerformSearchBySize TyreSizeSearch() {
		return this;
	}

	public PerformSearchBySize SelectWidth(By by) throws Exception {
		WebElement element = form.findElement(by);
		if (element != null) {
			if (element.isEnabled()) {
				WebDriverHelpers.SelectFromDropDown(driver, by);
			}
		}
		return this;
	}

	public PerformSearchBySize SelectProfile(By by) throws Exception {
		WebElement element = form.findElement(by);
		if (element != null) {
			if (element.isEnabled()) {
				WebDriverHelpers.SelectFromDropDown(driver, by);
			}
		}
		return this;
	}

	public PerformSearchBySize SelectRimsize(By by) throws Exception {
		WebElement element = form.findElement(by);
		if (element != null) {
			if (element.isEnabled()) {
				WebDriverHelpers.SelectFromDropDown(driver, by);
			}
		}
		return this;
	}

	public PerformSearchBySize SelectSpeed(By by) throws Exception {
		WebElement element = form.findElement(by);
		if (element != null) {
			if (element.isEnabled()) {
				WebDriverHelpers.SelectFromDropDown(element, by);
			}
		}
		return this;
	}

	public PerformSearchBySize SelectWarehouse(By by, By by1) throws Exception {
		WebElement element = form.findElement(by).findElement(by1);
		if (element != null) {
			if (element.isEnabled()) {
				WebDriverHelpers.SelectFromDropDown(driver, by1);
			}
		}
		return this;
	}

	public PerformSearchBySize ClickPerformSearch(By by) {
		WebElement element = form.findElement(by);
		if (element != null) {
			element.click();
		}
		return this;
	}
}

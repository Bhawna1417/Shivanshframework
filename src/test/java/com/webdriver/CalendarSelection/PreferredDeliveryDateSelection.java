package com.webdriver.CalendarSelection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.Library.WebDriverHelpers;
import com.webdriver.SetupData.MappingData;
import com.webdriver.UtilSection.CheckElementDisplay;

public class PreferredDeliveryDateSelection extends MappingData {

	WebDriver driver = null;

	boolean datebutton = false;

	public boolean isDatebutton() {
		return datebutton;
	}

	public PreferredDeliveryDateSelection(WebDriver driver) {
		this.driver = driver;
		this.datebutton = false;
	}

	public PreferredDeliveryDateSelection CheckButtonType() throws Exception {
		if (!CheckElementDisplay.isElementNotDisplay(
				By.id(getidentifier("date.id.preferreddate")), driver)) {
			datebutton = true;
			ClickOpenPopup(By.id(getidentifier("date.id.preferreddate")));
		} else {
			datebutton = false;
		}

		return this;
	}

	public PreferredDeliveryDateSelection SelectDateFromPopup()
			throws Exception {
		WebDriverHelpers.waitUntilElementIsDisplay(driver,
				By.id(getidentifier("date.id.calendar")));

		WebDriverHelpers.waitUntilElementIsClickable(driver,
				By.className(getidentifier("date.class.addtocart")));

		driver.findElement(By.className(getidentifier("date.class.addtocart")))
				.click();

		return this;
	}

	public PreferredDeliveryDateSelection ClickOpenPopup(By locator) {
		WebElement element = driver.findElement(locator);

		element.click();

		WebDriverHelpers.waitUntilElementIsDisplay(driver,
				By.id(getidentifier("date.id.calendar")));

		return this;
	}

}
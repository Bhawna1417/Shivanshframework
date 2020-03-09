package com.webdriver.TyresSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.Data.DataSetCollectors;
import com.webdriver.Library.WebDriverHelpers;
import com.webdriver.SetupData.MappingData;
import com.webdriver.UtilSection.GetRandom;

public class PerformSearchByRegistration extends MappingData {

	WebDriver driver = null;

	TyreSearch tyresearch = new TyreSearch();

	DataSetCollectors data = null;

	String vehicleregno = null;

	boolean serachbyregno = false;

	WebElement form = null;

	public PerformSearchByRegistration(WebDriver driver,
			DataSetCollectors data, WebElement ele) {
		this.driver = driver;
		this.data = data;
		this.serachbyregno = false;
		this.form = ele;
	}

	private PerformSearchByRegistration GetVehicleRegistrationNumbers()
			throws Exception {
		int selectnumber = GetRandom.value(data.sizevehicelregnolist(), -1);
		this.vehicleregno = data.getvehicelregnolist(selectnumber);
		return this;
	}

	public PerformSearchByRegistration TyreVehicleSearch() throws Exception {
		GetVehicleRegistrationNumbers();
		CheckErrorMessageDisplayed();
		return this;
	}

	private PerformSearchByRegistration CheckErrorMessageDisplayed() {

		WebDriverHelpers.waitUntilElementIsDisplay(driver,
				By.id(getidentifier("tyreselector.errorpopup.id.popupbox")));

		return this;
	}

	public PerformSearchByRegistration FillRegistrationNo(By by) {
		WebElement element = form.findElement(by);
		if (element != null) {
			element.clear();
			element.sendKeys(vehicleregno);
		}
		return this;
	}

	public PerformSearchByRegistration SelectWarehouse(By by) throws Exception {
		WebElement element = form.findElement(by);
		if (element != null) {
			if (element.isEnabled()) {
				WebDriverHelpers.SelectFromDropDown(driver, by);
			}
		}
		return this;
	}

	public PerformSearchByRegistration CLickPerformSearch(By by) {
		WebElement element = form.findElement(by);
		if (element != null) {
			element.click();
		}
		return this;
	}
}

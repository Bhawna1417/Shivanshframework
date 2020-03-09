package com.webdriver.TyreSection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.Data.DataSetCollectors;
import com.webdriver.Page.TyreSelectorPage;
import com.webdriver.SetupData.MappingData;
import com.webdriver.TyresSelector.PerformSearchByRegistration;
import com.webdriver.TyresSelector.PerformSearchBySize;
import com.webdriver.TyresSelector.TyreSearch;
import com.webdriver.UtilSection.CheckElementDisplay;

public class TyreSelector extends MappingData {

	WebDriver driver = null;

	TyreSearch tyresearch = new TyreSearch();

	DataSetCollectors data = null;

	PerformSearchBySize sizesearch = null;

	PerformSearchByRegistration regnosearch = null;

	WebElement regnoform = null;

	WebElement sizeform = null;

	int counter = 0;
	
	String baseurl = null;

	public TyreSelector(WebDriver driver, DataSetCollectors data, String baseurl) {
		this.driver = driver;
		this.data = data;
		this.counter = 0;
		this.baseurl = baseurl;
	}

	public TyreSelector TyreSelectorSection() throws Exception {

		if (data.isEmptyvehicelregnolist()) {
			this.sizesearch = new PerformSearchBySize(driver, sizeform);
			SearchBySize();
		} else {
			this.regnosearch = new PerformSearchByRegistration(driver, data,
					regnoform);
			SearchByRegNo();
		}
		return this;
	}

	private TyreSelector SearchBySize() throws Exception {
		sizesearch.SelectWidth(By
				.id(getidentifier("tyreselector.id.selectwidth")));
		sizesearch.SelectProfile(By
				.id(getidentifier("tyreselector.id.selectprofile")));
		sizesearch.SelectRimsize(By
				.id(getidentifier("tyreselector.id.selectrimdia")));
		sizesearch.SelectSpeed(By
				.id(getidentifier("tyreselector.id.selectspeedrating")));
		sizesearch.SelectWarehouse(
				By.id(getidentifier("tyreselector.id.warehouse")),
				By.id(getidentifier("tyreselector.id.selectwarehouse")));
		sizesearch.ClickPerformSearch(By
				.id(getidentifier("tyreselector.id.sizeproceedsearch")));
		return this;
	}

	private TyreSelector SearchByRegNo() throws Exception {
		regnosearch.FillRegistrationNo(By.id(getidentifier("")));
		regnosearch.SelectWarehouse(By.id(getidentifier("")));
		regnosearch.CLickPerformSearch(By.id(getidentifier("")));
		return this;
	}

	public TyreSelector CheckTyreSelectorsDisplayed() {

		WebElement regnosearch = driver
				.findElement(
						By.id(getidentifier("tyreselector.id.registrationsearch")))
				.findElement(
						By.id(getidentifier("tyreselector.id.registrationform")));

		WebElement sizesearch = driver.findElement(
				By.id(getidentifier("tyreselector.id.sizesearch")))
				.findElement(By.id(getidentifier("tyreselector.id.sizeform")));

		if (regnosearch != null || sizesearch != null) {
			this.sizeform = sizesearch;
			this.regnoform = regnosearch;
		} else {
			throw new RuntimeException("None of the tyre selector is displayed");
		}

		return this;
	}

	public TyreSelector CheckResultsDisplayed() throws Exception {
		do {
			boolean results = CheckElementDisplay.isElementNotDisplay(
					By.className("no_results"), driver);

			if (results) {
				break;
			} else {
				TyreSelectorPage.OpenTyreSelectorPage(driver, baseurl);
				CheckTyreSelectorsDisplayed().TyreSelectorSection();
				counter++;
			}

			if (counter == 10) {
				throw new RuntimeException(
						"No results observed checked for 10 times");
			}
		} while (counter <= 10);

		return this;
	}
}
package com.webdriver.FacetFilter;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Facets {
	Logger facets = Logger.getLogger(Facets.class);
	WebDriver driver = null;

	FacetData data = new FacetData();

	public Facets(WebDriver driver) {
		this.driver = driver;
	}

	public Facets SelectFilter(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			facets.info("Selecting Filter");
			element.click();
		}
		return this;
	}

	public Facets SelectCheckBox(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			facets.info("Selecting Checkbox");
			element.click();
		}
		return this;
	}

	public Facets GetFacetName(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			element.getText();
			facets.info("Getting Current Facet Name");
		}
		return this;
	}
	
	public Facets GetFacetName(WebElement ele, By by) {
		WebElement element = ele.findElement(by);
		if (element != null) {
			element.getText();
			facets.info("Getting Current Facet Name");
		}
		return this;
	}

	public Facets GetFacetCount(By by) {
		List<WebElement> element = driver.findElements(by);
		if (!element.isEmpty()) {
			data.setFacetcount(element.size());
			facets.info("Getting Facet Count");
		}
		return this;
	}

	public Facets GetFacetText(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			System.out.println("Facet Name " + element.getText());
			facets.info("Getting Facet Text");
		}
		return this;
	}

	public Facets GetFacetProductCount(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			element.getText();
			facets.info("Getting Product Count");
		}
		return this;
	}

	public Facets GetFacetList(By by) {
		List<WebElement> element = driver.findElements(by);
		facets.info("Getting Facets List");
		if (!element.isEmpty()) {
			for (WebElement ele : element) {
				ele.getText();
			}
		}
		return this;
	}

	public Facets ClearExistingList() {
		facets.info("Clearing Facets list to collect new list displayed");
		ClearNames();
		ClearFacets();
		ClearFacetsText();
		ClearFacetsValueCount();
		ClearFacetsCount();
		return this;
	}

	public Facets ClearNames() {
		data.clearfacetnames();
		return this;
	}

	public Facets ClearFacets() {
		data.clearfacets();
		return this;
	}

	public Facets ClearFacetsText() {
		data.clearfacettext();
		return this;
	}

	public Facets ClearFacetsValueCount() {
		data.clearfacetvaluecount();
		return this;
	}

	public Facets ClearFacetsCount() {
		data.setFacetcount(0);
		return this;
	}
}
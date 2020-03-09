package com.webdriver.FacetOperations;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.FacetFilter.Facets;
import com.webdriver.Pagination.Pagination;
import com.webdriver.SetupData.MappingData;
import com.webdriver.UtilSection.CheckElementDisplay;
import com.webdriver.UtilSection.GetRandom;

public class FacetSection extends MappingData {

	WebDriver driver = null;

	WebElement element = null;

	Facets facet = null;

	ArrayList<WebElement> facets = new ArrayList<WebElement>();

	ArrayList<String> facets_id = new ArrayList<String>();

	ArrayList<Integer> filtercount = new ArrayList<Integer>();

	public FacetSection(WebDriver driver) {
		this.driver = driver;
		this.facet = new Facets(driver);
	}

	public FacetSection CheckFacetsDisplayed() {
		if (CheckElementDisplay.isElementDisplay(
				By.id(getidentifier("facet.id.facetsection")), driver)) {
			WebElement element = driver.findElement(
					By.id(getidentifier("facet.id.facetsection"))).findElement(
					By.id(getidentifier("facet.id.facetfilters")));
			if (element != null) {
				this.element = element;
				facets.clear();
				facets_id.clear();
				filtercount.clear();
				facet.ClearExistingList();
				CollectNewFacetsDispalyed();
			}
		}
		return this;
	}

	public FacetSection CollectNewFacetsDispalyed() {

		List<WebElement> facettypes = element.findElements(By
				.className(getidentifier("facet.class.facettypes")));

		for (WebElement ele : facettypes) {

			WebElement facetname = ele.findElement(By
					.className(getidentifier("facet.class.arrow")));

			facet.GetFacetName(facetname, By.xpath("p"));

			List<WebElement> filterlist = ele
					.findElement(
							By.className(getidentifier("facet.class.currentfilters")))
					.findElement(
							By.className(getidentifier("facet.class.filterlist")))
					.findElements(By.xpath("label"));

			boolean isselected = false;

			for (WebElement list : filterlist) {
				String classname = list.findElement(
						By.id(getidentifier("facet.id.checkbox")))
						.getAttribute("class");

				if (classname.toLowerCase().trim()
						.contains(getidentifier("facet.class.checked"))) {
					isselected = true;
					break;
				}
			}

			if (!isselected) {
				facets.add(ele);
			}

		}
		return this;
	}

	public FacetSection SelectNewFacet() throws Exception {
		if (facets.isEmpty()) {
			CheckFacetsDisplayed();
		}
		// WebElement selectfilter = null;

		int selectedfacet = GetRandom.value(facets.size(), -1);

		WebElement selectfacet = facets.get(selectedfacet);

		List<WebElement> filterlist = selectfacet
				.findElement(
						By.className(getidentifier("facet.class.currentfilters")))
				.findElement(
						By.className(getidentifier("facet.class.filterlist")))
				.findElements(By.xpath("label"));

		int selectedfilter = GetRandom.value(filterlist.size(), -1);

		int counter = 0;

		for (WebElement filter : filterlist) {
			if (counter == selectedfilter) {
				filter.click();
				break;
			}
			counter++;
		}

		facets.clear();

		return this;
	}

	public FacetSection Proceed() throws Exception {

		int i = 0;

		do {

			CheckFacetsDisplayed().SelectNewFacet();

			Pagination page = new Pagination(driver);

			page.CheckPagination().ProductCount();

			if (page.getProductcount() == 1) {
				i = 0;
			} else {
				i = 1;
			}
		} while (i != 0);

		return this;
	}
}
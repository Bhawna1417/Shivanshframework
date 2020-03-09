package com.webdriver.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.webdriver.Data.DataSetCollectors;
import com.webdriver.FacetOperations.FacetSection;
import com.webdriver.Pagination.Pagination;
import com.webdriver.Search.Search;
import com.webdriver.TestCaseBase.AkeoSanityTestBase;
import com.webdriver.UtilSection.CheckElementDisplay;
import com.webdriver.UtilSection.GetRandom;

public class TC09 extends AkeoSanityTestBase {

	@Test(description = "Search Functionality with Facet Filter operations")
	public static void TestCase09() throws Exception {
		WebDriver driver = getDriver();

		DataSetCollectors data = getDataset();
		Pagination page = new Pagination(driver);
		Search search = new Search(driver, page);
		FacetSection facetsection = new FacetSection(driver);

		do {
			search.FillTerm(
					By.id(data.getidentifier("search.id.searchbar")),
					data.getsearchtermslist(GetRandom.value(
							data.sizesearchtermslist(), 0))).PerformSearch(
					By.id(data.getidentifier("search.id.searchbutton")));
		} while (!CheckElementDisplay.isElementNotDisplay(
				By.id(data.getidentifier("search.id.noresult")), driver));

		page.CheckPagination().SortByOptions().ProductCount().PageCount();

		facetsection.CheckFacetsDisplayed().SelectNewFacet().Proceed();

		// search.OpenProductPageWindow(
		// By.className(data.getidentifier("listing.class.productlist")),
		// By.xpath("//ul[@class = 'cf']"), By.xpath("li"),
		// By.className(data.getidentifier("listing.class.productname")));

	}
}
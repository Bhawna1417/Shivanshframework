package com.webdriver.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.webdriver.Data.DataSetCollectors;
import com.webdriver.Pagination.Pagination;
import com.webdriver.Search.Search;
import com.webdriver.TestCaseBase.AkeoSanityTestBase;
import com.webdriver.UtilSection.CheckElementDisplay;
import com.webdriver.UtilSection.GetRandom;

public class TC08 extends AkeoSanityTestBase {

	@Test(description = "Variant Selection")
	public static void TestCase07() throws Exception {
		WebDriver driver = getDriver();

		DataSetCollectors data = getDataset();
		Pagination page = new Pagination(driver);
		Search search = new Search(driver, page);

		do {
			search.FillTerm(
					By.id(data.getidentifier("search.id.searchbar")),
					data.getsearchtermslist(GetRandom.value(
							data.sizesearchtermslist(), 0))).PerformSearch(
					By.id(data.getidentifier("search.id.searchbutton")));
		} while (!CheckElementDisplay.isElementNotDisplay(
				By.id(data.getidentifier("search.id.noresult")), driver));

		page.CheckPagination().SortByOptions().ProductCount().PageCount();

		search.OpenVariantProductPage(
				By.className(data.getidentifier("listing.class.productlist")),
				By.xpath("//ul[@class = 'cf']"), By.xpath("li"),
				By.className(data.getidentifier("listing.class.productcolors")),
				By.className(data.getidentifier("listing.class.productname")));

		System.out.println("Product Count " + page.getProductcount());

		System.out.println("Page Count " + page.getPagecount());

	}
}
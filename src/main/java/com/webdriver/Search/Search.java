package com.webdriver.Search;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.Library.WebDriverHelpers;
import com.webdriver.Pagination.Pagination;
import com.webdriver.UtilSection.CheckElementDisplay;
import com.webdriver.UtilSection.GetRandom;

public class Search {

	WebDriver driver = null;

	String productcount = null;

	int selectedpage = 0;

	int selectedproduct = 0;

	public int getSelectedpage() {
		return selectedpage;
	}

	public int getSelectedproduct() {
		return selectedproduct;
	}

	Pagination page = null;

	public String getProductcount() {
		return productcount;
	}

	public void setProductcount(String productcount) {
		this.productcount = productcount;
	}

	public Search(WebDriver driver, Pagination page) {
		this.driver = driver;
		this.page = page;
	}

	public Search PerformSearch(By by) {
		WebElement element = driver.findElement(by);

		if (element != null) {
			element.click();
		}
		return this;
	}

	public Search FillTerm(By by, String searchterm) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			element.sendKeys(searchterm);
		}
		return this;
	}

	public Search GetCount(By by, By by2) {
		WebElement element = driver.findElement(by).findElement(by2);

		if (element != null) {
			productcount = element.getText().replaceAll("[^0-9]", "");
		}

		return this;
	}

	public Search SelectSort(By by) throws Exception {
		WebElement element = driver.findElement(by);

		if (element != null) {
			WebDriverHelpers.SelectFromDropDown(driver, by);
		}
		return this;
	}

	public Search GridView(By by) {
		WebElement element = driver.findElement(by);

		if (element != null) {
			element.click();
		}
		return this;
	}

	public Search ListView(By by) {
		WebElement element = driver.findElement(by);

		if (element != null) {
			element.click();
		}
		return this;
	}

	public Search SingleView(By by) {
		WebElement element = driver.findElement(by);

		if (element != null) {
			element.click();
		}
		return this;
	}

	public Search SelectFilter(By by) {
		WebElement element = driver.findElement(by);

		if (element != null) {
			element.click();
		}
		return this;
	}

	public void SearchBar(By by) {

		if (CheckElementDisplay.isElementDisplay(by, driver)) {
			WebElement element = driver.findElement(by);
			if (element != null) {
				element.click();
			}
		}

	}

	public Search OpenProductPageWindow(By by1, By by2, By by3, By by4)
			throws Exception {

		SelectionProcess();

		// page.SelectPagination(selectedpage);

		WebElement element = driver.findElement(by1);

		List<WebElement> productlist = element.findElement(by2).findElements(
				by3);

		int counter = 0;

		for (WebElement ele : productlist) {
			counter++;

			if (counter == selectedproduct) {
				ele.findElement(by4).findElement(By.tagName("a")).click();
				break;
			}
		}

		Thread.sleep(10000);

		return this;
	}

	public Search OpenVariantProductPage(By by1, By by2, By by3, By by4, By by5)
			throws Exception {

		WebElement element = driver.findElement(by1);

		List<WebElement> productlist = element.findElement(by2).findElements(
				by3);

		for (WebElement ele : productlist) {
			if (CheckElementDisplay.isElementDisplay(by4, ele, driver)) {
				ele.findElement(by5).findElement(By.tagName("a")).click();
				break;
			}
		}

		Thread.sleep(10000);

		return this;
	}

	public Search SelectionProcess() throws Exception {
		int productcount = page.getProductcount();

		int selectproduct = GetRandom.value(productcount, 0);

		// System.out.println("Product to be selected " + select product);

		int temp = selectproduct % 48;

		if (temp == 0) {
			this.selectedpage = 1;

			this.selectedproduct = selectproduct;
		} else {
			this.selectedpage = (selectproduct / 48) + 1;

			this.selectedproduct = temp;
		}

		return this;
	}
}

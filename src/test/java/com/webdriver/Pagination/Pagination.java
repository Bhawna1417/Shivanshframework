package com.webdriver.Pagination;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.SetupData.MappingData;
import com.webdriver.UtilSection.CheckElementDisplay;

public class Pagination extends MappingData {
	WebDriver driver = null;

	int productcount = 0;

	int pagecount = 0;

	boolean paginationarea = false;

	WebElement paginationsection = null;

	public int getPagecount() {
		return pagecount;
	}

	public int getProductcount() {
		return productcount;
	}

	public Pagination(WebDriver driver) {
		this.driver = driver;
		this.productcount = 0;
		this.paginationarea = false;
	}

	public Pagination ProductCount() throws Exception {

		List<WebElement> producttotal = paginationsection
				// .findElement(
				// By.className(getidentifier("pagination.class.paginationarea")))
				.findElements(By
						.className(getidentifier("pagination.class.productcount")));

		this.productcount = Integer.parseInt(producttotal.get(0).getText());

		return this;
	}

	public Pagination SortByOptions() throws Exception {

		List<WebElement> sortbyoptions = paginationsection
				.findElement(
						By.className(getidentifier("pagination.class.paginationsort")))
				.findElements(
						By.className(getidentifier("pagination.class.sortoptions")));

		for (WebElement ele : sortbyoptions) {
			System.out.println(ele.getAttribute("value"));
			System.out.println(ele.getText());
		}

		return this;
	}

	public Pagination PageCount() throws Exception {

		WebElement pagetotal = paginationsection.findElement(By
				.className(getidentifier("pagination.class.paginationsort")));

		if (CheckElementDisplay
				.isElementDisplay(
						By.className(getidentifier("pagination.class.paginationsection")),
						pagetotal)) {
			WebElement pageslist = pagetotal
					.findElement(
							By.className(getidentifier("pagination.class.paginationsection")))
					.findElement(
							By.className(getidentifier("pagination.class.pagetotal")));
			this.pagecount = Integer.parseInt(pageslist.getText());
		} else {
			this.pagecount = 1;
		}
		return this;
	}

	public Pagination CheckPagination() {
		WebElement element = driver.findElement(By
				.className(getidentifier("pagination.class.paginationarea")));

		if (element != null) {
			this.paginationarea = true;
			this.paginationsection = element;
		}

		return this;
	}

	public Pagination SelectPagination(int selectedpage, int prod) {

		WebElement page = paginationsection
				.findElement(
						By.className(getidentifier("pagination.class.paginationsort")))
				.findElement(
						By.className(getidentifier("pagination.class.paginationsection")));

		System.out.println("Selected page = " + selectedpage);
		System.out.println("Selected product = " + prod);
		do {
			String currentselectedpage = page
					.findElement(
							By.className(getidentifier("pagination.class.pageselected")))
					.getText();

			if (selectedpage == Integer.parseInt(currentselectedpage)) {
				break;
			} else {
				page.findElement(
						By.className(getidentifier("pagination.class.next")))
						.click();
				;
			}

		} while (!CheckElementDisplay.isElementDisplay(
				By.className(getidentifier("pagination.class.next")), page));

		System.out.println("current url after page selection "
				+ driver.getCurrentUrl());

		return this;
	}
}

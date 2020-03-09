package com.webdriver.TyreSection;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.SetupData.MappingData;
import com.webdriver.UtilSection.GetRandom;

public class TyreListing extends MappingData {

	WebDriver driver = null;

	int productcount = 0;

	int selected = 0;

	public TyreListing(WebDriver driver) {
		this.driver = driver;
		this.productcount = 0;
		this.selected = 0;
	}

	public TyreListing GetProductCount() throws Exception {

		List<WebElement> producttotal = driver
				.findElement(
						By.className(getidentifier("pagination.class.paginationarea")))
				.findElements(
						By.className(getidentifier("pagination.class.productcount")));

		this.productcount = Integer.parseInt(producttotal.get(0).getText());

		// List<WebElement> productlist = driver.findElement(
		// By.className(getidentifier("listing.class.productlist")))
		// .findElements(By.xpath("//ul[@class = 'cf']/li"));

		if (productcount <= 48 && productcount > 1) {
			this.selected = GetRandom.value(productcount, 0);
		} else {
			this.selected = 1;
		}

		System.out.println("product list count " + productcount);
		System.out.println("selected product " + selected);
		return this;
	}

	public TyreListing SelectProduct() {
		System.out.println(selected);
		WebElement element = driver.findElement(By
				.className(getidentifier("listing.class.productlist")));

		List<WebElement> productlist = element.findElement(
				By.xpath("//ul[@class = 'cf']")).findElements(By.xpath("li"));

		int counter = 0;

		for (WebElement ele : productlist) {
			counter++;

			if (counter == selected) {
				ele.findElement(
						By.className(getidentifier("listing.class.productname")))
						.findElement(By.tagName("a")).click();
				break;
			}
		}

		// if (element != null) {
		//
		// List<WebElement> ele = element.findElements(By.xpath(".//*"));
		//
		// for (WebElement ele1 : ele) {
		// System.out.println(ele1.getText());
		// }
		//
		// // String url = element.findElement(
		// //
		// By.className(getidentifier("listing.class.productmoreinfo"))).getAttribute("href");
		// //
		// // System.out.println(url);
		// //
		// // driver.get(url);
		//
		// // WebElement ele1 = element
		// // .findElement(
		// // By.className(getidentifier("listing.class.productmoreinfo")))
		// // .findElement(By.tagName("a"));
		// //
		// // ele1.click();

		return this;
	}
}
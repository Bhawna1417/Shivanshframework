package com.webdriver.Carousel;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.UtilSection.CheckElementDisplay;

public class Carousel {

	Logger carousel = Logger.getLogger(Carousel.class);
	
	WebDriver driver = null;

	WebElement carouselbar = null;

	public Carousel(WebDriver driver) {
		this.driver = driver;
	}

	public Carousel CheckCarouselBar(By by, By by2) {
		if (CheckElementDisplay.isElementDisplay(by, driver)) {
			WebElement element = driver.findElement(by).findElement(by2);
			if (element != null) {
				this.carouselbar = element;
			}
		} else {
			carousel.info("Carousel is not displayed");
			throw new RuntimeException("Carousel is not displayed");
		}
		return this;
	}

	public Carousel CollectProductsList(By by, By by2, By by3, By by4, By by5) {
		List<WebElement> productslist = carouselbar.findElements(by);

		System.out.println("Products displayed " + productslist.size());

		carousel.info("Collecting product list displayed in Carousel");
		for (WebElement ele : productslist) {
			WebElement proddetails = ele.findElement(by2).findElement(
					By.tagName("a"));
			System.out.println("Product Link "
					+ proddetails.getAttribute("href"));
			System.out
					.println("Product Image "
							+ proddetails.findElement(by3)
									.findElement(By.tagName("img"))
									.getAttribute("src"));
			System.out.println("Product Name "
					+ proddetails.findElement(by4).getText());
			System.out.println("Product Price "
					+ proddetails.findElement(by5).getText());
		}

		return this;
	}

	public Carousel SelectClickPrevious() {
		return this;
	}

	public Carousel SelectClickNext() {
		return this;
	}

}
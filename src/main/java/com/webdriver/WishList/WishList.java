package com.webdriver.WishList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishList {

	WebDriver driver = null;

	boolean success = false;

	int productid = 0;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public WishList(WebDriver driver) {
		this.driver = driver;
	}

	public WishList OpenWishlistDetails(WebElement ele, By by) {
		if (!ele.getAttribute("class").toLowerCase().trim().contains("active")) {

			WebElement element = ele.findElement(by);
			if (element != null) {
				element.click();
			}
		}
		return this;
	}

	public WishList AddtoWishList(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			element.click();
		}
		return this;
	}

	public WishList CollectProductId(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			setProductid(Integer.parseInt(element.getText().replaceAll(
					"[^0-9]", "")));
		}
		return this;
	}

	public WishList Success(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			if (!element.findElement(By.tagName("img")).getAttribute("src")
					.toLowerCase().contains("empty")) {
				setSuccess(true);
			} else {
				setSuccess(false);
			}
		}
		return this;
	}

	public WishList RemoveProduct(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			element.click();
		}
		return this;
	}

	public String ProductName() {
		return null;
	}
}
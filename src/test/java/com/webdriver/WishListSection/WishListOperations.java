package com.webdriver.WishListSection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.webdriver.SetupData.MappingData;
import com.webdriver.UtilSection.CheckElementDisplay;
import com.webdriver.WishList.WishList;

public class WishListOperations extends MappingData {
	WebDriver driver = null;
	WishList wish = null;
	int productid = 0;

	public WishListOperations(WebDriver driver) {
		this.driver = driver;
		this.wish = new WishList(driver);
		this.productid = 0;
	}

	public WishListOperations AddProduct() {
		productid = wish.getProductid();
		if (productid == 0) {
			wish.CollectProductId(By
					.className(getidentifier("product.class.productcode")));
		}
		wish.AddtoWishList(By.id(getidentifier("product.id.wishlist")));
//				.Success(By.id(getidentifier("product.id.wishlist")));
//		if (!wish.isSuccess()) {
//			throw new RuntimeException("Product could not be added to Wishlist");
//		}
		return this;
	}

	public WishListOperations WishListPage() {
		if (CheckElementDisplay.isElementDisplay(
				By.className(getidentifier("wishlist.class.link")), driver)) {
			driver.findElement(
					By.className(getidentifier("wishlist.class.link"))).click();
		} else {
			if (CheckElementDisplay
					.isElementDisplay(
							By.xpath("//div[contains(@class, 'md-secondary-navigation')]//li[5]"),
							driver)) {
				driver.findElement(
						By.xpath("//div[contains(@class, 'md-secondary-navigation')]//li[5]"))
						.click();
			}
		}
		return this;
	}

	public WishListOperations RemoveProductFromWishlist() {
		wish.RemoveProduct(By.id(getidentifier("wishlit.id.remove")));
		return this;
	}
}
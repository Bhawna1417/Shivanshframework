package com.webdriver.Page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.Cart.ShoppingCart;
import com.webdriver.SetupData.MappingData;
import com.webdriver.UtilSection.GetRandom;

public class CartPage extends MappingData {

	WebDriver driver = null;

	ArrayList<WebElement> rowelement = new ArrayList<WebElement>();

	public CartPage(WebDriver driver) {
		this.driver = driver;
		this.rowelement.clear();
	}

	public CartPage UpdateQuantityCart(ShoppingCart shop) throws Exception {

		if (rowelement.isEmpty()) {
			GetProductsList();
		}

		ArrayList<Integer> updatedones = new ArrayList<Integer>();

		int selectproduct = 0;

		int productstoupdate = GetRandom.value(rowelement.size(), 0);

		for (int i = 1; i <= productstoupdate; i++) {
			boolean isquantityupdated = false;

			do {
				selectproduct = GetRandom.value(rowelement.size(), -1);
			} while (updatedones.contains(selectproduct));

			updatedones.add(selectproduct);

			System.out.println("Selected Product " + selectproduct);

			do {
				isquantityupdated = shop
						.SelectUpdateQuantity(
								By.id(getidentifier("cart.id.quantity")
										+ selectproduct)).CheckQuantityUpdated(
								By.id(getidentifier("cart.id.quantity")
										+ selectproduct));
			} while (!isquantityupdated);
		}

		return this;
	}

	public CartPage CollectCartDetails() {

		return this;
	}

	public CartPage RemoveQuantity(ShoppingCart shop) throws Exception {

		if (rowelement.isEmpty()) {
			GetProductsList();
		}

		int selectproduct = 0;

		int productstodelete = GetRandom.value(rowelement.size(), 0);

		for (int i = 1; i <= productstodelete; i++) {
			selectproduct = GetRandom.value(rowelement.size(), -1);

			System.out.println("Line selected " + selectproduct);

			shop.RemoveQuantity(rowelement.get(selectproduct),
					By.className(getidentifier("cart.class.id")),
					By.id(getidentifier("cart.id.remove") + selectproduct));

			rowelement.remove(rowelement.size() - 1);
		}

		return this;
	}

	public CartPage CheckOpenCartPage(String url) {

		driver.findElement(By.className(getidentifier("minicart.class.basket")))
				.findElement(By.tagName("a")).click();

		String title = driver.getTitle();

		if (title.toLowerCase().contains("disclaimer")) {
			driver.findElement(
					By.id(getidentifier("checkout.id.acceptdisclaimer")))
					.click();
		}

		// driver.get(url + "/view/content/basket");
		return this;
	}

	public CartPage GetProductsList() {
		WebElement element = driver.findElement(By
				.className(getidentifier("cart.class.list")));
		List<WebElement> productslist = element.findElements(By.tagName("li"));
		int counter = 0;

		if (!productslist.isEmpty()) {
			for (int i = 0; i < productslist.size(); i++) {
				rowelement.add(element.findElement(By
						.id(getidentifier("cart.id.orderline") + counter)));
				counter++;
			}
		}
		return this;
	}

	public CartPage ApplyPromotion() {

		return this;
	}
}
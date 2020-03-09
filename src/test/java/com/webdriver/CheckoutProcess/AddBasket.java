package com.webdriver.CheckoutProcess;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.CalendarSelection.PreferredDeliveryDateSelection;
import com.webdriver.Data.DataSetCollectors;
import com.webdriver.Data.ProductValues;
import com.webdriver.Library.WebDriverHelpers;
import com.webdriver.Product.ProductDetails;
import com.webdriver.SetupData.MappingData;
import com.webdriver.UtilSection.CheckElementDisplay;
import com.webdriver.UtilSection.GetRandom;

public class AddBasket extends MappingData {

	WebDriver driver = null;

	ArrayList<String> urls = new ArrayList<String>();

	ArrayList<Integer> indexused = new ArrayList<Integer>();

	DataSetCollectors data = null;

	int productcount = 0;

	int counter = 0;

	int maxquantity = 0;

	ProductDetails product = null;

	PreferredDeliveryDateSelection preferred = null;

	int basketcount = 0;

	ProductSelectionType prodselection = null;

	int selection = 0;

	public AddBasket(WebDriver driver, ProductValues prod,
			ProductDetails product, PreferredDeliveryDateSelection preferred,
			DataSetCollectors data, String baseurl) throws Exception {
		this.data = data;
		this.driver = driver;
		this.counter = 0;
		this.product = product;
		this.preferred = preferred;

		if (data.getMaxquantity() > 1) {
			this.maxquantity = 1;
		} else {
			this.maxquantity = GetRandom.value(data.getMaxquantity(), 0);
		}
		this.productcount = 1;
		// this.productcount = GetRandom.value(data.getMaxproduct(), 0);
		this.basketcount = 0;
		this.prodselection = new ProductSelectionType(driver, productcount,
				prod, data, baseurl);
	}

	public AddBasket DetailPageSelectAddProduct(int select) throws Exception {

		this.selection = select;
		prodselection.RandomSelector(selection);

		if (!CheckElementDisplay.isElementNotDisplay(
				By.id(getidentifier("product.id.quantity")), driver)) {
			product.FillDesiredQuantity(
					By.id(getidentifier("product.id.quantity")), maxquantity);

			counter++;
			System.out.println("Before check " + basketcount);
		} else {
			System.out.println("No quantity displayed hence skipped product");
		}
		return this;
	}

	public AddBasket AddtoBasket() throws Exception {

		if (!preferred.CheckButtonType().isDatebutton()) {
			product.ClickAddtoCart(By
					.className(getidentifier("product.class.addtocart")));
		} else {
			preferred.SelectDateFromPopup();
		}

		return this;
	}

	public AddBasket CheckProductAdded() throws Exception {
		WebDriverHelpers.waitUntilElementIsDisplay(driver,
				By.className(getidentifier("minicart.class.basket")));
		WebDriverHelpers.waitUntilElementIsDisplay(driver,
				By.className(getidentifier("minicart.class.quantity")));

		// if (productcount != 1) {
		String tempvalue = driver
				.findElement(
						By.className(getidentifier("minicart.class.basket")))
				.findElement(
						By.className(getidentifier("minicart.class.quantity")))
				.getText();

		if (!tempvalue.isEmpty()) {
			int newbasketcount = Integer.parseInt(tempvalue.replaceAll(
					"[^0-9]", ""));

			if (basketcount != newbasketcount) {
				basketcount = newbasketcount;
			}

			System.out.println("After check " + basketcount);
		}
		// }

		return this;
	}

	public void Proceed() throws Exception {

		if (counter < productcount) {
			DetailPageSelectAddProduct(selection).AddtoBasket()
					.CheckProductAdded().Proceed();
		}
	}

	public AddBasket SelectVariant() throws Exception {
		WebElement element = driver.findElement(By
				.className(getidentifier("variants.class.options")));

		List<WebElement> variants = element
				.findElement(
						By.className(getidentifier("variants.class.section")))
				.findElement(
						By.className(getidentifier("variants.class.selector")))
				.findElement(
						By.className(getidentifier("variants.class.vaiantlist")))
				.findElements(By.tagName("li"));

		int selectvariant = GetRandom.value(variants.size(), -1);

		variants.get(selectvariant).click();

		return this;
	}
}
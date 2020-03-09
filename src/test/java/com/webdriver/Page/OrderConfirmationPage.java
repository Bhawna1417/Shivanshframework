package com.webdriver.Page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.OrderConfirm.OrderConfirm;
import com.webdriver.SetupData.MappingData;

public class OrderConfirmationPage extends MappingData {

	WebDriver driver = null;

	ArrayList<WebElement> rowelement = new ArrayList<WebElement>();

	int orderno = 0;

	public int getOrderno() {
		return orderno;
	}

	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}

	public OrderConfirmationPage(WebDriver driver) {
		this.driver = driver;
		this.rowelement.clear();
	}

	public OrderConfirmationPage CheckOrderDisplayed() {
		List<WebElement> element = driver.findElements(By
				.className(getidentifier("confirm.class.orderno")));

		if (!element.isEmpty()) {
			for (WebElement ele : element) {
				String gettagname = ele.getTagName();

				if (!gettagname.toLowerCase().contentEquals("p")) {
					continue;
				} else {
					String ordermessage = ele.getText();
					System.out.println(ordermessage);
					String[] temp = ordermessage.split(" ");

					setOrderno(Integer.parseInt(temp[temp.length - 1]));
					System.out.println(Integer.parseInt(temp[temp.length - 1]));
					GetProductsList();
				}
			}
		}

		return this;
	}

	public OrderConfirmationPage OrderDetails(OrderConfirm confirm) {

		for (int i = 0; i < rowelement.size(); i++) {

			confirm.SetRowElement(rowelement.get(i));

			confirm.CollectProductNames(
					By.className(getidentifier("confirm.class.details")),
					By.className(getidentifier("confirm.class.name")));

			confirm.CollectProductID(
					By.className(getidentifier("confirm.class.details")),
					By.className(getidentifier("confirm.class.id")));

			confirm.CollectProductShippingAddress(
					By.className(getidentifier("confirm.class.address")),
					By.id(getidentifier("confirm.id.address")));

			confirm.CollectProductBasePrice(By
					.className(getidentifier("confirm.class.baseprice")));

			confirm.CollectProductQuantity(By
					.className(getidentifier("confirm.class.quantity")));

			confirm.CollectProductTotalPrice(By
					.className(getidentifier("confirm.class.totalprice")));

		}

		WebElement ordertotal = driver.findElement(By
				.id(getidentifier("confirm.id.ordercost")));

		confirm.CollectCheckoutAmount(ordertotal,
				By.className(getidentifier("confirm.class.totalorder")));

		return this;
	}

	public OrderConfirmationPage GetProductsList() {

		List<WebElement> productslist = driver.findElements(By
				.className(getidentifier("confirm.class.cartlist")));

		if (!productslist.isEmpty()) {
			for (WebElement ele : productslist) {

				if (ele.getTagName().toLowerCase().contains("tr")) {

					if (ele.getAttribute("class").isEmpty()) {
						rowelement.add(ele);
					}
				}
			}
		}

		return this;
	}
}
package com.webdriver.Page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.OrderHistory.OrderHistory;
import com.webdriver.SetupData.MappingData;

public class OrderHistoryPage extends MappingData {
	WebDriver driver = null;
	ArrayList<WebElement> orderrowelement = new ArrayList<WebElement>();
	OrderHistory history = null;

	public OrderHistoryPage(WebDriver driver) {
		this.driver = driver;
		this.history = new OrderHistory(driver);
		this.orderrowelement.clear();
	}

	public OrderHistoryPage OpenOrderHistory(WebElement ele, By by) {
		// System.out.println(ele.getAttribute("class"));
		if (!ele.getAttribute("class").toLowerCase().trim().contains("active")) {

			WebElement element = ele.findElement(by);
			if (element != null) {
				element.click();
			}
		}
		return this;
	}

	public OrderHistoryPage CollectOrdersDetails() {
		for (int i = 0; i < orderrowelement.size(); i++) {
			history.SetRowElement(orderrowelement.get(i));

			history.CollectOrderDate(By
					.className(getidentifier("myaccount.class.orderdate")));
			history.CollectOrderNumber(By
					.className(getidentifier("myaccount.class.orderid")));
			history.CollectOrderTotal(By
					.className(getidentifier("myaccount.class.ordertotal")));
			history.CollectOrderStatus(By
					.className(getidentifier("myaccount.class.orderstatus")));
		}
		return this;
	}

	public OrderHistoryPage GetOrdersList() {
		WebElement element = driver.findElement(By
				.className(getidentifier("myaccount.class.orderssection")));

		// List<WebElement> orderslist = element.findElements(By
		// .className(getidentifier("myaccount.class.orderline")));
		List<WebElement> orderslist = element
				.findElement(By.className(getidentifier("myaccount.class.orderlist")))
				.findElement(By.tagName("tbody"))
				.findElements(By.tagName("tr"));

		if (!orderslist.isEmpty()) {
			for (WebElement ele : orderslist) {
				// orderrowelement.add(ele.findElement(By.className("row")));
				orderrowelement.add(ele);
			}
		}
		return this;
	}

	public OrderHistoryPage GetTotalOrders() {
		WebElement element = driver
				.findElement(By
						.className(getidentifier("myaccount.class.historypaginationbar")));

		WebElement total = element.findElement(By
				.className(getidentifier("myaccount.class.historyorders")));

		System.out.println("Order totals " + total.getText());

		return this;
	}
}
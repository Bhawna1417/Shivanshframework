package com.webdriver.OrderHistory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderHistory {

	WebDriver driver = null;
	WebElement orderrow = null;

	OrderHistoryDetails history = new OrderHistoryDetails();

	public OrderHistory(WebDriver driver) {
		this.driver = driver;
		this.history.clearproductname();
		this.history.clearproductprice();
		this.history.clearproductquantity();
		this.history.clearproducttotalprice();
	}

	public OrderHistory SetRowElement(WebElement row) {
		this.orderrow = row;
		return this;
	}

	public OrderHistory OpenOrderHistory(WebElement ele, By by) {
		// System.out.println(ele.getAttribute("class"));
		if (!ele.getAttribute("class").toLowerCase().trim().contains("active")) {

			WebElement element = ele.findElement(by);
			if (element != null) {
				element.click();
			}
		}
		return this;
	}
	
	public OrderHistory CollectOrderNumber(By by) {
		WebElement element = orderrow.findElement(by);
		if (element != null) {
			history.addordernumber(Integer.parseInt(element.getText()));
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderHistory CollectOrderDate(By by) {
		WebElement element = orderrow.findElement(by);
		if (element != null) {
			history.addorderdate(element.getText());
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderHistory CollectOrderName(By by) {
		WebElement element = orderrow.findElement(by);
		if (element != null) {
			history.addordername(element.getText());
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderHistory CollectOrderNameEng(By by) {
		WebElement element = orderrow.findElement(by);
		if (element != null) {
			history.addordername(element.getText());
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderHistory CollectPaymentMethod(By by, By by2) {
		WebElement element = orderrow.findElement(by).findElement(by2);
		if (element != null) {
			history.addpaymentmethod(element.getText());
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderHistory CollectOrderTotal(By by) {
		WebElement element = orderrow.findElement(by);
		if (element != null) {
			history.addordertotal(Integer.parseInt(element.getText()
					.replaceAll("[^0-9]", "")));
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderHistory CollectOrderStatus(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			history.addorderstatus(element.getText());
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderHistory CollectOrderProductNames(WebElement ele, By by, By by2) {
		WebElement element = ele.findElement(by);
		if (element != null) {
			history.addproductname(element.getText());
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderHistory CollectOrderProductEngNames(WebElement ele, By by,
			By by2) {
		WebElement element = ele.findElement(by);
		if (element != null) {
			history.addproductengname(element.getText());
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderHistory CollectOrderProductID(WebElement ele, By by, By by2) {
		WebElement element = ele.findElement(by);
		if (element != null) {
			history.addproductid(element.getText());
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderHistory CollectOrderProductQuantity(WebElement ele, By by,
			By by2) {
		WebElement element = ele.findElement(by);
		if (element != null) {
			history.addproductquantity(Integer.parseInt(element.getText()));
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderHistory CollectOrderProductTotalPrice(WebElement ele, By by,
			By by2) {
		WebElement element = ele.findElement(by);
		if (element != null) {
			history.addproducttotalprice(Integer.parseInt(element.getText()));
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderHistory CollectOrderProductPrice(WebElement ele, By by, By by2) {
		WebElement element = ele.findElement(by);
		if (element != null) {
			history.addproductprice(Integer.parseInt(element.getText()));
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderHistory CollectOrderCheckoutAmount(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			history.addordertotal(Integer.parseInt(element.getText()
					.replaceAll("[^0-9]", "")));
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderHistory CollectOrderDiscount(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			history.setDiscount(Integer.parseInt(element.getText().replaceAll(
					"[^0-9]", "")));
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderHistory CollectCosigneeName(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			history.setConsigneename(element.getText());
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderHistory CollectMobile1(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			history.setMobile1(Integer.parseInt(element.getText()));
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderHistory CollectMobile2(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			history.setMobile2(Integer.parseInt(element.getText()));
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderHistory CollectShippingAddress(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			history.setShippingaddress(element.getText());
			System.out.println(element.getText());
		}
		return this;
	}
}
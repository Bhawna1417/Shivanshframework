package com.webdriver.OrderHistory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderDetails {
	WebDriver driver = null;
	WebElement productrow = null;

	OrderHistoryDetails currentorder = new OrderHistoryDetails();

	public OrderDetails(WebDriver driver) {
		this.driver = driver;
	}

	public OrderDetails SetRowElement(WebElement row) {
		this.productrow = row;
		return this;
	}

	public OrderDetails CollectOrderNumber(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			// currentorder.setOrdernumber(Integer.parseInt(element.getText()));
		}
		return this;
	}

	public OrderDetails CollectOrderDate(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			// currentorder.setOrderdate(element.getText());
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderDetails CollectPaymentMethod(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			// currentorder.setPaymentmethod(element.getText());
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderDetails CollectProductNames(By by, By by2) {
		WebElement ele = productrow.findElement(by).findElement(by2);
		if (ele != null) {
			// currentorder.addproductname(ele.getText());
			System.out.println(ele.getText());
		}
		return this;
	}

	public OrderDetails CollectProductEngNames(By by, By by2) {
		WebElement ele = productrow.findElement(by).findElement(by2);
		if (ele != null) {
			// currentorder.addproductengname(ele.getText());
			System.out.println(ele.getText());
		}
		return this;
	}

	public OrderDetails CollectProductID(By by, By by2) {
		WebElement ele = productrow.findElement(by).findElement(by2);
		if (ele != null) {
			// currentorder.addproductid(ele.getText());
			System.out.println(ele.getText());
		}
		return this;
	}

	public OrderDetails CollectProductQuantity(By by, By by2) {
		WebElement ele = productrow.findElement(by).findElement(by2);
		if (ele != null) {
			// currentorder.addproductquantity(Integer.parseInt(ele.getText()
			// .replaceAll("[^0-9]", "")));
			System.out.println(ele.getText());
		}
		return this;
	}

	public OrderDetails CollectProductUnitPrice(By by, By by2, By by3) {
		WebElement ele = productrow.findElement(by).findElement(by2)
				.findElement(by3);
		if (ele != null) {
			// currentorder.addproductunitprice(Integer.parseInt(ele.getText()
			// .replaceAll("[^0-9]", "")));
			System.out.println(ele.getText());
		}
		return this;
	}

	public OrderDetails CollectProductOriginalPrice(WebElement ele, By by) {
		if (ele != null) {
			// currentorder.addproductunitprice(Integer.parseInt(ele.getText()
			// .replaceAll("[^0-9]", "")));
			System.out.println(ele.findElement(by).getText());
		}
		return this;
	}

	public OrderDetails CollectProductDiscountPrice(WebElement ele, By by) {
		if (ele != null) {
			// currentorder.addproductunitprice(Integer.parseInt(ele.getText()
			// .replaceAll("[^0-9]", "")));
			System.out.println(ele.findElement(by).getText());
		}
		return this;
	}

	public OrderDetails CollectProductAfterDiscountPrice(WebElement ele, By by) {
		if (ele != null) {
			// currentorder.addproductunitprice(Integer.parseInt(ele.getText()
			// .replaceAll("[^0-9]", "")));
			System.out.println(ele.findElement(by).getText());
		}
		return this;
	}

	public OrderDetails CollectProductDiscountUnitPrice(WebElement ele, By by,
			By by2, By by3) {
		if (ele != null) {
			// currentorder.addproductunitprice(Integer.parseInt(ele
			// .findElement(by).getText().replaceAll("[^0-9]", "")));
			// currentorder.addproductdiscountprice(Integer.parseInt(ele
			// .findElement(by2).getText().replaceAll("[^0-9]", "")));
			// currentorder.addproducttotalprice(Integer.parseInt(ele
			// .findElement(by3).getText().replaceAll("[^0-9]", "")));
		}
		return this;
	}

	public OrderDetails CollectProductTotalPrice(By by, By by2) {
		WebElement ele = productrow.findElement(by).findElement(by2);
		if (ele != null) {
			// currentorder.addproducttotalprice(Integer.parseInt(ele.getText()
			// .replaceAll("[^0-9]", "")));
			System.out.println(ele.getText());
		}
		return this;
	}

	public OrderDetails CollectCheckoutAmount(WebElement ele, By by) {
		WebElement element = ele.findElement(by);
		if (element != null) {
			// currentorder.setOrdertotal(Integer.parseInt(element.getText()
			// .replaceAll("[^0-9]", "")));
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderDetails CollectOriginalAmount(WebElement ele, By by) {
		WebElement element = ele.findElement(by);
		if (element != null) {
			// currentorder.setOrdertotal(Integer.parseInt(element.getText()
			// .replaceAll("[^0-9]", "")));
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderDetails CollectDiscountAmount(WebElement ele, By by) {
		WebElement element = ele.findElement(by);
		if (element != null) {
			// currentorder.setOrdertotal(Integer.parseInt(element.getText()
			// .replaceAll("[^0-9]", "")));
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderDetails CollectSubTotalAmount(WebElement ele, By by) {
		WebElement element = ele.findElement(by);
		if (element != null) {
			// currentorder.setOrdertotal(Integer.parseInt(element.getText()
			// .replaceAll("[^0-9]", "")));
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderDetails CollectDiscount(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			currentorder.setDiscount(Integer.parseInt(element.getText()
					.replaceAll("[^0-9]", "")));
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderDetails CollectCosigneeName(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			currentorder.setConsigneename(element.getText());
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderDetails CollectMobile1(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			currentorder.setMobile1(Integer.parseInt(element.getText()));
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderDetails CollectMobile2(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			currentorder.setMobile2(Integer.parseInt(element.getText()));
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderDetails CollectShippingAddress(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			currentorder.setShippingaddress(element.getText());
			System.out.println(element.getText());
		}
		return this;
	}
}
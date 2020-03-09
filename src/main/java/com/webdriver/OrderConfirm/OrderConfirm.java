package com.webdriver.OrderConfirm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirm {

	WebDriver driver = null;
	WebElement productrow = null;

	ConfirmationOrderDetails currentorder = new ConfirmationOrderDetails();

	public OrderConfirm(WebDriver driver) {
		this.driver = driver;
	}

	public OrderConfirm SetRowElement(WebElement row) {
		this.productrow = row;
		return this;
	}

	public OrderConfirm CollectOrderNumber(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			currentorder.setOrdernumber(Integer.parseInt(element.getText()));
		}
		return this;
	}

	public OrderConfirm CollectOrderDate(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			currentorder.setOrderdate(element.getText());
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderConfirm CollectPaymentMethod(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			currentorder.setPaymentmethod(element.getText());
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderConfirm SetProductCount(int count) {
		currentorder.setProductcount(count);
		return this;
	}

	// public int ProductsList(By by, By by2) {
	// int count = 0;
	// WebElement element = driver.findElement(by);
	// if (element != null) {
	// List<WebElement> products = element.findElements(by2);
	// count = products.size();
	// }
	// currentorder.setProductcount(count);
	// return count;
	// }

	public OrderConfirm CollectProductNames(By by, By by2) {
		WebElement ele = productrow.findElement(by).findElement(by2);
		if (ele != null) {
			currentorder.addproductname(ele.getText());
			System.out.println(ele.getText());
		}
		return this;
	}

	public OrderConfirm CollectProductEngNames(By by, By by2) {
		WebElement ele = productrow.findElement(by).findElement(by2);
		if (ele != null) {
			currentorder.addproductengname(ele.getText());
			System.out.println(ele.getText());
		}
		return this;
	}

	public OrderConfirm CollectProductID(By by, By by2) {
		WebElement ele = productrow.findElement(by).findElement(by2);
		if (ele != null) {
			currentorder.addproductid(ele.getText());
			System.out.println(ele.getText());
		}
		return this;
	}

	public OrderConfirm CollectProductQuantity(By by, By by2) {
		WebElement ele = productrow.findElement(by).findElement(by2);
		if (ele != null) {
			currentorder.addproductquantity(Integer.parseInt(ele.getText()
					.replaceAll("[^0-9]", "")));
			System.out.println(ele.getText());
		}
		return this;
	}

	public OrderConfirm CollectProductQuantity(By by) {
		WebElement ele = productrow.findElement(by);
		if (ele != null) {
			currentorder.addproductquantity(Integer.parseInt(ele.getText()
					.replaceAll("[^0-9]", "")));
			System.out.println(ele.getText());
		}
		return this;
	}

	public OrderConfirm CollectProductUnitPrice(By by, By by2, By by3) {
		WebElement ele = productrow.findElement(by).findElement(by2)
				.findElement(by3);
		if (ele != null) {
			currentorder.addproductunitprice(Integer.parseInt(ele.getText()
					.replaceAll("[^0-9]", "")));
			System.out.println(ele.getText());
		}
		return this;
	}

	public OrderConfirm CollectProductOriginalPrice(WebElement ele, By by) {
		if (ele != null) {
			// currentorder.addproductunitprice(Integer.parseInt(ele.getText()
			// .replaceAll("[^0-9]", "")));
			System.out.println(ele.findElement(by).getText());
		}
		return this;
	}

	public OrderConfirm CollectProductDiscountPrice(WebElement ele, By by) {
		if (ele != null) {
			// currentorder.addproductunitprice(Integer.parseInt(ele.getText()
			// .replaceAll("[^0-9]", "")));
			System.out.println(ele.findElement(by).getText());
		}
		return this;
	}

	public OrderConfirm CollectProductAfterDiscountPrice(WebElement ele, By by) {
		if (ele != null) {
			// currentorder.addproductunitprice(Integer.parseInt(ele.getText()
			// .replaceAll("[^0-9]", "")));
			System.out.println(ele.findElement(by).getText());
		}
		return this;
	}

	public OrderConfirm CollectProductDiscountUnitPrice(WebElement ele, By by,
			By by2, By by3) {
		if (ele != null) {
			currentorder.addproductunitprice(Integer.parseInt(ele
					.findElement(by).getText().replaceAll("[^0-9]", "")));
			currentorder.addproductdiscountprice(Integer.parseInt(ele
					.findElement(by2).getText().replaceAll("[^0-9]", "")));
			currentorder.addproducttotalprice(Integer.parseInt(ele
					.findElement(by3).getText().replaceAll("[^0-9]", "")));
		}
		return this;
	}

	public OrderConfirm CollectProductTotalPrice(By by, By by2) {
		WebElement ele = productrow.findElement(by).findElement(by2);
		if (ele != null) {
			currentorder.addproducttotalprice(Integer.parseInt(ele.getText()
					.replaceAll("[^0-9]", "")));
			System.out.println(ele.getText());
		}
		return this;
	}

	public OrderConfirm CollectProductTotalPrice(By by) {
		WebElement ele = productrow.findElement(by);
		if (ele != null) {
			currentorder.addproducttotalprice(Integer.parseInt(ele.getText()
					.replaceAll("[^0-9]", "")));
			System.out.println(ele.getText());
		}
		return this;
	}

	public OrderConfirm CollectCheckoutAmount(WebElement ele, By by) {
		WebElement element = ele.findElement(by);
		if (element != null) {
			currentorder.setOrdertotal(Integer.parseInt(element.getText()
					.replaceAll("[^0-9]", "")));
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderConfirm CollectOriginalAmount(WebElement ele, By by) {
		WebElement element = ele.findElement(by);
		if (element != null) {
			// currentorder.setOrdertotal(Integer.parseInt(element.getText()
			// .replaceAll("[^0-9]", "")));
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderConfirm CollectDiscountAmount(WebElement ele, By by) {
		WebElement element = ele.findElement(by);
		if (element != null) {
			// currentorder.setOrdertotal(Integer.parseInt(element.getText()
			// .replaceAll("[^0-9]", "")));
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderConfirm CollectSubTotalAmount(WebElement ele, By by) {
		WebElement element = ele.findElement(by);
		if (element != null) {
			// currentorder.setOrdertotal(Integer.parseInt(element.getText()
			// .replaceAll("[^0-9]", "")));
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderConfirm CollectDiscount(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			currentorder.setDiscount(Integer.parseInt(element.getText()
					.replaceAll("[^0-9]", "")));
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderConfirm CollectCosigneeName(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			currentorder.setConsigneename(element.getText());
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderConfirm CollectMobile1(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			currentorder.setMobile1(Integer.parseInt(element.getText()));
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderConfirm CollectMobile2(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			currentorder.setMobile2(Integer.parseInt(element.getText()));
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderConfirm CollectShippingAddress(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			currentorder.setShippingaddress(element.getText());
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderConfirm CollectProductShippingAddress(By by, By by1) {
		WebElement element = driver.findElement(by).findElement(by1);
		if (element != null) {
			currentorder.setShippingaddress(element.getText());
			System.out.println(element.getText());
		}
		return this;
	}

	public OrderConfirm CollectProductBasePrice(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			currentorder
					.addproductunitprice(Integer.parseInt(element.getText()));
			System.out.println(element.getText());
		}
		return this;
	}

}
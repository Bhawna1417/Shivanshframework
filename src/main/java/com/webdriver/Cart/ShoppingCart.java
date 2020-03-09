package com.webdriver.Cart;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.Library.WebDriverHelpers;

public class ShoppingCart {
	WebDriver driver = null;

	CartDetails cart = new CartDetails();

	Logger shoppingcart = Logger.getLogger(ShoppingCart.class);

	int selected = 0;

	public ShoppingCart(WebDriver driver) {
		this.driver = driver;
		this.selected = 0;
	}

	public ShoppingCart ProceedCheckout(By by1, By by2) {
		WebElement element = driver.findElement(by1).findElement(by2);
		if (element != null) {
			shoppingcart.info("Proceeding for Checkout Process");
			element.click();
		}
		return this;
	}

	public ShoppingCart SelectUpdateQuantity(By by) throws Exception {

		shoppingcart.info("Updating Quantity for the product");
		WebElement element = driver.findElement(by);
		try {

			if (element != null) {
				if (element.isEnabled()) {
					selected = Integer.parseInt(WebDriverHelpers
							.GetSelectedValueDropdown(driver, by));
					WebDriverHelpers.SelectFromDropDown(driver, by);
					WebDriverHelpers.waitUntilElementIsDisplay(driver,
							By.className("alert-success"));
				}
			}
		} catch (Exception e) {
			shoppingcart.info(e.getMessage());
			System.out.println(e.getMessage());
		}
		return this;
	}

	public boolean CheckQuantityUpdated(By by) throws Exception {
		int currentselected = 0;
		WebElement element = driver.findElement(by);
		shoppingcart.info("Checking Quantity update is successful or not");
		try {
			if (element != null) {
				if (element.isEnabled()) {
					currentselected = Integer.parseInt(WebDriverHelpers
							.GetSelectedValueDropdown(driver, by));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			shoppingcart.info("Quantity update is not successful "
					+ e.getMessage());
		}
		if (currentselected == selected) {
			return false;
		} else {
			return true;
		}
	}

	public ShoppingCart RemoveQuantity(WebElement element, By by, By by2)
			throws Exception {
		shoppingcart.info("Removing Product from the Cart");
		if (element != null) {
			if (element.isEnabled()) {

				WebElement itemid = element.findElement(by);
				System.out.println("Item deleted with id as "
						+ itemid.getText());

				List<WebElement> delete = element.findElements(by2);

				for (WebElement ele : delete) {
					if (ele != null) {
						if (ele.isDisplayed()) {
							ele.click();
							shoppingcart.info("Product Removal is success");
							break;
						}
					}
				}

				// WebDriverHelpers.waitUntilElementIsClickable(driver, delete);
			}
		}
		// WebDriverHelpers.waitUntilElementIsNotDisplay(driver, by);
		return this;
	}

	public ShoppingCart CollectProductId(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			cart.addproductids(element.getText());
			shoppingcart.info("Collecting Product ID");
		}
		return this;
	}

	public ShoppingCart CollectProductName(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			cart.addproductnames(element.getText());
			shoppingcart.info("Collecting Product Name");
		}
		return this;
	}

	public ShoppingCart CollectProductNameEng(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			cart.addproductnameseng(element.getText());
			shoppingcart.info("Collecting Product English Name");
		}
		return this;
	}

	public ShoppingCart CollectProductQuantity(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			cart.addproductquantity(Integer.parseInt(element.getText()));
			shoppingcart.info("Collecting Product Quantity");
		}
		return this;
	}

	public ShoppingCart CollectProductUnitPrice(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			cart.addproductunitprices(Integer.parseInt(element.getText()));
			shoppingcart.info("Collecting Product Unit Price");
		}
		return this;
	}

	public ShoppingCart CollectProductTotalPrice(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			cart.addproducttotalprices(Integer.parseInt(element.getText()));
			shoppingcart.info("Collecting Product Total Price");
		}
		return this;
	}

	public ShoppingCart CollectOrderSubTotal(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			cart.setPriceordersubtotal(Integer.parseInt(element.getText()));
			shoppingcart.info("Collecting OrderSub Toatal");
		}
		return this;
	}

	public ShoppingCart CollectOrderDiscount(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			cart.setDiscount(Integer.parseInt(element.getText()));
			shoppingcart.info("Collecting Order Discount");
		}
		return this;
	}

	public ShoppingCart CollectOrderTotalTax(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			cart.setPricetotaltax(Integer.parseInt(element.getText()));
			shoppingcart.info("Collecting Order Total Tax");
		}
		return this;
	}

	public ShoppingCart CollectOrderGrandTotal(By by) {
		WebElement element = driver.findElement(by);
		if (element != null) {
			cart.setGrandtotal(Integer.parseInt(element.getText()));
			shoppingcart.info("Collecting Order Grand Total");
		}
		return this;
	}

	public ShoppingCart FillPromotionDetails(By by, String string) {
		WebElement element = driver.findElement(by);

		if (element != null) {
			element.sendKeys(string);
		}
		return this;
	}

	public ShoppingCart ClickApplyPromotion(By by) {
		WebElement element = driver.findElement(by);

		if (element != null) {
			element.click();
		}
		return this;
	}

	public ShoppingCart CheckPromotionApplied(By by) {
		WebElement element = driver.findElement(by);

		if (element != null) {
			element.click();
		}
		return this;

	}
}
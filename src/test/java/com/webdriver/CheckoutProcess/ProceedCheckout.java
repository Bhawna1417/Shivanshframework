package com.webdriver.CheckoutProcess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.webdriver.Cart.ShoppingCart;
import com.webdriver.SetupData.MappingData;

public class ProceedCheckout extends MappingData {

	WebDriver driver = null;

	ShoppingCart checkout = null;

	public ProceedCheckout(WebDriver driver, ShoppingCart checkout) {
		this.driver = driver;
		this.checkout = checkout;
	}

	public ProceedCheckout ProceedNext() {
		checkout.ProceedCheckout(By.id(getidentifier("cart.id.checkoutform")),
				By.className(getidentifier("cart.class.proceedcheckout")));
		return this;
	}

}
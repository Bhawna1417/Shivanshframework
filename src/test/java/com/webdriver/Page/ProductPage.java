package com.webdriver.Page;

import org.openqa.selenium.WebDriver;

public class ProductPage {
	public static void OpenProductDetailPage(WebDriver driver, String string)
			throws Exception {
		driver.get(string);
	}
}

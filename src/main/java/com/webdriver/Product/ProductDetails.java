package com.webdriver.Product;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.Library.WebDriverHelpers;
import com.webdriver.UtilSection.GetRandom;

public class ProductDetails {
	WebDriver driver = null;

	Product product = new Product();
	
	int filledquantity = 0;

	public int getFilledquantity() {
		return filledquantity;
	}

	public void setFilledquantity(int filledquantity) {
		this.filledquantity = filledquantity;
	}

	public ProductDetails(WebDriver driver) {
		this.driver = driver;
		this.filledquantity = 0;
	}

	public ProductDetails RetrieveProductID(By locator) {
		WebElement element = driver.findElement(locator);

		if (element != null) {
			String[] temp = element.getText().split("# ");
			product.addproductid(temp[temp.length - 1]);
		}
		return this;
	}

	public ProductDetails RetrieveProductName(By locator) {
		WebElement element = driver.findElement(locator);

		if (element != null) {
			product.addproductname(element.getText());
		}
		return this;
	}

	public ProductDetails RetrieveProductNameEng(By locator) {
		WebElement element = driver.findElement(locator);

		if (element != null) {
			product.addproductnameeng(element.getText());
		}
		return this;
	}

	public ProductDetails RetrieveProductStock(By locator) {
		WebElement element = driver.findElement(locator);

		if (element != null) {
			String temp = element.getText();

			String number = temp.replaceAll("[^0-9]", "");
			product.addproductstockcurrent(Integer.parseInt(number));
		}

		return this;
	}

	public ProductDetails RetrieveProductCategoryName(By locator) {
		WebElement element = driver.findElement(locator);

		if (element != null) {
			product.addproductcategoryname(element.getText());
		}
		return this;
	}

	public ProductDetails RetrieveProductCost(By locator) {
		WebElement element = driver.findElement(locator);

		if (element != null) {
			String temp = element.getText();

			String number = temp.replaceAll("[^0-9]", "");
			product.addproductcost(Integer.parseInt(number));
		}
		return this;
	}

	public ProductDetails RetrieveProductQuantity(By locator) {
		WebElement element = driver.findElement(locator);

		if (element != null) {
			String temp = element.getText();

			product.addproductquantity(Integer.parseInt(temp));
		}
		return this;
	}

	public ProductDetails ClickAddtoCart(By locator) {
		WebElement element = driver.findElement(locator);
		if (element != null) {
			element.click();
		}

		return this;
	}

	public ProductDetails ClickOpenCalendar(By locator) {
		WebElement element = driver.findElement(locator);
		if (element != null) {
			element.click();
		}

		return this;
	}
	
	public ProductDetails ClickSelectDate(By locator) {
		WebElement element = driver.findElement(locator);
		if (element != null) {
			element.click();
		}

		return this;
	}
	
	public ProductDetails ClickPreviousMonth(By locator) {
		WebElement element = driver.findElement(locator);
		if (element != null) {
			element.click();
		}

		return this;
	}
	
	public ProductDetails ClickNextMonth(By locator) {
		WebElement element = driver.findElement(locator);
		if (element != null) {
			element.click();
		}

		return this;
	}

	public ProductDetails ClickIncreaseQuantity(By locator, int value)
			throws Exception {
		int addquantity = GetRandom.value(
				product.getproductstockcurrent(value), 0);

		for (int i = 1; i <= addquantity; i++) {
			WebElement element = driver.findElement(locator);
			if (element != null) {
				element.click();
			}
		}

		return this;
	}

	public ProductDetails ClickDecreaseQuantity(By locator, int value)
			throws Exception {
		int removequantity = GetRandom.value(
				product.getproductstockcurrent(value), 0);

		for (int i = 1; i <= removequantity; i++) {
			WebElement element = driver.findElement(locator);
			if (element != null) {
				element.click();
			}
		}

		return this;
	}

	public ProductDetails FillDesiredQuantity(By locator, int value)
			throws Exception {
		// int desiredquantity =
		// GetRandom.value(product.getproductstockcurrent(value),
		// 0);

		filledquantity = value;
		
		String fillquantity = Integer.toString(filledquantity);

		WebElement element = driver.findElement(locator);
		if (element != null) {
			element.clear();
			element.sendKeys(Keys.chord(Keys.BACK_SPACE),fillquantity);
		}

		return this;
	}

	public ProductDetails ClickAddtoWishlist(By locator) {
		WebElement element = driver.findElement(locator);
		if (element != null) {
			element.click();
		}

		return this;
	}

	public ProductDetails SelectQuantity(By by) throws Exception {
		WebElement element = driver.findElement(by);

		if (element != null) {
			if (element.isEnabled()) {
				WebDriverHelpers.SelectFromDropDown(driver, by);
			}
		}

		return this;
	}
}

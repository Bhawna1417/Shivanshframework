package com.webdriver.Page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.OrderHistory.OrderDetails;
import com.webdriver.Product.ConfirmationPopup;
import com.webdriver.SetupData.MappingData;
import com.webdriver.UtilSection.CheckElementDisplay;

public class OrderDetailsPage extends MappingData {
	WebDriver driver = null;
	ArrayList<WebElement> productrowelement = new ArrayList<WebElement>();

	public OrderDetailsPage(WebDriver driver) {
		this.driver = driver;
		this.productrowelement.clear();
	}

	public OrderDetailsPage OpenOrderHistory(String url) {
		driver.get(url + "/my-account/order-history");
		return this;
	}

	public OrderDetailsPage VerifyCurrentOrder(OrderDetails details) {
		details.CollectOrderNumber(By
				.className(getidentifier("order.class.orderno")));
		details.CollectOrderDate(By
				.className(getidentifier("order.class.date")));
		details.CollectPaymentMethod(By
				.className(getidentifier("order.class.payment")));

		boolean checkdiscountdisplayed = CheckElementDisplay.isElementDisplay(
				By.className(getidentifier("order.class.discountvalue")),
				driver);

		for (int i = 0; i < productrowelement.size(); i++) {
			details.SetRowElement(productrowelement.get(i));
			details.CollectProductNames(
					By.className(getidentifier("order.class.details")),
					By.className(getidentifier("order.class.name")));
			details.CollectProductEngNames(
					By.className(getidentifier("order.class.details")),
					By.className(getidentifier("order.class.en-name")));
			details.CollectProductID(
					By.className(getidentifier("order.class.details")),
					By.className(getidentifier("order.class.id")));
//			details.CollectProductQuantity(
//					By.className(getidentifier("order.class.quantity")),
//					By.className(getidentifier("order.class.addedquantity")));

			WebElement element = productrowelement
					.get(i)
					.findElement(
							By.className(getidentifier("order.class.price")))
					.findElement(
							By.className(getidentifier("order.class.panel")));

			if (checkdiscountdisplayed) {

				details.CollectProductOriginalPrice(element,
						By.className(getidentifier("order.class.original")));
				details.CollectProductDiscountPrice(element, By
						.className(getidentifier("order.class.discountvalue")));
				details.CollectProductAfterDiscountPrice(element,
						By.className(getidentifier("order.class.newprice")));

				details.CollectProductDiscountUnitPrice(element, By
						.className(getidentifier("order.class.original")), By
						.className(getidentifier("order.class.discountvalue")),
						By.className(getidentifier("order.class.newprice")));
			} else {
				details.CollectProductAfterDiscountPrice(element,
						By.className(getidentifier("order.class.newprice")));

			}
			details.CollectProductTotalPrice(
					By.className(getidentifier("order.class.itemprice")),
					By.className(getidentifier("order.class.totalprice")));
		}

		// order.CollectCheckoutAmount(By.xpath("//table[@id = '"
		// + getidentifier("order.id.ordertotal")
		// + "']/thead/tr/td[2]/span[@class = '"
		// + getidentifier("order.class.ordertotal") + "']"));

		WebElement ordertotal = driver.findElement(By
				.id(getidentifier("order.id.ordertotal")));

		details.CollectCheckoutAmount(ordertotal,
				By.id(getidentifier("order.id.checkouttotal")));

		if (checkdiscountdisplayed) {

			details.CollectOriginalAmount(ordertotal,
					By.id(getidentifier("order.id.totaloriginal")));

			details.CollectDiscountAmount(ordertotal,
					By.id(getidentifier("order.id.totaloriginal")));

			details.CollectSubTotalAmount(ordertotal,
					By.id(getidentifier("order.id.subtotal")));
		}
		// order.CollectDiscount(By.xpath("//table[@id = '"
		// + getidentifier("order.id.ordertotal")
		// + "']/tbody/tr[2]/td[2]"));

		details.CollectCosigneeName(By.xpath("//div[contains(@class, '"
				+ getidentifier("order.class.address")
				+ "')]/ul/li[1]/div/div[2]"));

		details.CollectMobile1(By.xpath("//div[contains(@class, '"
				+ getidentifier("order.class.address")
				+ "')]/ul/li[2]/div[1]/div[2]"));

		details.CollectMobile2(By.xpath("//div[contains(@class, '"
				+ getidentifier("order.class.address")
				+ "')]/ul/li[2]/div[2]/div[2]"));

		details.CollectShippingAddress(By.xpath("//div[contains(@class, '"
				+ getidentifier("order.class.address")
				+ "')]/ul/li[3]/div/div[2]"));

		return this;
	}

	public OrderDetailsPage OpenCurrentOrder(int number, String url) throws InterruptedException {
		driver.get(url + "/view/secured/content/myaccount?orderCode=" + number);
		Thread.sleep(30000);
		GetProductsList();
		return this;
	}

	public OrderDetailsPage GetProductsList() {
		WebElement element = driver.findElement(By
				.className(getidentifier("order.class.cartlist")));

		List<WebElement> productslist = element.findElements(By
				.className(getidentifier("order.class.product")));

		if (!productslist.isEmpty()) {
			for (WebElement ele : productslist) {
				productrowelement.add(ele.findElement(By
						.className(getidentifier("order.class.productline"))));
			}
		}

		return this;
	}

	public OrderDetailsPage CancelCurrentOrder(ConfirmationPopup confirmpopup) {
		if (CheckElementDisplay.isElementDisplay(
				By.id(getidentifier("history.id.oredercancel")), driver)) {
			WebElement element = driver.findElement(By
					.id(getidentifier("history.id.oredercancel")));
			if (element != null) {
				element.click();
			}
		}

		boolean check = CheckElementDisplay.isElementDisplay(
				By.id(getidentifier("history.popup.id.box")), driver);

		System.out.println("Popup displayed " + check);

		if (check) {
			confirmpopup.ClickCancelOrder(
					By.id(getidentifier("history.popup.id.box")),
					By.id(getidentifier("history.id.cancelpopup")),
					By.tagName("button"));
		}
		return this;
	}
}
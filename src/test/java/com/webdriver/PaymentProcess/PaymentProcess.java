package com.webdriver.PaymentProcess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.Payment.PaymentDetails;
import com.webdriver.SetupData.MappingData;

public class PaymentProcess extends MappingData {
	WebDriver driver = null;

	public PaymentProcess(WebDriver driver) {
		this.driver = driver;
	}

	public PaymentProcess Payment(PaymentDetails payment) throws Exception {

		CheckOrderSummaryPagetoProceed();

		payment.SelectPaymentType(
				By.id(getidentifier("checkout.id.paymenttype")), "001");

		payment.FillPaymentCard(By.id(getidentifier("checkout.id.paymentcard")));

		payment.FillCardHolderName(By
				.id(getidentifier("checkout.id.paymentuser")));

		payment.SelectCardExpiryMonth(By
				.id(getidentifier("checkout.id.paymentcardmonth")));

		payment.SelectCardExpiryYear(By
				.id(getidentifier("checkout.id.paymentcardyear")));

		payment.FillCardCVV(By.id(getidentifier("checkout.id.paymentcardcvv")));

		payment.ClickSubmit(By.tagName("button"));

		return this;
	}

	public PaymentProcess CheckOrderSummaryPagetoProceed() {
		String title = driver.getTitle();

		if (title.toLowerCase().contains("order summary")) {
			WebElement element = driver.findElement(By
					.id(getidentifier("checkout.id.ordersummary")));

			if (element != null) {
				element.click();
			}
		}

		return this;
	}
}
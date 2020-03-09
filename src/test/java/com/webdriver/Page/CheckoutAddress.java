package com.webdriver.Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.SetupData.MappingData;
import com.webdriver.UtilSection.CheckElementDisplay;
import com.webdriver.UtilSection.GetRandom;
import com.webdriver.MyAccount.AddNewAddress;

public class CheckoutAddress extends MappingData {
	WebDriver driver = null;

	boolean existingaddress = false;

	public CheckoutAddress(WebDriver driver) {
		this.driver = driver;
	}

	public CheckoutAddress CheckAddNewAddress(boolean addnew) throws Exception {

		CheckForExistingAddress();

		if (addnew || !existingaddress) {
			AddNewAddress();
		} else {
			UseAddress();
		}

		return this;
	}

	private void UseAddress() throws Exception {

		WebElement element = driver.findElement(By
				.id(getidentifier("useaddress.id.addresssection")));

		if (element != null) {

			List<WebElement> existingaddresses = element.findElements(By
					.id(getidentifier("useaddress.id.addresses")));

			if (!existingaddresses.isEmpty()) {
				existingaddresses
						.get(GetRandom.value(existingaddresses.size(), -1))
						.findElement(
								By.id(getidentifier("useaddress.id.select")))
						.click();
			}

			// for (WebElement ele : existingaddresses) {
			// ele.findElement(By.id(getidentifier("useaddress.id.select")))
			// .click();
			// }
		} else {
			throw new RuntimeException("address section is missing");
		}

	}

	private void AddNewAddress() throws Exception {
		WebElement element = driver.findElement(By
				.id(getidentifier("address.id.formsection")));

		if (element != null) {
			FillAddress(driver, element);
		}
	}

	public CheckoutAddress CheckForExistingAddress() {

		if (CheckElementDisplay.isElementNotDisplay(
				By.className(getidentifier("address.class.noaddressmsg")),
				driver)) {
			existingaddress = true;
		}

		return this;
	}

	public CheckoutAddress FillAddress(WebDriver driver, WebElement ele)
			throws Exception {

		AddNewAddress address = new AddNewAddress(driver, ele);

		address.DeliveryAddressManualEntry(
				By.id(getidentifier("address.id.findaddresssection")),
				By.id(getidentifier("address.id.formmanual")));

		address.DeliveryAddressName(By
				.id(getidentifier("address.id.formaddressname")));

		address.DeliveryAddressTitle(By
				.id(getidentifier("address.id.formtitle")));

		address.DeliveryAddressFirstName(By
				.id(getidentifier("address.id.formfirstname")));

		address.DeliveryAddressLastName(By
				.id(getidentifier("address.id.formlastname")));

		address.DeliveryAddressMobile(By
				.id(getidentifier("address.id.formphone")));

		address.DeliveryAddressCompanyName(By
				.id(getidentifier("address.id.formcompany")));

		address.DeliveryAddressHouseNo(By
				.id(getidentifier("address.id.formhouseno")));

		address.DeliveryAddressCountry(By
				.id(getidentifier("address.id.formcountry")));

		address.DeliveryAddressStreet(By
				.id(getidentifier("address.id.formstreet")));

		address.DeliveryAddressTown(By.id(getidentifier("address.id.formtown")));

		address.DeliveryAddressCounty(By
				.id(getidentifier("address.id.formcounty")));

		address.DeliveryAddressPostCode(By
				.id(getidentifier("address.id.formpostcode")));

		address.DeliveryAddressCheckout(By
				.id(getidentifier("address.id.formsave")));

		return this;
	}
}

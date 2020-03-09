package com.webdriver.TestCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.webdriver.CalendarSelection.PreferredDeliveryDateSelection;
import com.webdriver.Cart.ShoppingCart;
import com.webdriver.CheckoutProcess.AddBasket;
import com.webdriver.CheckoutProcess.ProceedCheckout;
import com.webdriver.Data.DataSetCollectors;
import com.webdriver.Data.ProductValues;
import com.webdriver.OrderConfirm.OrderConfirm;
import com.webdriver.Page.CartPage;
import com.webdriver.Page.CheckoutAddress;
import com.webdriver.Page.OrderConfirmationPage;
import com.webdriver.Page.RegistrationPage;
import com.webdriver.Payment.PaymentDetails;
import com.webdriver.PaymentProcess.PaymentProcess;
import com.webdriver.Product.ProductDetails;
import com.webdriver.Registration.Register;
import com.webdriver.TestCaseBase.AkeoSanityTestBase;

public class TC01 extends AkeoSanityTestBase {

	static Logger logTC_01 = Logger.getLogger(TC01.class);

	@Test(description = "Checkout Journey with registration process & multiple products added with multiple quantities"
			+ " creating new address.")
	public static void TestCase1() throws Exception {

		WebDriver driver = getDriver();
		String baseurl = getBaseUrl();
		DataSetCollectors data = getDataset();

		// Login login = new Login(driver, data);
		Register register = new Register(driver, data);
		ProductDetails product = new ProductDetails(driver);
		ProductValues prod = new ProductValues(getUserdir());
		PreferredDeliveryDateSelection preferred = new PreferredDeliveryDateSelection(
				driver);
		AddBasket addbasket = new AddBasket(driver, prod, product, preferred,
				data, baseurl);
		CartPage cart = new CartPage(driver);
		ShoppingCart checkout = new ShoppingCart(driver);
		ProceedCheckout proceed = new ProceedCheckout(driver, checkout);
		CheckoutAddress add = new CheckoutAddress(driver);
		PaymentDetails payment = new PaymentDetails(driver);
		PaymentProcess pay = new PaymentProcess(driver);
		OrderConfirmationPage confirmation = new OrderConfirmationPage(driver);
		OrderConfirm confirm = new OrderConfirm(driver);
		// OrderDetailsPage orderhistory = new OrderDetailsPage(driver);
		// OrderDetails history = new OrderDetails(driver);

		RegistrationPage.OpenRegistrationPage(driver, baseurl);

		register.FillForm().ClickSubmit();

		// login.FillLogin().ClickSubmit();

		// 0 - Products
		// 1 - Tires
		// 2 - Premium Services
		// 3 - Tires + Products

		addbasket.DetailPageSelectAddProduct(0).AddtoBasket()
				.CheckProductAdded().Proceed();

		cart.CheckOpenCartPage(baseurl);

		proceed.ProceedNext();

		add.CheckAddNewAddress(true);

		pay.Payment(payment);

		confirmation.CheckOrderDisplayed().OrderDetails(confirm);

		// orderhistory.OpenCurrentOrder(
		// // confirmation.getOrderno(),
		// 20083134,
		// baseurl)
		// .VerifyCurrentOrder(history);

	}

}

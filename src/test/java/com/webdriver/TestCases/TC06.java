package com.webdriver.TestCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.webdriver.Data.DataSetCollectors;
import com.webdriver.Data.ProductValues;
import com.webdriver.Login.Login;
import com.webdriver.Page.ProductPage;
import com.webdriver.Page.RegistrationPage;
import com.webdriver.TestCaseBase.AkeoSanityTestBase;
import com.webdriver.UtilSection.GetRandom;
import com.webdriver.WishListSection.WishListOperations;

public class TC06 extends AkeoSanityTestBase {

	static Logger logTC_06 = Logger.getLogger(TC06.class);

	@Test(description = "Verification of Wishlist workflow")
	public static void TestCase6() throws Exception {
		WebDriver driver = getDriver();
		String baseurl = getBaseUrl();
		DataSetCollectors data = getDataset();

		Login login = new Login(driver, data);
		ProductValues prod = new ProductValues(getUserdir());
		WishListOperations wishlist = new WishListOperations(driver);

		RegistrationPage.OpenRegistrationPage(driver, baseurl);

		login.FillLogin().ClickSubmit();

		for (int i = 1; i <= GetRandom.value(prod.sizeproducturls(), 0); i++) {

			ProductPage.OpenProductDetailPage(driver, prod.getProducturls()
					.get(GetRandom.value(prod.sizeproducturls(), 0)));
			wishlist.AddProduct();
		}
	}
}
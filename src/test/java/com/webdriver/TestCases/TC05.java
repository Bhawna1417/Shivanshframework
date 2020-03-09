package com.webdriver.TestCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.webdriver.Data.DataSetCollectors;
import com.webdriver.Login.Login;
import com.webdriver.Page.MyAccountPage;
import com.webdriver.Page.RegistrationPage;
import com.webdriver.TestCaseBase.AkeoSanityTestBase;

public class TC05 extends AkeoSanityTestBase {

	static Logger logTC_05 = Logger.getLogger(TC05.class);

	@Test(description = "Verification of My Account Components")
	public static void TestCase5() throws Exception {
		WebDriver driver = getDriver();
		String baseurl = getBaseUrl();
		DataSetCollectors data = getDataset();

		Login login = new Login(driver, data);
		MyAccountPage myacc = new MyAccountPage(driver, data);

		RegistrationPage.OpenRegistrationPage(driver, baseurl);

		login.FillLogin().ClickSubmit();

		myacc.OpenMyAccountPage(baseurl).MyAccountElements();
		myacc.MyAccountSections();
	}
}
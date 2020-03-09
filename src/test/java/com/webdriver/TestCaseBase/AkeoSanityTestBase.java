package com.webdriver.TestCaseBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.webdriver.Data.DataSetCollectors;
import com.webdriver.Library.TestContext;
import com.webdriver.Library.WebDriverUtils;
import com.webdriver.Mail.SendMailAfterExecution;
import com.webdriver.SetupData.MappingData;
import com.webdriver.SetupProperties.SetProperty;

public class AkeoSanityTestBase extends SetProperty {
	protected static Logger logMain = Logger.getLogger(AkeoSanityTestBase.class);

	private static String userdir = System.getProperty("user.dir");

	protected static DataSetCollectors dataset = new DataSetCollectors();

	protected static TestContext testContext;
	
	protected static WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		//setDriver(new FirefoxDriver());
		
		setDriver(testContext.driver());
		
		getDriver().manage()
		.timeouts()
		.implicitlyWait(WebDriverUtils.DEFAULT_TIMEOUT_IN_SECONDS,
				TimeUnit.SECONDS);
		
		//getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// getDrivermain().manage().timeouts().pageLoadTimeout(30,
		// TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		getDriver().get(baseUrl());
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		getDriver().quit();
	}

	@BeforeSuite(alwaysRun = true)
	public void testBeforeSuite() throws Exception {
		System.out.println("testBeforeSuite()");
		MappingData.PropertiesDataCollector(userdir, logMain);
		// DataSetCollectors dataset = new DataSetCollectors();
		dataset.GetUserNamesFromDataSet()
				.GetPasswordsFromDataSet()
				// .GetCosgineeNamesFromList()
				// .GetAliasNamesFromList()
				// .GetAddressLine1FromList()
				// .GetAddressLine2FromList()
				.GetMaxProductFromDataSet()
				.GetMaxQuantityFromDataSet()
				.GetMobileNumberFromDataSet()
				// .GetOtherNumberFromList()
				.GetEmailRecipientsFromDataSet()
				.GetRegistrationEmail1FromDataSet()
				.GetRegistrationEmail2FromDataSet().GetFirstNamesFromDataSet()
				.GetLastNamesFromDataSet().GetRegistrationPasswordFromDataSet()
				.GetVehicleRegistrationNumbersFromDataSet()
				.GetSearchTermsFromDataSet();
	}

	@AfterSuite(alwaysRun = true)
	public void testAfterSuite() throws Exception {
		System.out.println("testAfterSuite()");
		 SendMailAfterExecution.SendMailAfterSuiteExecution(getUserdir(),
		 getDataset());
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		AkeoSanityTestBase.driver = driver;
	}

	public static String getUserdir() {
		return userdir;
	}

	public static String getBaseUrl() {
		return baseUrl();
	}

	public static DataSetCollectors getDataset() {
		return dataset;
	}
}

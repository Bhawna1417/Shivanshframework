package com.webdriver.AkeoSanity;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import com.webdriver.Library.TestContext;

public class Tech {
	protected static WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	protected static TestContext testContext;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		// System.setProperty("webdriver.gecko.driver",
		// System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		// driver = new FirefoxDriver();
		testContext.driver();
		//driver = testContext.driver();
		setBaseUrl("https://akeo.tech/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testTech() throws Exception {
		driver.get(getBaseUrl());
		driver.findElement(By.id("logo")).click();
		driver.findElement(By.linkText("GOT IT")).click();
		driver.findElement(By.id("contact_us_top_fold")).click();
		driver.findElement(By.id("etj_pb_contact_first_0")).click();
		driver.findElement(By.id("et_pb_contact_first_0")).clear();
		driver.findElement(By.id("et_pb_contact_first_0")).sendKeys("first");
		driver.findElement(By.id("et_pb_contact_last_0")).click();
		driver.findElement(By.id("et_pb_contact_last_0")).clear();
		driver.findElement(By.id("et_pb_contact_last_0")).sendKeys("last");
		driver.findElement(By.id("et_pb_contact_email_0")).click();
		driver.findElement(By.id("et_pb_contact_email_0")).click();
		driver.findElement(By.id("et_pb_contact_email_0")).clear();
		driver.findElement(By.id("et_pb_contact_email_0")).sendKeys(
				"test@test.com");
		driver.findElement(By.id("et_pb_contact_phone_0")).click();
		driver.findElement(By.id("et_pb_contact_phone_0")).clear();
		driver.findElement(By.id("et_pb_contact_phone_0")).sendKeys(
				"1234567890");
		driver.findElement(By.id("et_pb_contact_message_0")).click();
		driver.findElement(By.id("et_pb_contact_message_0")).clear();
		driver.findElement(By.id("et_pb_contact_message_0")).sendKeys(
				"test message");
		String submit = driver
				.findElement(
						By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Message'])[1]/following::button[1]"))
				.getAttribute("value");

		System.out.println(submit);
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Send Message'])[1]/following::div[3]"))
				.click();
		assertEquals(driver.getTitle(), "Contact Us - Akeo");
		driver.findElement(By.id("logo")).click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Contact us'])[1]/following::div[1]"))
				.click();
		assertEquals(driver.getTitle(),
				"Akeo | Fintech & Blockchain Consultancy | Concept & Software Development");
		assertEquals(driver.getTitle(),
				"Akeo | Fintech & Blockchain Consultancy | Concept & Software Development");
		assertEquals(driver.getTitle(),
				"Akeo | Fintech & Blockchain Consultancy | Concept & Software Development");
		assertEquals(
				driver.findElement(
						By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Early Prototype'])[1]/following::div[1]"))
						.getText(),
				"Build an early prototype (proof of concept) to test your idea with customers and stakeholders. Then we design and build your technical platform based on what is working.");
		driver.findElement(By.linkText("read more")).click();
		driver.findElement(By.linkText("Yogesh Rawal")).click();
		driver.findElement(By.id("logo")).click();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
}

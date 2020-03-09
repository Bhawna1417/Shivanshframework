package com.webdriver.Library;

import java.util.Locale;
import java.util.Properties;

import org.apache.commons.lang3.Validate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class TestContext {
	private WebDriver driver;

	private String httpServerBaseUrl;
	private String httpsServerBaseUrl;

	private String drivertype = "chrome";

	public TestContext() {
	}

	public TestContext(final Properties properties) {
		Validate.notNull(properties);

		httpServerBaseUrl = properties.getProperty("http.server.baseUrl");
		httpsServerBaseUrl = properties.getProperty("https.server.baseUrl");

		final String strCloseWebDriverOnShutdown = System
				.getProperty("tests.closeWebDriverOnShutdown");
		if (!"false".equals(strCloseWebDriverOnShutdown)) {
			registerWebDriverCloseShutdownHook();
		}
	}

	private void registerWebDriverCloseShutdownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				if (driver != null) {
					driver.close();
				}
			}
		});
	}

	public WebDriver driver() {
		if (driver == null) {

			if (drivertype == "firefox") {
				driver = firefoxDriver();
			}
			
			if (drivertype == "chrome") {
				driver = chromeDriver();
			}
			
			if (drivertype == "safari") {
				driver = safariDriver();
			}
			
			if (drivertype == "ie11") {
				driver = internetExplorerDriver();
			}
			
		}
		return driver;
	}

	private InternetExplorerDriver internetExplorerDriver() {
		return internetExplorerDriver(Locale.ENGLISH);
	}

	private InternetExplorerDriver internetExplorerDriver(final Locale locale) {
		final InternetExplorerOptions options = new InternetExplorerOptions();
		options.setCapability("intl.accept_languages",
				internetExplorerlocalestring(locale));

		return new InternetExplorerDriver(options);
	}

	private String internetExplorerlocalestring(final Locale locale) {
		return locale.getCountry().length() == 0 ? locale.getLanguage()
				: locale.getLanguage() + "-"
						+ locale.getCountry().toLowerCase();
	}

	private SafariDriver safariDriver() {
		return safariDriver(Locale.ENGLISH);
	}

	private SafariDriver safariDriver(final Locale locale) {
		final SafariOptions options = new SafariOptions();
		options.setCapability("intl.accept_languages",
				safariLocaleString(locale));

		return new SafariDriver(options);
	}

	private String safariLocaleString(final Locale locale) {
		return locale.getCountry().length() == 0 ? locale.getLanguage()
				: locale.getLanguage() + "-"
						+ locale.getCountry().toLowerCase();
	}

	private ChromeDriver chromeDriver() {
		return chromeDriver(Locale.ENGLISH);
	}

	private ChromeDriver chromeDriver(final Locale locale) {
		final ChromeOptions options = new ChromeOptions();
		options.setCapability("intl.accept_languages",
				chromeLocaleString(locale));
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		return new ChromeDriver(options);
	}

	private String chromeLocaleString(final Locale locale) {
		return locale.getCountry().length() == 0 ? locale.getLanguage()
				: locale.getLanguage() + "-"
						+ locale.getCountry().toLowerCase();
	}

	private FirefoxDriver firefoxDriver() {
		return firefoxDriver(Locale.ENGLISH);
	}

	private FirefoxDriver firefoxDriver(final Locale locale) {
		final FirefoxOptions options = new FirefoxOptions();
		// FirefoxProfile profile = new FirefoxProfile();
		options.addPreference("intl.accept_languages",
				firefoxLocaleString(locale));

		return new FirefoxDriver(options);
	}

	private String firefoxLocaleString(final Locale locale) {
		return locale.getCountry().length() == 0 ? locale.getLanguage()
				: locale.getLanguage() + "-"
						+ locale.getCountry().toLowerCase();
	}

	public String httpServerBaseUrl() {
		return httpServerBaseUrl;
	}

	public String httpsServerBaseUrl() {
		return httpServerBaseUrl;
	}

	public String fullUrl(final String url, boolean isSecure) {
		if (isSecure) {
			return httpsServerBaseUrl + url;
		} else {
			return httpServerBaseUrl + url;
		}
	}
}

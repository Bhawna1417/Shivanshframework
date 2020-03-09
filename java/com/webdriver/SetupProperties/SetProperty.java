package com.webdriver.SetupProperties;

import java.util.Locale;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.webdriver.TestCaseBase.URLLoader;

public class SetProperty {

	protected FirefoxDriver firefoxDriver() {
		return firefoxDriver(Locale.ENGLISH);
	}

	private FirefoxDriver firefoxDriver(final Locale locale) {
		final FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("intl.accept_languages",
				firefoxLocaleString(locale));

		return new FirefoxDriver(profile);
	}

	private String firefoxLocaleString(final Locale locale) {
		return locale.getCountry().length() == 0 ? locale.getLanguage()
				: locale.getLanguage() + "-"
						+ locale.getCountry().toLowerCase();
	}

	protected static String baseUrl() {
		return baseUrl("https.server.baseurl");
	}

	private static String baseUrl(String string) {
		return URLLoader.baseUrl(string);
	}
}

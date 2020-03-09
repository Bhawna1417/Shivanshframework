package com.webdriver.Library;

import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class WebDriverUtils {
	public static final long DEFAULT_TIMEOUT_IN_SECONDS = 5L;

	private WebDriverUtils() {
	}

	public static WebDriverWait webDriverWait(final WebDriver driver) {
		return webDriverWait(driver, DEFAULT_TIMEOUT_IN_SECONDS);
	}

	public static WebDriverWait webDriverWait(final WebDriver driver,
			final long timeoutInSeconds) {
		return new WebDriverWait(driver, timeoutInSeconds);
	}

	public static void waitUntilElementIsDisplay(WebDriver driver, By element) {
		waitUntilElementIsDisplay(driver, element,
				driver.findElement(By.id("wrap")));
	}

	public static void waitUntilElementIsNotDisplay(final WebDriver driver,
			final By element, final WebElement root) {
		WebDriverUtils.webDriverWait(driver).until(new Function<WebDriver, Boolean>() {
			public Boolean apply(final WebDriver input) {
				return root.findElements(element).isEmpty();
			}
		});
	}

	public static void waitUntilElementIsDisplay(final WebDriver driver,
			final By element, final WebElement root) {
		WebDriverUtils.webDriverWait(driver).until(new Function<WebDriver, Boolean>() {
			public Boolean apply(final WebDriver input) {
				try {
					return !root.findElements(element).isEmpty();
				} catch (StaleElementReferenceException e) {
					return false;
				}
			}
		});
	}

	public static void clickSelectOptionByText(final WebElement select,
			final String optionText) {
		boolean found = false;

		final List<WebElement> options = select.findElements(By
				.tagName("option"));
		for (final WebElement option : options) {
			if (optionText.equalsIgnoreCase(option.getText())) {
				found = true;
				option.click();
				break;
			}
		}

		if (!found) {
			throw new IllegalArgumentException("Unknown option: " + optionText
					+ ", currently contains: "
					+ select.findElements(By.tagName("option")));
		}
	}

	public static String selectText(final WebElement select) {
		int count = 0;
		while (count < 4) {
			try {
				final List<WebElement> options = select.findElements(By
						.tagName("option"));
				for (final WebElement option : options) {
					if (option.isSelected()) {
						return option.getText();
					}
				}
			} catch (StaleElementReferenceException e) {
				System.out.println("Trying to recover from a stale element :"
						+ e.getMessage());
				count = count + 1;
			}
			count = count + 4;
		}

		return null;
	}

	public static String getSrcAttributeForOptionalWebElement(
			final WebDriver driver, final By by) {
		final List<WebElement> elts = driver.findElements(by);
		return elts.isEmpty() ? null : elts.get(0).getAttribute("src");
	}

	public static String getTextForOptionalWebElement(final WebDriver driver,
			final By by) {
		final List<WebElement> elts = driver.findElements(by);
		return elts.isEmpty() ? null : elts.get(0).getText();
	}

	public static String getTextForOptionalWebElement(
			final WebElement rootElement, final By by) {
		final List<WebElement> elts = rootElement.findElements(by);
		return elts.isEmpty() ? null : elts.get(0).getText();
	}
}

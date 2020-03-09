package com.webdriver.Library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdriver.UtilSection.GetRandom;

public class WebDriverHelpers {
	public static final long DEFAULT_TIMEOUT_IN_SECONDS = 15L;

	private WebDriverHelpers() {
	}

	public static WebDriverWait webDriverWait(final WebDriver driver) {
		return webDriverWait(driver, DEFAULT_TIMEOUT_IN_SECONDS);
	}

	public static WebDriverWait webDriverWait(final WebDriver driver,
			final long timeoutInSeconds) {
		return new WebDriverWait(driver, timeoutInSeconds);
	}

	public static void waitUntilElementIsNotDisplay(WebDriver driver, By by) {
		WebDriverHelpers.webDriverWait(driver).until(
				ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public static void waitUntilElementIsDisplay(WebDriver driver, By by) {
		WebDriverHelpers.webDriverWait(driver).until(
				ExpectedConditions.not(ExpectedConditions
						.invisibilityOfElementLocated(by)));
	}

	public static void waitUntilElementIsClickable(WebDriver driver, By by) {
		waitUntilElementIsClickable(driver, driver.findElement(by));
	}

	public static void waitUntilElementIsClickable(WebDriver driver,
			WebElement element) {
		WebDriverHelpers.webDriverWait(driver).until(
				ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitUntilElementIsSelected(WebDriver driver, By by) {
		waitUntilElementIsSelected(driver, driver.findElement(by));
	}

	public static void waitUntilElementIsSelected(WebDriver driver,
			WebElement element) {
		WebDriverHelpers.webDriverWait(driver).until(
				ExpectedConditions.elementToBeSelected(element));
	}

	public static void waitUntilElementIsPresent(WebDriver driver, By by) {
		WebDriverHelpers.webDriverWait(driver).until(
				ExpectedConditions.presenceOfElementLocated(by));
	}

	public static void waitUntilElementIsPresentVisible(WebDriver driver, By by) {
		WebDriverHelpers.webDriverWait(driver).until(
				ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static void SelectFromDropDown(WebDriver driver, By by)
			throws Exception {
		WebElement element = driver.findElement(by);

		Select select = new Select(element);

		List<WebElement> allOptions = select.getOptions();

		int len = allOptions.size();

		if (len != 1) {
			select.selectByIndex(GetRandom.value(len, 0));
		}
	}

	public static void SelectFromDropDown(WebElement ele, By by)
			throws Exception {
		WebElement element = ele.findElement(by);

		Select select = new Select(element);

		List<WebElement> allOptions = select.getOptions();

		int len = allOptions.size();

		if (len != 1) {
			select.selectByIndex(GetRandom.value(len, 0));
		}
	}

	public static String GetSelectedTextDropdown(WebDriver driver, By by)
			throws Exception {
		WebElement element = driver.findElement(by);
		String selectedtext = null;

		Select select = new Select(element);

		List<WebElement> allOptions = select.getOptions();

		for (WebElement opt : allOptions) {
			if (opt.isSelected()) {
				selectedtext = opt.getText();
			}
		}

		return selectedtext;

	}

	public static String GetSelectedTextDropdown(WebElement elem, By by)
			throws Exception {
		WebElement element = elem.findElement(by);
		String selectedtext = null;

		Select select = new Select(element);

		List<WebElement> allOptions = select.getOptions();

		for (WebElement opt : allOptions) {
			if (opt.isSelected()) {
				selectedtext = opt.getText();
			}
		}

		return selectedtext;

	}

	public static String GetSelectedValueDropdown(WebDriver driver, By by)
			throws Exception {
		WebElement element = driver.findElement(by);

		Select select = new Select(element);

		return select.getFirstSelectedOption().getAttribute("value");
	}

	public static boolean CheckFilled(By by) {

		return false;
	}

	public static boolean CheckSelected(WebDriver driver, By by) {
		WebElement element = driver.findElement(by);
		Select select = new Select(element);
		if (select.getFirstSelectedOption() != null) {

		}
		return false;
	}

	public static String getTextForOptionalWebElement(final WebDriver driver,
			final By by) {
		String string = null;
		final List<WebElement> elts = driver.findElements(by);
		for (WebElement ele : elts) {
			if (ele != null) {
				if (ele.isDisplayed()) {
					string = ele.getText();
				}
			}
		}
		return string;
	}
}
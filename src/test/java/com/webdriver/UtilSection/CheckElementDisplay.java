package com.webdriver.UtilSection;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckElementDisplay {

	public static boolean isElementDisplay(By locator, WebDriver driver) {

		try {
			WebElement myElement = driver.findElement(locator);

			return myElement.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}// isElementDisplay close

	public static boolean isElementDisplay(By locator, WebElement element,
			WebDriver driver) {
		turnOffImplicitlyWait(driver);

		try {
			WebElement myElement = element.findElement(locator);

			return myElement.isDisplayed();
		} catch (Exception e) {
			return false;
		} finally {
			turnOnImplicitlyWait(driver);
		}
	}// isElementDisplay close

	public static boolean isElementDisplay(By locator, WebElement element) {
		try {
			WebElement myElement = element.findElement(locator);

			return myElement.isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}// isElementDisplay close

	public static boolean isElementNotDisplay(By locator, WebDriver driver) {
		turnOffImplicitlyWait(driver);
		boolean result = false;
		try {
			result = ExpectedConditions.invisibilityOfElementLocated(locator)
					.apply(driver);
		} finally {
			turnOnImplicitlyWait(driver);
		}
		return result;
	}// isElementNotDisplay close

	public static void turnOnImplicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void turnOffImplicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}

	public static boolean CheckChildElementsExists(WebElement ele,
			WebDriver driver) {
		turnOffImplicitlyWait(driver);
		boolean result = false;
		try {
			List<WebElement> ele1 = ele.findElements(By.xpath(".//*"));

			if (ele1.isEmpty()) {
				result = true;
			}
		} finally {
			turnOnImplicitlyWait(driver);
		}
		return result;
	}

}

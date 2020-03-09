package com.webdriver.UtilSection;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PageScroll 
{
	public static void scrollBottom(WebDriver driver) 
	{
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
}

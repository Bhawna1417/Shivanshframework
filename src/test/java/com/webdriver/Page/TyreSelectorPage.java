package com.webdriver.Page;

import org.openqa.selenium.WebDriver;

public class TyreSelectorPage {

	public static void OpenTyreSelectorPage(WebDriver driver, String baseurl)
	{
		driver.get(baseurl + "/view/content/tyreselector");
	}
	
}
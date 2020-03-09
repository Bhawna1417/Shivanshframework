package com.webdriver.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.webdriver.UtilSection.CheckElementDisplay;

public class RegistrationPage {

	public static String link_text = "Login or Register";

	public static void OpenRegistrationPage(WebDriver driver, String baseurl) throws Exception {

		boolean link = CheckElementDisplay.isElementDisplay(
				By.linkText(link_text), driver);

		if (link) {
			driver.findElement(By.linkText(link_text)).click();
		}
		
		CheckRegistrationPageDisplayed(driver, baseurl);
	}

	public static void CheckRegistrationPageDisplayed(WebDriver driver, String baseurl)
			throws Exception {
		String title = driver.getTitle();

		if(!title.toLowerCase().contains("registration"))
		{
			driver.get(baseurl + "/view/secured/content/login");
		}
		
//		Assert.assertEquals(title, "Registration | Costco UK");
	}
}
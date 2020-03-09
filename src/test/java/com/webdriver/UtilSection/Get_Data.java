package com.webdriver.UtilSection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Get_Data 
{

	public static String get_product_id_from_href(WebDriver driver, String xpath)
	{		
		String get_url = driver.findElement(By.xpath(xpath)).getAttribute("href");
		
		String[] temp = get_url.split("/");
		
		String data = temp[temp.length - 1 ];
		
		return data;
	}
	
}
package com.webdriver.Login;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.webdriver.Data.DataSetCollectors;
import com.webdriver.SetupData.MappingData;
import com.webdriver.UtilSection.GetRandom;

public class Login extends MappingData {

	WebDriver driver = null;
	Logger login = Logger.getLogger(Login.class);

	String username = null;
	String password = null;

	DataSetCollectors data = null;

	public Login(WebDriver driver, DataSetCollectors data) {
		this.driver = driver;
		this.data = data;
	}

	/**
	 * To fill details on login page for logging into application
	 * 
	 * @return Login
	 * @throws Exception
	 */
	public Login FillLogin() throws Exception {

		SetUserNamePassword();

		// driver.findElement(By.className(getidentifier("login.class.form")))
		// .findElement(By.id(getidentifier("login.id.username"))).clear();
		//
		// driver.findElement(By.className(getidentifier("login.class.form")))
		// .findElement(By.id(getidentifier("login.id.username")))
		// .sendKeys(username);

		// driver.findElement(By.className(getidentifier("login.class.form")))
		// .findElement(By.id(getidentifier("login.id.password"))).clear();
		//
		// driver.findElement(By.className(getidentifier("login.class.form")))
		// .findElement(By.id(getidentifier("login.id.password")))
		// .sendKeys(password);

		driver.findElement(
				By.xpath("//div[@class = 'login_content']//input[@id = 'user']"))
				.sendKeys(username);

		driver.findElement(
				By.xpath("//div[@class = 'login_content']//input[@id = 'loginpassword']"))
				.sendKeys(password);

		return this;
	}

	private Login SetUserNamePassword() throws Exception {
		// DataSetCollectors data = new DataSetCollectors();
		int selectuser = GetRandom.value(data.sizeuserlist(), -1);
		this.username = data.getuserlist(selectuser);
		this.password = data.getpasswordlist(selectuser);
		return this;
	}

	/**
	 * To open login page for logging into application
	 * 
	 * @return Login
	 */
	public Login ClickSubmit() {

		driver.findElement(
				By.xpath("//div[@class = 'login_content']//input[@value = 'Login']"))
				.click();
		// WebElement element = driver.findElement(
		// By.className(getidentifier("login.class.form"))).findElement(
		// By.className("btnmini"));
		// if (element != null) {
		// element.click();
		// }
		return this;
	}
}

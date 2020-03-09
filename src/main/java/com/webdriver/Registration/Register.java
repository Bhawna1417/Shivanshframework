package com.webdriver.Registration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.Data.DataSetCollectors;
import com.webdriver.SetupData.MappingData;
import com.webdriver.UtilSection.GetRandom;
import com.webdriver.UtilSection.Timestamp;

public class Register extends MappingData {

	WebDriver driver = null;
	Logger register = Logger.getLogger(Register.class);

	String firstname = null;
	String lastname = null;
	String registeremail = null;
	String confirmmail = null;
	String password = null;
	String confirmpass = null;

	DataSetCollectors data = null;

	public Register(WebDriver driver, DataSetCollectors data) {
		this.driver = driver;
		this.data = data;
	}

	/**
	 * To fill details on registration page for logging into application
	 * 
	 * @return
	 * @throws Exception
	 */
	public Register FillForm() throws Exception {

		SetDatatoFillRegistrationForm();

		driver.findElement(By.id(getidentifier("register.id.firstname")))
				.clear();
		driver.findElement(By.id(getidentifier("register.id.firstname")))
				.sendKeys(firstname);

		driver.findElement(By.id(getidentifier("register.id.lastname")))
				.clear();
		driver.findElement(By.id(getidentifier("register.id.lastname")))
				.sendKeys(firstname);

		driver.findElement(By.id(getidentifier("register.id.email"))).clear();
		driver.findElement(By.id(getidentifier("register.id.email"))).sendKeys(
				registeremail);

		driver.findElement(By.name(getidentifier("register.name.confirmmail")))
				.clear();
		driver.findElement(By.name(getidentifier("register.name.confirmmail")))
				.sendKeys(confirmmail);

		driver.findElement(By.id(getidentifier("register.id.password")))
				.clear();
		driver.findElement(By.id(getidentifier("register.id.password")))
				.sendKeys(password);

		driver.findElement(By.id(getidentifier("register.id.confirmpass")))
				.clear();
		driver.findElement(By.id(getidentifier("register.id.confirmpass")))
				.sendKeys(confirmpass);

		driver.findElement(By.id(getidentifier("register.id.mailinglist")))
				.click();

		register.info("Registration is successful using email as \""
				+ registeremail + "\" and password as \"" + password + "\" ");

		return this;
	}

	private Register SetDatatoFillRegistrationForm() throws Exception {
		// DataSetCollectors data = new DataSetCollectors();
		this.firstname = data.getfirstname(GetRandom.value(
				data.sizefirstname(), -1));
		this.lastname = data.getlastname(GetRandom.value(data.sizelastname(),
				-1));

		String mail = data.getRegsiteremail1() + Timestamp.current_timestamp()
				+ data.getRegisteremail2();

		this.registeremail = mail;
		this.confirmmail = mail;
		this.password = data.getPassword();
		this.confirmpass = data.getPassword();
		return this;
	}

	/**
	 * To open login page for logging into application
	 * 
	 * @return Login
	 */
	public Register ClickSubmit() {
		WebElement element = driver.findElement(By
				.id(getidentifier("register.id.submit")));
		if (element != null) {
			element.click();
		}
		return this;
	}
}

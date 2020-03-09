package com.webdriver.CategorySection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.Excel.ExcelHelpers;
import com.webdriver.SetupData.MappingData;
import com.webdriver.UtilSection.CheckElementDisplay;

public class Category extends MappingData {
	static ExcelHelpers excel = new ExcelHelpers();

	ArrayList<WebElement> category = new ArrayList<WebElement>();
	
	static ArrayList<String> categoryid = new ArrayList<String>();

	int currentrow = 1;

	WebDriver driver = null;

	public ArrayList<WebElement> getCategory() {
		return category;
	}

	public void setCategory(ArrayList<WebElement> category) {
		this.category = category;
	}

	public static ArrayList<String> getCategoryid() {
		return categoryid;
	}

	public boolean addids(String e) {
		return categoryid.add(e);
	}
	
	public Category(WebDriver driver) {
		this.driver = driver;
	}

	public Category Categorylocator(String location, String categorysheet) {
		excel.setLocation(location).setSheet(categorysheet);
		return this;
	}

	public Category CollectCategoryList() throws BiffException, WriteException,
			IOException {
		WebElement element = driver.findElement(By
				.id(getidentifier("navigation.id.list")));

		if (element != null) {
			List<WebElement> ele = element.findElements(By.tagName("li"));

			for (WebElement el : ele) {

				if (el.getAttribute("class").equals(
						getidentifier("parentcat.li.class"))) {
					category.add(el);
					el.click();
					CategoryData(el);
				}
			}
		}

		return this;
	}

	private void CategoryData(WebElement el) throws BiffException,
			WriteException, IOException {
		if (CheckElementDisplay.isElementDisplay(By.tagName("label"), el,
				driver)) {

			String getcategoryid = el.findElement(By.tagName("label"))
					.getAttribute("for");

			addids(getcategoryid);
			
			String getcategoryname = el.findElement(By.tagName("label"))
					.getText();

			String getcategoryurl = el
					.findElement(
							By.className(getidentifier("parentsub.ul.class")))
					.findElement(
							By.className(getidentifier("openparent.li.class")))
					.findElement(By.tagName("a")).getAttribute("href");

			fillsheet(getcategoryid, getcategoryname, getcategoryurl);
		}

	}

	public Category fillsheet(String id, String name, String url)
			throws BiffException, WriteException, IOException {
		excel.fillInteger(0, currentrow, currentrow);

		excel.fillString(1, currentrow, id);

		excel.fillString(2, currentrow, name);

		excel.fillString(3, currentrow, url).getRowsCount();

		currentrow = excel.getRowcount();
		
		return this;
	}

}
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

public class ChildCategory extends MappingData {
	static ExcelHelpers excel = new ExcelHelpers();

	ArrayList<WebElement> childcat = new ArrayList<WebElement>();

	int currentrow = 1;

	WebDriver driver = null;

	public ArrayList<WebElement> getChildcat() {
		return childcat;
	}

	public void setChildcat(ArrayList<WebElement> childcat) {
		this.childcat = childcat;
	}

	public ChildCategory(WebDriver driver) {
		this.driver = driver;
	}

	public ChildCategory Categorylocator(String location, String categorysheet) {
		excel.setLocation(location).setSheet(categorysheet);
		return this;
	}

	public ChildCategory fillsheet(String categoryid, String subcategoryid,
			String id, String name, String url) throws BiffException,
			WriteException, IOException {

		if (currentrow != 1) {
			currentrow = excel.getRowcount();
		}

		excel.fillInteger(0, currentrow, currentrow);

		excel.fillString(1, currentrow, categoryid);

		excel.fillString(2, currentrow, subcategoryid);

		excel.fillString(3, currentrow, name);

		excel.fillString(4, currentrow, url).getRowsCount();

		currentrow = excel.getRowcount();

		return this;
	}

	public ChildCategory CollectCategoryList(ArrayList<WebElement> category,
			ArrayList<WebElement> subcategory, ArrayList<Integer> count)
			throws BiffException, WriteException, IOException {

		ArrayList<String> catid = Category.getCategoryid();

		ArrayList<String> subcatid = SubCategory.getSubcategoryid();

		int counter = 0;

		for (int i = 0; i < category.size(); i++) {
			category.get(i).click();

			System.out.println("Sub Counts " + count.get(i));

			for (int j = counter; j < (counter + count.get(i)); j++) {
				System.out.println("Sub Category click " + j);

				subcategory.get(j).click();

				WebElement elmt = subcategory.get(j).findElement(
						By.className(getidentifier("subchild.ul.class")));

				if (elmt != null) {
					List<WebElement> ele = elmt.findElements(By.tagName("li"));

					System.out.println("Child Category count " + ele.size());

					for (WebElement el : ele) {

						ChildCategoryData(catid.get(i), subcatid.get(j), el);
					}
				}
			}
			counter = counter + count.get(i);
		}
		return this;
	}

	private void ChildCategoryData(String catid, String subcatid, WebElement el)
			throws BiffException, WriteException, IOException {

		String getclass = el.getAttribute("class");

		if (getclass.isEmpty()) {

			String getcategoryid = null;

			String getcategoryname = el.getText();

			String getcategoryurl = el.findElement(By.tagName("a"))
					.getAttribute("href");

			fillsheet(catid, subcatid, getcategoryid, getcategoryname,
					getcategoryurl);
		}
	}
}

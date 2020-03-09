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

public class SubCategory extends MappingData {
	static ExcelHelpers excel = new ExcelHelpers();

	ArrayList<WebElement> subcat = new ArrayList<WebElement>();
	
	ArrayList<Integer> subcount = new ArrayList<Integer>();
	
	static ArrayList<String> subcategoryid = new ArrayList<String>();

	int currentrow = 1;

	WebDriver driver = null;

	public ArrayList<WebElement> getSubcat() {
		return subcat;
	}

	public void setSubcat(ArrayList<WebElement> subcat) {
		this.subcat = subcat;
	}

	public boolean addsubcatids(String e) {
		return subcategoryid.add(e);
	}

	public static ArrayList<String> getSubcategoryid() {
		return subcategoryid;
	}

	public SubCategory(WebDriver driver) {
		this.driver = driver;
	}

	public ArrayList<Integer> getSubcount() {
		return subcount;
	}

	public void setSubcount(ArrayList<Integer> subcount) {
		this.subcount = subcount;
	}

	public SubCategory Categorylocator(String location, String categorysheet) {
		excel.setLocation(location).setSheet(categorysheet);
		return this;
	}

	public SubCategory CollectSubCategoryList(ArrayList<WebElement> category) throws BiffException, WriteException,
			IOException {
		
		ArrayList<String> catid = Category.getCategoryid();
		
		for(int i=0; i<category.size(); i++)
		{
			category.get(i).click();
			
			WebElement elmt = category.get(i).findElement(By
					.className(getidentifier("parentsub.ul.class")));
			
			if (elmt != null) {
				List<WebElement> ele = elmt.findElements(By
						.className(getidentifier("subcat.li.class")));

				subcount.add(ele.size());
				
				for (WebElement el : ele) {
					subcat.add(el);
					el.click();
					SubCategoryData(catid.get(i),el);
				}
			}
		}	
		return this;
	}

	private void SubCategoryData(String catid, WebElement el) throws BiffException, WriteException, IOException 
	{
		if (CheckElementDisplay.isElementDisplay(By.tagName("label"), el,
				driver)) {

			String getcategoryid = el.findElement(By.tagName("label"))
					.getAttribute("for");

			addsubcatids(getcategoryid);
			
			String getcategoryname = el.findElement(By.tagName("label"))
					.getText();

			String getcategoryurl = el
					.findElement(
							By.className(getidentifier("parentsub.ul.class")))
					.findElement(
							By.className(getidentifier("openparent.li.class")))
					.findElement(By.tagName("a")).getAttribute("href");

			fillsheet(catid,getcategoryid, getcategoryname, getcategoryurl);
		}
	}

	public SubCategory fillsheet(String categoryid, String id, String name,
			String url) throws BiffException, WriteException, IOException {

		if (currentrow != 1) {
			currentrow = excel.getRowcount();
		}

		excel.fillInteger(0, currentrow, currentrow);

		excel.fillString(1, currentrow, categoryid);

		excel.fillString(2, currentrow, id);

		excel.fillString(3, currentrow, name);

		excel.fillString(4, currentrow, url).getRowsCount();

		currentrow = excel.getRowcount();

		return this;
	}
}

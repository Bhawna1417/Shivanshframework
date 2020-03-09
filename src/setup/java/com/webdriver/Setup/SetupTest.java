package com.webdriver.Setup;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.webdriver.CategorySection.Category;
import com.webdriver.CategorySection.ChildCategory;
import com.webdriver.CategorySection.SubCategory;
import com.webdriver.Excel.ExcelHelpers;
import com.webdriver.SetupProperties.SetExcelProperty;
import com.webdriver.TestCaseBase.AkeoSanityTestBase;

public class SetupTest extends AkeoSanityTestBase {

	static ExcelHelpers excelprod = new ExcelHelpers();

	static SetExcelProperty excelprop = new SetExcelProperty();

	static String location = null;

	static Logger logsetup = Logger.getLogger(SetupTest.class);

	@Test
	public void Setup() throws Exception {

		ArrayList<WebElement> categorylist = new ArrayList<WebElement>();

		ArrayList<WebElement> subcategorylist = new ArrayList<WebElement>();

		WebDriver driver = getDriver();

		Category cat = new Category(driver);

		SubCategory subcat = new SubCategory(driver);

		ChildCategory childcat = new ChildCategory(driver);

		excelprop.timestamp();

		CreateExcelSheet(cat, subcat, childcat);

		cat.CollectCategoryList();

		categorylist = cat.getCategory();

		subcat.CollectSubCategoryList(categorylist);

		subcategorylist = subcat.getSubcat();

		ArrayList<Integer> subcounts = subcat.getSubcount();

		childcat.CollectCategoryList(categorylist, subcategorylist, subcounts);
	}

	private void CreateExcelSheet(Category category, SubCategory subcategory,
			ChildCategory childcategory) throws Exception {
		excelprop.excellocation(getUserdir());

		logsetup.info("Setting Excel Sheet names");
		excelprop.GenerateSheetNames();

		location = excelprop.loc;

		if (!FileProcess.CheckExcelExists(location)) {
			ExcelCreations.CreateNew(location);
			logsetup.info("Excel does not exists, hence created a new one");
			System.out.println(location);
		}

		ExcelCreations.CreateSheet(location, excelprop.categorysheet,
				excelprop.subcategorysheet, excelprop.childcategorysheet,
				excelprop.productsheet);

		category.Categorylocator(location, excelprop.categorysheet);

		subcategory.Categorylocator(location, excelprop.subcategorysheet);

		childcategory.Categorylocator(location, excelprop.childcategorysheet);

		excelprod.setLocation(location).setSheet(excelprop.productsheet);

	}
}
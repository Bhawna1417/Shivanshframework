package com.webdriver.Setup;

import java.io.File;
import java.util.Locale;

import org.apache.log4j.Logger;

import com.webdriver.Excel.ExcelHelpers;
import com.webdriver.SetupData.ExcelLabels;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelCreations extends ExcelHelpers {
	static Logger excelcreations = Logger.getLogger(ExcelCreations.class);

	public static void CreateSheet(String loc, String cat, String sub,
			String child, String product) throws Exception {

		WorkbookSettings ws = new WorkbookSettings();
		ws.setLocale(new Locale("en", "EN"));

		Workbook wb1 = Workbook.getWorkbook(new File(loc), ws);

		WritableWorkbook copy = Workbook.createWorkbook(new File(loc), wb1);

		excelcreations.info("Creating new Category Sheet as " + cat);
		WritableSheet s1 = copy.createSheet(cat, 0);
		CreateSheetHeader(s1, ExcelLabels.CategoryLabels(),
				ExcelLabels.CategoryLabels);

		excelcreations.info("Creating new Sub Category Sheet as " + sub);
		WritableSheet s2 = copy.createSheet(sub, 1);
		CreateSheetHeader(s2, ExcelLabels.SubCategoryLabels(),
				ExcelLabels.SubCategoryLabels);

		excelcreations.info("Creating new Child Category Sheet as " + child);
		WritableSheet s3 = copy.createSheet(child, 2);
		CreateSheetHeader(s3, ExcelLabels.ChildCategoryLabels(),
				ExcelLabels.ChildCategoryLabels);

		excelcreations.info("Creating new Product Sheet as " + product);
		WritableSheet s4 = copy.createSheet(product, 3);
		CreateSheetHeader(s4, ExcelLabels.ProductLabels(),
				ExcelLabels.ProductLabels);

		copy.write();
		copy.close();
	}
}

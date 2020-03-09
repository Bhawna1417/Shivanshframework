package com.webdriver.SetupData;

import java.lang.reflect.Array;

public class ExcelLabels {
	public static String[] CategoryLabels = { "S. No.", "Category ID",
			"Category Name", "Category Link" };

	public static String[] SubCategoryLabels = { "S. No.", "Category ID",
			"SubCategory ID", "SubCategory Name", "SubCategory Link" };

	public static String[] ChildCategoryLabels = { "S. No.", "Category ID",
			"SubCategory ID", "Child Category Name", "Child Category Link" };

	public static String[] ProductLabels = { "S. No.", "Child Category Number",
			"Product Name", "Product Link", "Preferred Delivery",
			"Product Title" };

	public static int CategoryLabels() {
		int length = Array.getLength(CategoryLabels);

		return length;
	}

	public static int SubCategoryLabels() {
		int length = Array.getLength(SubCategoryLabels);

		return length;
	}

	public static int ChildCategoryLabels() {
		int length = Array.getLength(ChildCategoryLabels);

		return length;
	}

	public static int ProductLabels() {
		int length = Array.getLength(ProductLabels);

		return length;

	}
}

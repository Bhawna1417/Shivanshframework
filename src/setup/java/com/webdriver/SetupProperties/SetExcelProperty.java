package com.webdriver.SetupProperties;

import com.webdriver.UtilSection.Timestamp;

public class SetExcelProperty 
{	
	public String loc = null;
	public String categorysheet = null;
	public String subcategorysheet = null;
	public String childcategorysheet = null;
	public String productsheet = null;
	
	String timestamp = null;
		
	public SetExcelProperty timestamp() throws Exception
	{		
		timestamp = Timestamp.getDate();
		return this;
	}
		
	public SetExcelProperty excellocation(String dir)
	{		
		loc = dir + "\\Costco" + timestamp +".xls";
		return this;
	}
	
	public SetExcelProperty category(String name)
	{
		this.categorysheet = name;		
		return this;
	}
	
	public SetExcelProperty subcategory(String name)
	{
		this.subcategorysheet = name;		
		return this;
	}
	
	public SetExcelProperty childcategory(String name)
	{
		this.childcategorysheet = name;		
		return this;
	}
	
	public SetExcelProperty productsheet(String name)
	{
		this.productsheet = name;		
		return this;
	}
	
	public SetExcelProperty GenerateSheetNames()
	{		
		category("category" + timestamp);
		subcategory("subcat" + timestamp);
		childcategory("childcat" + timestamp);
		productsheet("product" + timestamp);
		return this;
	}
}
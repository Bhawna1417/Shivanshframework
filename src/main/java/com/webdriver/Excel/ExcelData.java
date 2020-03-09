package com.webdriver.Excel;

import java.util.ArrayList;

public class ExcelData 
{	
	ArrayList<String> rowdata = new ArrayList<String>();
	ArrayList<String> columndata = new ArrayList<String>();
	
	String[] sheetdata = null;
	
	String celldata = null;

	public ArrayList<String> getRowdata() {
		return rowdata;
	}

	public void setRowdata(ArrayList<String> rowdata) {
		this.rowdata = rowdata;
	}

	public ArrayList<String> getColumndata() {
		return columndata;
	}

	public void setColumndata(ArrayList<String> columndata) {
		this.columndata = columndata;
	}

	public boolean addcolumndata(String e) {
		return columndata.add(e);
	}

	public void clearcolumndata() {
		columndata.clear();
	}

	public boolean containscolumndata(Object o) {
		return columndata.contains(o);
	}

	public String getcolumndata(int index) {
		return columndata.get(index);
	}

	public int sizecolumndata() {
		return columndata.size();
	}

	public boolean addrowdata(String e) {
		return rowdata.add(e);
	}

	public void clearrowdata() {
		rowdata.clear();
	}

	public boolean containsrowdata(Object o) {
		return rowdata.contains(o);
	}

	public String getrowdata(int index) {
		return rowdata.get(index);
	}

	public int sizerowdata() {
		return rowdata.size();
	}

	public String getCelldata() {
		return celldata;
	}

	public void setCelldata(String celldata) {
		this.celldata = celldata;
	}

	public String[] getSheetdata() {
		return sheetdata;
	}

	public void setSheetdata(String[] sheetdata) {
		this.sheetdata = sheetdata;
	}	
}
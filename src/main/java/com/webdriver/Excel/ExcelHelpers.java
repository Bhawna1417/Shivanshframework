package com.webdriver.Excel;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import org.apache.log4j.Logger;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.Pattern;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelHelpers extends ExcelData {
	static Logger excelhelpers = Logger.getLogger(ExcelHelpers.class);

	String location = null;
	String sheet = null;

	ExcelData excel = new ExcelData();

	int rowcount = 0;
	int columncount = 0;

	public int getRowcount() {
		return rowcount;
	}

	public void setRowcount(int rowcount) {
		this.rowcount = rowcount;
	}

	public int getColumncount() {
		return columncount;
	}

	public void setColumncount(int columncount) {
		this.columncount = columncount;
	}

	public ExcelHelpers setLocation(String location) {
		this.location = location;
		return this;
	}

	public ExcelHelpers setSheet(String sheet) {
		this.sheet = sheet;
		return this;
	}

	public ExcelHelpers fillInteger(int col, int row, int value)
			throws BiffException, IOException, WriteException {
		excelhelpers.info("Filling integer value as " + value + " in row "
				+ row + " in column " + col);

		Workbook wb1 = Workbook.getWorkbook(new File(location));

		WritableWorkbook copy = Workbook
				.createWorkbook(new File(location), wb1);

		WritableSheet obj = copy.getSheet(sheet);

		WritableFont wf = new WritableFont(WritableFont.ARIAL, 10);
		WritableCellFormat cf = new WritableCellFormat(wf);
		cf.setWrap(true);
		cf.setBorder(Border.ALL, BorderLineStyle.THIN);

		Number data = new Number(col, row, value, cf);

		obj.addCell(data);

		copy.write();
		copy.close();

		return this;
	}

	public ExcelHelpers fillString(int col, int row, String string)
			throws BiffException, IOException, WriteException {
		excelhelpers.info("Filling String value as " + string + " in row "
				+ row + " in column " + col);

		Workbook wb1 = Workbook.getWorkbook(new File(location));

		WritableWorkbook copy = Workbook
				.createWorkbook(new File(location), wb1);

		WritableSheet obj = copy.getSheet(sheet);

		WritableFont wf = new WritableFont(WritableFont.ARIAL, 10);
		WritableCellFormat cf = new WritableCellFormat(wf);
		cf.setWrap(true);
		cf.setBorder(Border.ALL, BorderLineStyle.THIN);

		Label data = new Label(col, row, string, cf);
		obj.addCell(data);

		copy.write();
		copy.close();

		return this;
	}

	public ExcelHelpers readContent(int col, int row) throws BiffException,
			IOException {
		excelhelpers.info("Reading content from column " + col + " row " + row);

		Workbook wb = Workbook.getWorkbook(new File(location));

		Sheet sh = wb.getSheet(sheet);

		excel.setCelldata(sh.getCell(col, row).getContents());

		wb.close();

		return this;
	}

	public ExcelHelpers getRowsCount() throws BiffException, IOException {
		excelhelpers.info("Collecting row count from Sheet " + sheet);
		Workbook wb = Workbook.getWorkbook(new File(location));

		Sheet sh = wb.getSheet(sheet);
		setRowcount(sh.getRows());
		wb.close();

		return this;
	}

	public ExcelHelpers getColumnsCount() throws BiffException, IOException {
		excelhelpers.info("Collecting column count from Sheet " + sheet);
		Workbook wb = Workbook.getWorkbook(new File(location));

		Sheet sh = wb.getSheet(sheet);
		setColumncount(sh.getColumns());
		wb.close();

		return this;
	}

	public ExcelHelpers getColumnContents(int columnnumber)
			throws BiffException, IOException {
		excelhelpers.info("Collecting column contents from Sheet " + sheet);
		Workbook wb = Workbook.getWorkbook(new File(location));

		Sheet sh = wb.getSheet(sheet);
		Cell[] newlist = sh.getColumn(columnnumber);
		wb.close();

		for (int i = 1; i <= getRowcount(); i++) {
			excel.addcolumndata(newlist[i].getContents());
		}

		return this;
	}

	public ExcelHelpers getRowContents(int rownumber) throws BiffException,
			IOException {
		excelhelpers.info("Collecting row contents from Sheet " + sheet);
		Workbook wb = Workbook.getWorkbook(new File(location));

		Sheet sh = wb.getSheet(sheet);
		Cell[] newlist = sh.getRow(rownumber);
		wb.close();

		for (int i = 1; i <= getRowcount(); i++) {
			excel.addrowdata(newlist[i].getContents());
		}

		return this;
	}

	public ExcelHelpers getSheetNames() throws BiffException, IOException {
		excelhelpers.info("Collecting Sheet Names");
		Workbook wb = Workbook.getWorkbook(new File(location));

		excel.setSheetdata(wb.getSheetNames());

		wb.close();

		return this;
	}

	public static void CreateNew(String loc) {
		try {
			excelhelpers.info("Creating new sheet");
			WorkbookSettings ws = new WorkbookSettings();
			ws.setLocale(new Locale("en", "EN"));
			WritableWorkbook workbook = Workbook.createWorkbook(new File(loc),
					ws);
			workbook.createSheet("Sheet1", 0);

			workbook.write();
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}

	public static void CreateSheetHeader(WritableSheet obj, int count,
			String[] data) throws WriteException {
		excelhelpers.info("Creating Sheet Headers");
		Label label;

		/* Format the Font */
		WritableFont wf = new WritableFont(WritableFont.ARIAL, 12,
				WritableFont.BOLD);
		WritableCellFormat cf = new WritableCellFormat(wf);
		cf.setWrap(true);
		cf.setBackground(Colour.LIGHT_GREEN, Pattern.SOLID);
		cf.setBorder(Border.ALL, BorderLineStyle.THIN);

		for (int i = 0; i < count; i++) {
			label = new Label(i, 0, data[i], cf);
			obj.addCell(label);
		}
	}
}

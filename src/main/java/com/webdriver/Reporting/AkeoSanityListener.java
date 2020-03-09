package com.webdriver.Reporting;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.FileOutputStream;

import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.Chunk;
import com.webdriver.UtilSection.InformationCollectorUtils;

public class AkeoSanityListener extends TestListenerAdapter {

	static Logger ListenerLog = Logger.getLogger(AkeoSanityListener.class);

	/**
	 * Document
	 */
	private Document document = null;

	/**
	 * PdfPTables
	 */
	PdfPTable successTable = null, failTable = null;

	/**
	 * throwableMap
	 */
	private HashMap<Integer, Throwable> throwableMap = null;

	/**
	 * nbExceptions
	 */
	private int nbExceptions = 0;

	/**
	 * Fonts
	 */
	Font pass_test_case_header_font = new Font(Font.FontFamily.TIMES_ROMAN,
			Font.DEFAULTSIZE, Font.BOLD);
	Font fail_test_case_header_font = new Font(Font.FontFamily.TIMES_ROMAN,
			Font.DEFAULTSIZE, Font.BOLD);
	Font Result_font = FontFactory.getFont(FontFactory.HELVETICA, 20,
			Font.BOLD, new CMYKColor(0, 0, 255, 0));

	/**
	 * Constructor
	 */
	public AkeoSanityListener() {
		ListenerLog.info("Costco Custom Listener");

		this.document = new Document();
		this.throwableMap = new HashMap<Integer, Throwable>();
	}

	@Override
	public void onStart(ITestContext arg0) {
		ListenerLog.info("Test has been started --> " + arg0);
		System.out.println("Start Of Execution(TEST)->" + arg0.getName());

		try {
			PdfWriter.getInstance(this.document,
					new FileOutputStream(arg0.getName() + ".pdf"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.document.open();

		Paragraph p = new Paragraph(arg0.getName() + " TESTNG RESULTS",
				Result_font);

		try {
			this.document.add(p);
			this.document.add(new Paragraph(new Date().toString()));
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext arg0) {
		ListenerLog.info("Test has been finished --> " + arg0);
		System.out.println("END Of Execution(TEST)->" + arg0.getName());

		try {
			if (this.failTable != null) {
				ListenerLog.info("Added fail table");
				this.failTable.setSpacingBefore(15f);
				this.document.add(this.failTable);
				this.failTable.setSpacingAfter(15f);
			}

			if (this.successTable != null) {
				ListenerLog.info("Added success table");
				this.successTable.setSpacingBefore(15f);
				this.document.add(this.successTable);
				this.successTable.setSpacingBefore(15f);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		Paragraph p = new Paragraph("EXCEPTIONS SUMMARY", FontFactory.getFont(
				FontFactory.HELVETICA, 16, Font.BOLD, new CMYKColor(255, 0, 0,
						0)));
		try {
			this.document.add(p);
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}

		Set<Integer> keys = this.throwableMap.keySet();

		assert keys.size() == this.nbExceptions;

		for (Integer key : keys) {
			Throwable throwable = this.throwableMap.get(key);

			Chunk chunk = new Chunk(throwable.toString(), FontFactory.getFont(
					FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(255, 0,
							0, 0)));
			chunk.setLocalDestination("" + key);
			Paragraph throwTitlePara = new Paragraph(chunk);
			try {
				this.document.add(throwTitlePara);
			} catch (DocumentException e3) {
				e3.printStackTrace();
			}

			StackTraceElement[] elems = throwable.getStackTrace();
			// String exception = "";
			for (StackTraceElement ste : elems) {
				Paragraph throwParagraph = new Paragraph(ste.toString());
				try {
					this.document.add(throwParagraph);
				} catch (DocumentException e2) {
					e2.printStackTrace();
				}
			}
		}

		this.document.close();

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("Test Started->" + arg0.getName());
	}

	@Override
	public void onTestSuccess(ITestResult arg0)

	{
		System.out.println("Test Pass->" + arg0.getName());

		ListenerLog.info("Test Case has been passed --> " + arg0);

		if (successTable == null) {
			this.successTable = new PdfPTable(
					new float[] { .3f, .3f, .1f, .3f });
			Paragraph para = new Paragraph("PASSED TESTS",
					pass_test_case_header_font);
			para.setAlignment(Element.ALIGN_CENTER);
			PdfPCell cell = new PdfPCell(para);
			cell.setColspan(4);

			cell.setBackgroundColor(BaseColor.GREEN);
			this.successTable.addCell(cell);

			cell = new PdfPCell(new Paragraph("Class"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.successTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Method"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.successTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Time (ms)"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.successTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Exception"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.successTable.addCell(cell);
		}

		PdfPCell cell = new PdfPCell(new Paragraph(arg0.getTestClass()
				.toString()));
		this.successTable.addCell(cell);
		cell = new PdfPCell(new Paragraph(arg0.getMethod().getMethodName()
				.toString()));
		this.successTable.addCell(cell);
		cell = new PdfPCell(new Paragraph(""
				+ (arg0.getEndMillis() - arg0.getStartMillis())));
		this.successTable.addCell(cell);

		Throwable throwable = arg0.getThrowable();
		if (throwable != null) {
			this.throwableMap.put(new Integer(throwable.hashCode()), throwable);
			this.nbExceptions++;
			Paragraph excep = new Paragraph(new Chunk(throwable.toString(),
					new Font(Font.FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE,
							Font.UNDERLINE)).setLocalGoto(""
					+ throwable.hashCode()));
			cell = new PdfPCell(excep);
			this.successTable.addCell(cell);
		} else {
			this.successTable.addCell(new PdfPCell(new Paragraph("")));
		}

	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println("Test Failed->" + arg0.getName());

		ListenerLog.info("Test Case has been failed --> " + arg0);

		String ScreenShot_file = System.getProperty("user.dir") + "\\"
				+ "screenshot" + (new Random().nextInt()) + ".png";

		try {
			InformationCollectorUtils.takeSnapShot(
					InformationCollectorUtils.getdriver(), ScreenShot_file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (this.failTable == null) {
			this.failTable = new PdfPTable(new float[] { .3f, .3f, .1f, .3f });
			this.failTable.setTotalWidth(20f);
			Paragraph para = new Paragraph("FAILED TESTS",
					fail_test_case_header_font);
			para.setAlignment(Element.ALIGN_CENTER);
			PdfPCell cell = new PdfPCell(para);
			cell.setColspan(4);
			cell.setBackgroundColor(BaseColor.RED);
			this.failTable.addCell(cell);

			cell = new PdfPCell(new Paragraph("Class"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.failTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Method"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.failTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Time (ms)"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.failTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Exception"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.failTable.addCell(cell);
		}

		PdfPCell cell = new PdfPCell(new Paragraph(arg0.getTestClass()
				.toString()));
		this.failTable.addCell(cell);
		cell = new PdfPCell(new Paragraph(arg0.getMethod().getMethodName()
				.toString()));
		this.failTable.addCell(cell);
		cell = new PdfPCell(new Paragraph(""
				+ (arg0.getEndMillis() - arg0.getStartMillis())));
		this.failTable.addCell(cell);

		Throwable throwable = arg0.getThrowable();
		if (throwable != null) {
			this.throwableMap.put(new Integer(throwable.hashCode()), throwable);
			this.nbExceptions++;

			Chunk imdb = new Chunk("[SCREEN SHOT]", new Font(
					Font.FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE,
					Font.UNDERLINE));
			imdb.setAction(new PdfAction("file:///" + ScreenShot_file));
			Paragraph excep = new Paragraph(throwable.toString());
			excep.add(imdb);

			// Paragraph excep = new Paragraph(ck.setLocalGoto("" +
			// throwable.hashCode()));
			cell = new PdfPCell(excep);
			this.failTable.addCell(cell);
		} else {
			this.failTable.addCell(new PdfPCell(new Paragraph("")));
		}

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		ListenerLog.info("Test Case has been skipped --> " + arg0);

		System.out.println("Test Skipped->" + arg0.getName());
	}
}
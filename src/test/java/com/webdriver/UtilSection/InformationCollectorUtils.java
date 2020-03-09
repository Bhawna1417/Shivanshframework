package com.webdriver.UtilSection;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.webdriver.TestCaseBase.AkeoSanityTestBase;

public class InformationCollectorUtils extends AkeoSanityTestBase {

	public static WebDriver getdriver() {

		return getDriver();
	}

	/**
	 * This function will take screenshot
	 * 
	 * @param driverobj
	 * @param fileWithPath
	 * @throws Exception
	 */

	public static void takeSnapShot(WebDriver driverobj, String fileWithPath)
			throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driverobj);

		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination
		File DestFile = new File(fileWithPath);

		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);

	}

}
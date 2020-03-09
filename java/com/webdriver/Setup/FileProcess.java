package com.webdriver.Setup;

import java.io.File;

public class FileProcess 
{

	public static boolean CheckExcelExists(String filename)
	{
		File check = new File(filename);
		
		boolean exist = check.exists();
		
		// check file exists
		if (!exist) {
			System.out.println("File does not exist");
			return false;
		} else {
			System.out.println("File exists");
			return true;
		}
	}
}

package com.webdriver.TestCaseBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class LoadPropertyFiles {

	String loc = null;

	public LoadPropertyFiles(String location) {
		loc = location;
	}

	public static String ReadPropertiesEnv(String loc, String getkeyvalue) {
		String returnvalue = null;

		try {
			File file = new File(loc
					+ "\\src\\main\\resources\\env-test.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();

			Enumeration<?> enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				// System.out.println(key + ": " + value);

				if (key.toLowerCase().equals(getkeyvalue)) {
					returnvalue = value;
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return returnvalue;
	}

	// public static void ReadPropertiesFile(String loc) {
	// try {
	// File file = new File(loc + "test.properties");
	// FileInputStream fileInput = new FileInputStream(file);
	// Properties properties = new Properties();
	// properties.load(fileInput);
	// fileInput.close();
	//
	// Enumeration<?> enuKeys = properties.keys();
	// while (enuKeys.hasMoreElements()) {
	// String key = (String) enuKeys.nextElement();
	// String value = properties.getProperty(key);
	// System.out.println(key + ": " + value);
	// }
	// } catch (FileNotFoundException e) {
	// e.printStackTrace();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }

}
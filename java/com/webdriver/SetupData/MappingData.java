package com.webdriver.SetupData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

public class MappingData {

	protected static Map<String, String> identifiers = new HashMap<String, String>();

	protected static Map<String, String> messages = new HashMap<String, String>();

	protected static Map<String, String> dataset = new HashMap<String, String>();

	public Map<String, String> getMessages() {
		return messages;
	}

	public void setMessages(Map<String, String> messages) {
		MappingData.messages = messages;
	}

	public void clearmsgs() {
		messages.clear();
	}

	public boolean containsmsgKey(Object key) {
		return messages.containsKey(key);
	}

	public String getmsg(Object key) {
		return messages.get(key);
	}

	public static String putmsg(String key, String value) {
		return messages.put(key, value);
	}

	public int sizemsgs() {
		return messages.size();
	}

	public Map<String, String> getIdentifiers() {
		return identifiers;
	}

	public void setIdentifiers(Map<String, String> identifiers) {
		MappingData.identifiers = identifiers;
	}

	public void clearids() {
		identifiers.clear();
	}

	public boolean containsidKey(Object key) {
		return identifiers.containsKey(key);
	}

	public String getidentifier(Object key) {
		return identifiers.get(key);
	}

	public boolean isidentifierEmpty() {
		return identifiers.isEmpty();
	}

	public static String putidentifier(String key, String value) {
		return identifiers.put(key, value);
	}

	public int sizeidentifiers() {
		return identifiers.size();
	}

	public static Map<String, String> getDataset() {
		return dataset;
	}

	public static void setDataset(Map<String, String> dataset) {
		MappingData.dataset = dataset;
	}

	public int sizedataset() {
		return dataset.size();
	}

	public boolean isdatasetEmpty() {
		return dataset.isEmpty();
	}

	public static boolean containsdatasetKey(Object key) {
		return dataset.containsKey(key);
	}

	public static String getdataset(Object key) {
		return dataset.get(key);
	}

	public static String putdataset(String key, String value) {
		return dataset.put(key, value);
	}

	public void cleardataset() {
		dataset.clear();
	}

	public static void PropertiesDataCollector(String userdir, Logger log)
			throws Exception {
		CollectMessages(userdir, log);
		log.info("Adding Messages to execution suite.");
		CollectIdentifiers(userdir, log);
		log.info("Adding Identifiers to execution Suite.");
		CollectDataSetValues(userdir, log);
		log.info("Adding Data Set Values to execution Suite.");
	}

	private static void CollectIdentifiers(String userdir, Logger log) {
		try {
			File file = new File(userdir
					+ "\\src\\main\\resources\\identifier.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();

			Enumeration<?> enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				// System.out.println(key + ": " + value);
				putidentifier(key, value);
			}
		} catch (FileNotFoundException e) {
			log.info(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
	}

	private static void CollectMessages(String userdir, Logger log) {
		try {
			File file = new File(userdir
					+ "\\src\\main\\resources\\language.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();

			Enumeration<?> enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				// System.out.println(key + ": " + value);
				putmsg(key, value);
			}
		} catch (FileNotFoundException e) {
			log.info(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
	}

	private static void CollectDataSetValues(String userdir, Logger log) {
		try {
			File file = new File(userdir
					+ "\\src\\main\\resources\\dataset.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();

			Enumeration<?> enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				// System.out.println(key + ": " + value);
				putdataset(key, value);
			}
		} catch (FileNotFoundException e) {
			log.info(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
	}
}
package com.webdriver.Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ProductValues {

	Logger productvalues = Logger.getLogger(ProductValues.class);

	String userdir = null;

	public ArrayList<String> producturls = new ArrayList<String>();

	public ArrayList<String> premiumproducturls = new ArrayList<String>();

	protected Map<String, String> urlset = new HashMap<String, String>();

	public Map<String, String> getUrlset() {
		return urlset;
	}

	public void setUrlset(Map<String, String> urlset) {
		this.urlset = urlset;
	}

	public void clearurlset() {
		urlset.clear();
	}

	public boolean containsurlsetKey(Object key) {
		return urlset.containsKey(key);
	}

	public String geturlset(Object key) {
		return urlset.get(key);
	}

	public boolean isurlsetEmpty() {
		return urlset.isEmpty();
	}

	public String puturlset(String key, String value) {
		return urlset.put(key, value);
	}

	public int sizeurlset() {
		return urlset.size();
	}

	public ArrayList<String> getProducturls() {
		return producturls;
	}

	public void setProducturls(ArrayList<String> producturls) {
		this.producturls = producturls;
	}

	public boolean addproducturls(String e) {
		return producturls.add(e);
	}

	public void clearproducturls() {
		producturls.clear();
	}

	public String getproducturls(int index) {
		return producturls.get(index);
	}

	public boolean isEmptyproducturls() {
		return producturls.isEmpty();
	}

	public String removeproducturls(int index) {
		return producturls.remove(index);
	}

	public int sizeproducturls() {
		return producturls.size();
	}

	public ArrayList<String> getPremiumproducturls() {
		return premiumproducturls;
	}

	public void setPremiumproducturls(ArrayList<String> premiumproducturls) {
		this.premiumproducturls = premiumproducturls;
	}

	public boolean addpremiumproducturls(String e) {
		return premiumproducturls.add(e);
	}

	public void clearpremiumproducturls() {
		premiumproducturls.clear();
	}

	public String getpremiumproducturls(int index) {
		return premiumproducturls.get(index);
	}

	public boolean isEmptypremiumproducturls() {
		return premiumproducturls.isEmpty();
	}

	public String removepremiumproducturls(int index) {
		return premiumproducturls.remove(index);
	}

	public int sizepremiumproducturls() {
		return premiumproducturls.size();
	}

	public ProductValues(String userdir) throws Exception {
		this.userdir = userdir;
		SetUrls();
	}

	public ProductValues SetUrls() throws Exception {

		if (producturls.isEmpty() && premiumproducturls.isEmpty()) {
			collecturls();
		}

		GetProductUrlsFromList();
		GetPremiumProductUrlsFromList();

		return this;

		// ExcelSheetOperations.getRowCountFromExcel(
		// SetConfiguration.getFileloc(),
		// SetConfiguration.getProduct_sheet());
		//
		// ExcelSheetOperations.getColDataFromExcel(SetConfiguration.getFileloc(),
		// SetConfiguration.getProduct_sheet(), 3);
		//
		// urls = ExcelSheetOperations.getColData();
	}

	public ProductValues GetProductUrlsFromList() throws Exception {
		int count = 1;
		if (containsurlsetKey("url1")) {
			do {
				productvalues.info("Adding Alias Name entry " + count);
				addproducturls(geturlset("url" + count));
				count++;
			} while (containsurlsetKey("url" + count));
		} else {
			productvalues.info("Key Value pair is missing for Alias Names");
			throw new RuntimeException();
		}
		return this;
	}

	public ProductValues GetPremiumProductUrlsFromList() throws Exception {
		int count = 1;
		if (containsurlsetKey("premiumurl1")) {
			do {
				productvalues.info("Adding Alias Name entry " + count);
				addpremiumproducturls(geturlset("premiumurl" + count));
				count++;
			} while (containsurlsetKey("premiumurl" + count));
		} else {
			productvalues.info("Key Value pair is missing for Alias Names");
			throw new RuntimeException();
		}
		return this;
	}

	public ProductValues collecturls() throws Exception {
		try {
			File file = new File(userdir
					+ "\\src\\main\\resources\\sampleproducts.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();

			productvalues.info("Adding product urls in the list.");

			Enumeration<?> enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				// System.out.println(key + ": " + value);
				puturlset(key, value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}
}

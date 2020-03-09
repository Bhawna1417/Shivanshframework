package com.webdriver.CheckoutProcess;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import com.webdriver.Data.DataSetCollectors;
import com.webdriver.Data.ProductValues;
import com.webdriver.Page.ProductPage;
import com.webdriver.Page.TyreSelectorPage;
import com.webdriver.TyreSection.TyreListing;
import com.webdriver.TyreSection.TyreSelector;
import com.webdriver.UtilSection.GetRandom;

public class ProductSelectionType {

	WebDriver driver = null;

	ArrayList<Integer> productindexused = new ArrayList<Integer>();

	ArrayList<Integer> tyreindexused = new ArrayList<Integer>();

	ArrayList<Integer> premiumproductindexused = new ArrayList<Integer>();

	// ArrayList<String> producturls = new ArrayList<String>();
	//
	// ArrayList<String> premiumproducturls = new ArrayList<String>();

	int maxproduct = 0;

	ProductValues prodvalues = null;

	String baseurl = null;

	DataSetCollectors data = null;

	public ProductSelectionType(WebDriver driver, int maxproduct,
			ProductValues prodvalues, DataSetCollectors data, String baseurl)
			throws Exception {
		this.driver = driver;
		this.productindexused.clear();
		this.tyreindexused.clear();
		this.premiumproductindexused.clear();
		this.maxproduct = 0;
		// this.producturls = prodvalues.getProducturls();
		// this.premiumproducturls = prodvalues.getPremiumproducturls();
		this.prodvalues = prodvalues;
		this.baseurl = baseurl;
		this.data = data;
	}

	public ProductSelectionType RandomSelector(int selection) throws Exception {

		switch (selection) {
		case 0:
			ProductSelector();
			break;
		case 1:
			TyreSelector();
			break;
		case 2:
			PremiumProductSelector();
			break;
		case 3:

			break;
		default:
			break;
		}

		return this;
	}

	public ProductSelectionType ProductSelector() throws Exception {
		int index = 0;
		do {
			index = GetRandom.value(prodvalues.sizeproducturls(), -1);
		} while (productindexused.contains(index));
		productindexused.add(index);
		ProductPage.OpenProductDetailPage(driver,
				prodvalues.getproducturls(index));
		return this;
	}

	public ProductSelectionType TyreSelector() throws Exception {

		TyreSelector tyreselector = new TyreSelector(driver, data, baseurl);

		TyreListing listing = new TyreListing(driver);

		TyreSelectorPage.OpenTyreSelectorPage(driver, baseurl);

		tyreselector.CheckTyreSelectorsDisplayed().TyreSelectorSection()
				.CheckResultsDisplayed();

		listing.GetProductCount().SelectProduct();

		return this;
	}

	public ProductSelectionType PremiumProductSelector() throws Exception {
		int index = 0;
		do {
			index = GetRandom.value(prodvalues.sizepremiumproducturls(), -1);
		} while (premiumproductindexused.contains(index));
		premiumproductindexused.add(index);
		ProductPage.OpenProductDetailPage(driver,
				prodvalues.getpremiumproducturls(index));
		return this;
	}

}
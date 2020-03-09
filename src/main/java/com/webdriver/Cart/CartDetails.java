package com.webdriver.Cart;

import java.util.ArrayList;

public class CartDetails 
{
	ArrayList<String> productids = new ArrayList<String>();
	
	ArrayList<String> productnames = new ArrayList<String>();
	
	ArrayList<String> productnameseng = new ArrayList<String>();
	
	ArrayList<Integer> productquantity = new ArrayList<Integer>();
	
	ArrayList<Integer> productunitprices = new ArrayList<Integer>();
	
	ArrayList<Integer> producttotalprices = new ArrayList<Integer>();
	
	int discount = 0;
	
	int priceordersubtotal = 0;
	
	int pricetotaltax = 0;
	
	int grandtotal = 0;

	public ArrayList<String> getProductids() {
		return productids;
	}

	public void setProductids(ArrayList<String> productids) {
		this.productids = productids;
	}

	public ArrayList<String> getProductnames() {
		return productnames;
	}

	public void setProductnames(ArrayList<String> productnames) {
		this.productnames = productnames;
	}

	public ArrayList<String> getProductnameseng() {
		return productnameseng;
	}

	public void setProductnameseng(ArrayList<String> productnameseng) {
		this.productnameseng = productnameseng;
	}

	public ArrayList<Integer> getProductquantity() {
		return productquantity;
	}

	public void setProductquantity(ArrayList<Integer> productquantity) {
		this.productquantity = productquantity;
	}

	public ArrayList<Integer> getProductunitprices() {
		return productunitprices;
	}

	public void setProductunitprices(ArrayList<Integer> productunitprices) {
		this.productunitprices = productunitprices;
	}

	public ArrayList<Integer> getProducttotalprices() {
		return producttotalprices;
	}

	public void setProducttotalprices(ArrayList<Integer> producttotalprices) {
		this.producttotalprices = producttotalprices;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getPriceordersubtotal() {
		return priceordersubtotal;
	}

	public void setPriceordersubtotal(int priceordersubtotal) {
		this.priceordersubtotal = priceordersubtotal;
	}

	public int getPricetotaltax() {
		return pricetotaltax;
	}

	public void setPricetotaltax(int pricetotaltax) {
		this.pricetotaltax = pricetotaltax;
	}

	public int getGrandtotal() {
		return grandtotal;
	}

	public void setGrandtotal(int grandtotal) {
		this.grandtotal = grandtotal;
	}

	public boolean addproductids(String e) {
		return productids.add(e);
	}

	public void clearproductids() {
		productids.clear();
	}

	public int sizeproductids() {
		return productids.size();
	}

	public String getproductids(int index) {
		return productids.get(index);
	}

	public boolean addproductnames(String e) {
		return productnames.add(e);
	}

	public void clearproductnames() {
		productnames.clear();
	}

	public String getproductnames(int index) {
		return productnames.get(index);
	}

	public int sizeproductnames() {
		return productnames.size();
	}

	public boolean addproductquantity(Integer e) {
		return productquantity.add(e);
	}

	public void clearproductquantity() {
		productquantity.clear();
	}

	public Integer getproductquantity(int index) {
		return productquantity.get(index);
	}

	public int sizeproductquantity() {
		return productquantity.size();
	}

	public boolean addproductunitprices(Integer e) {
		return productunitprices.add(e);
	}

	public void clearproductunitprices() {
		productunitprices.clear();
	}

	public Integer getproductunitprices(int index) {
		return productunitprices.get(index);
	}

	public int sizeproductunitprices() {
		return productunitprices.size();
	}

	public boolean addproducttotalprices(Integer e) {
		return producttotalprices.add(e);
	}

	public void clearproducttotalprices() {
		producttotalprices.clear();
	}

	public Integer getproducttotalprices(int index) {
		return producttotalprices.get(index);
	}

	public int sizeproducttotalprices() {
		return producttotalprices.size();
	}
	
	public boolean addproductnameseng(String e) {
		return productnameseng.add(e);
	}

	public void clearproductnameseng() {
		productnameseng.clear();
	}

	public String getproductnameseng(int index) {
		return productnameseng.get(index);
	}

	public int sizeproductnameseng() {
		return productnameseng.size();
	}
}
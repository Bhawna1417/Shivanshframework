package com.webdriver.OrderConfirm;

import java.util.ArrayList;

public class ConfirmationOrderDetails {

	int ordernumber = 0;

	String orderdate = null;
	
	int productcount = 0;

	ArrayList<String> productname = new ArrayList<String>();
	
	ArrayList<String> productengname = new ArrayList<String>();
	
	ArrayList<String> productid = new ArrayList<String>();

	ArrayList<Integer> productquantity = new ArrayList<Integer>();

	ArrayList<Integer> productunitprice = new ArrayList<Integer>();
	
	ArrayList<Integer> productdiscountprice = new ArrayList<Integer>();

	ArrayList<Integer> producttotalprice = new ArrayList<Integer>();

	String paymentmethod = null;

	int ordertotal = 0;

	int discount = 0;

	String consigneename = null;

	int mobile1 = 0;

	int mobile2 = 0;

	String shippingaddress = null;

	public int getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(int ordernumber) {
		this.ordernumber = ordernumber;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public int getProductcount() {
		return productcount;
	}

	public void setProductcount(int productcount) {
		this.productcount = productcount;
	}

	public ArrayList<String> getProductname() {
		return productname;
	}

	public void setProductname(ArrayList<String> productname) {
		this.productname = productname;
	}

	public boolean addproductname(String e) {
		return productname.add(e);
	}

	public void clearproductname() {
		productname.clear();
	}

	public String getproductname(int index) {
		return productname.get(index);
	}

	public boolean isEmptyproductname() {
		return productname.isEmpty();
	}

	public String removeproductname(int index) {
		return productname.remove(index);
	}

	public int sizeproductname() {
		return productname.size();
	}

	public ArrayList<String> getProductengname() {
		return productengname;
	}

	public void setProductengname(ArrayList<String> productengname) {
		this.productengname = productengname;
	}

	public boolean addproductengname(String e) {
		return productengname.add(e);
	}

	public void clearproductengname() {
		productengname.clear();
	}

	public String getproductengname(int index) {
		return productengname.get(index);
	}

	public boolean isEmptyproductengname() {
		return productengname.isEmpty();
	}

	public String removeproductengname(int index) {
		return productengname.remove(index);
	}

	public int sizeproductengname() {
		return productengname.size();
	}

	public ArrayList<String> getProductid() {
		return productid;
	}

	public void setProductid(ArrayList<String> productid) {
		this.productid = productid;
	}

	public boolean addproductid(String e) {
		return productid.add(e);
	}

	public void clearproductid() {
		productid.clear();
	}

	public String getproductid(int index) {
		return productid.get(index);
	}

	public boolean isEmptyproductid() {
		return productid.isEmpty();
	}

	public String removeproductid(int index) {
		return productid.remove(index);
	}

	public int sizeproductid() {
		return productid.size();
	}

	public ArrayList<Integer> getProductquantity() {
		return productquantity;
	}

	public void setProductquantity(ArrayList<Integer> productquantity) {
		this.productquantity = productquantity;
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

	public boolean isEmptyproductquantity() {
		return productquantity.isEmpty();
	}

	public Integer removeproductquantity(int index) {
		return productquantity.remove(index);
	}

	public int sizeproductquantity() {
		return productquantity.size();
	}

	public ArrayList<Integer> getProducttotalprice() {
		return producttotalprice;
	}

	public void setProducttotalprice(ArrayList<Integer> producttotalprice) {
		this.producttotalprice = producttotalprice;
	}

	public boolean addproducttotalprice(Integer e) {
		return producttotalprice.add(e);
	}

	public void clearproducttotalprice() {
		producttotalprice.clear();
	}

	public boolean isEmptyproducttotalprice() {
		return producttotalprice.isEmpty();
	}

	public Integer removeproducttotalprice(int index) {
		return producttotalprice.remove(index);
	}

	public int sizeproducttotalprice() {
		return producttotalprice.size();
	}

	public ArrayList<Integer> getProductunitprice() {
		return productunitprice;
	}

	public void setProductunitprice(ArrayList<Integer> productunitprice) {
		this.productunitprice = productunitprice;
	}


	public int sizeproductunitprice() {
		return productunitprice.size();
	}

	public boolean isEmptyproductunitprice() {
		return productunitprice.isEmpty();
	}

	public Integer getproductunitprice(int index) {
		return productunitprice.get(index);
	}

	public boolean addproductunitprice(Integer e) {
		return productunitprice.add(e);
	}

	public Integer removeproductunitprice(int index) {
		return productunitprice.remove(index);
	}

	public void clearproductunitprice() {
		productunitprice.clear();
	}

	public ArrayList<Integer> getProductdiscountprice() {
		return productdiscountprice;
	}

	public void setProductdiscountprice(ArrayList<Integer> productdiscountprice) {
		this.productdiscountprice = productdiscountprice;
	}

	public int sizeproductdiscountprice() {
		return productdiscountprice.size();
	}

	public boolean isEmptyproductdiscountprice() {
		return productdiscountprice.isEmpty();
	}

	public Integer getproductdiscountprice(int index) {
		return productdiscountprice.get(index);
	}

	public boolean addproductdiscountprice(Integer e) {
		return productdiscountprice.add(e);
	}

	public Integer removeproductdiscountprice(int index) {
		return productdiscountprice.remove(index);
	}
	
	public void clearproductdiscountprice() {
		productdiscountprice.clear();
	}

	public String getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	public int getOrdertotal() {
		return ordertotal;
	}

	public void setOrdertotal(int ordertotal) {
		this.ordertotal = ordertotal;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getConsigneename() {
		return consigneename;
	}

	public void setConsigneename(String consigneename) {
		this.consigneename = consigneename;
	}

	public int getMobile1() {
		return mobile1;
	}

	public void setMobile1(int mobile1) {
		this.mobile1 = mobile1;
	}

	public int getMobile2() {
		return mobile2;
	}

	public void setMobile2(int mobile2) {
		this.mobile2 = mobile2;
	}

	public String getShippingaddress() {
		return shippingaddress;
	}

	public void setShippingaddress(String shippingaddress) {
		this.shippingaddress = shippingaddress;
	}

}
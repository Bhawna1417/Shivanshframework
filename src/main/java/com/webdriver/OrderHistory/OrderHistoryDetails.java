package com.webdriver.OrderHistory;

import java.util.ArrayList;

public class OrderHistoryDetails {

	ArrayList<Integer> ordernumber = new ArrayList<Integer>();

	ArrayList<String> orderdate = new ArrayList<String>();

	ArrayList<String> ordername = new ArrayList<String>();

	ArrayList<String> paymentmethod = new ArrayList<String>();

	ArrayList<Integer> ordertotal = new ArrayList<Integer>();

	ArrayList<String> orderstatus = new ArrayList<String>();

	ArrayList<String> productname = new ArrayList<String>();

	ArrayList<String> productengname = new ArrayList<String>();

	ArrayList<String> productid = new ArrayList<String>();

	ArrayList<Integer> productquantity = new ArrayList<Integer>();

	ArrayList<Integer> producttotalprice = new ArrayList<Integer>();

	ArrayList<Integer> productprice = new ArrayList<Integer>();

	int discount = 0;

	String consigneename = null;

	int mobile1 = 0;

	int mobile2 = 0;

	String shippingaddress = null;

	public ArrayList<String> getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(ArrayList<String> orderdate) {
		this.orderdate = orderdate;
	}

	public boolean addorderdate(String e) {
		return orderdate.add(e);
	}

	public void clearorderdate() {
		orderdate.clear();
	}

	public String getorderdate(int index) {
		return orderdate.get(index);
	}

	public boolean isEmptyorderdate() {
		return orderdate.isEmpty();
	}

	public String removeorderdate(int index) {
		return orderdate.remove(index);
	}

	public int sizeorderdate() {
		return orderdate.size();
	}

	public ArrayList<String> getOrdername() {
		return ordername;
	}

	public void setOrdername(ArrayList<String> ordername) {
		this.ordername = ordername;
	}

	public boolean addordername(String e) {
		return ordername.add(e);
	}

	public void clearordername() {
		ordername.clear();
	}

	public String getordername(int index) {
		return ordername.get(index);
	}

	public boolean isEmptyordername() {
		return ordername.isEmpty();
	}

	public String removeordername(int index) {
		return ordername.remove(index);
	}

	public int sizeordername() {
		return ordername.size();
	}

	public ArrayList<Integer> getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(ArrayList<Integer> ordernumber) {
		this.ordernumber = ordernumber;
	}

	public boolean addordernumber(Integer e) {
		return ordernumber.add(e);
	}

	public void clearordernumber() {
		ordernumber.clear();
	}

	public Integer getordernumber(int index) {
		return ordernumber.get(index);
	}

	public boolean isEmptyordernumber() {
		return ordernumber.isEmpty();
	}

	public Integer removeordernumber(int index) {
		return ordernumber.remove(index);
	}

	public int sizeordernumber() {
		return ordernumber.size();
	}

	public ArrayList<String> getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(ArrayList<String> orderstatus) {
		this.orderstatus = orderstatus;
	}

	public boolean addorderstatus(String e) {
		return orderstatus.add(e);
	}

	public void clearorderstatus() {
		orderstatus.clear();
	}

	public String getorderstatus(int index) {
		return orderstatus.get(index);
	}

	public boolean isEmptyorderstatus() {
		return orderstatus.isEmpty();
	}

	public String removeorderstatus(int index) {
		return orderstatus.remove(index);
	}

	public int sizeorderstatus() {
		return orderstatus.size();
	}

	public ArrayList<Integer> getOrdertotal() {
		return ordertotal;
	}

	public void setOrdertotal(ArrayList<Integer> ordertotal) {
		this.ordertotal = ordertotal;
	}

	public boolean addordertotal(Integer e) {
		return ordertotal.add(e);
	}

	public void clearordertotal() {
		ordertotal.clear();
	}

	public Integer getordertotal(int index) {
		return ordertotal.get(index);
	}

	public boolean isEmptyordertotal() {
		return ordertotal.isEmpty();
	}

	public Integer removeordertotal(int index) {
		return ordertotal.remove(index);
	}

	public int sizeordertotal() {
		return ordertotal.size();
	}

	public ArrayList<String> getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(ArrayList<String> paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	public boolean addpaymentmethod(String e) {
		return paymentmethod.add(e);
	}

	public void clearpaymentmethod() {
		paymentmethod.clear();
	}

	public String getpaymentmethod(int index) {
		return paymentmethod.get(index);
	}

	public boolean isEmptypaymentmethod() {
		return paymentmethod.isEmpty();
	}

	public String removepaymentmethod(int index) {
		return paymentmethod.remove(index);
	}

	public int sizepaymentmethod() {
		return paymentmethod.size();
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

	public ArrayList<Integer> getProductprice() {
		return productprice;
	}

	public void setProductprice(ArrayList<Integer> productprice) {
		this.productprice = productprice;
	}

	public boolean addproductprice(Integer e) {
		return productprice.add(e);
	}

	public void clearproductprice() {
		productprice.clear();
	}

	public Integer getproductprice(int index) {
		return productprice.get(index);
	}

	public boolean isEmptyproductprice() {
		return productprice.isEmpty();
	}

	public Integer removeproductprice(int index) {
		return productprice.remove(index);
	}

	public int sizeproductprice() {
		return productprice.size();
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
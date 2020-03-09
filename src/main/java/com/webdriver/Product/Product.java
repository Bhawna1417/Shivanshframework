package com.webdriver.Product;

import java.util.ArrayList;

public class Product 
{
	int productcount = 0;
	
	ArrayList<String> productid = new ArrayList<String>();
	
	ArrayList<String> productname = new ArrayList<String>();
	
	ArrayList<String> productnameeng = new ArrayList<String>();
	
	ArrayList<String> productcategoryname = new ArrayList<String>();
	
	ArrayList<Integer> productquantity = new ArrayList<Integer>();
	
	ArrayList<Integer> productcost = new ArrayList<Integer>();
	
	ArrayList<Integer> productstockcurrent = new ArrayList<Integer>();

	public int getProductcount() {
		return productcount;
	}

	public void setProductcount(int productcount) {
		this.productcount = productcount;
	}

	public ArrayList<String> getProductid() {
		return productid;
	}

	public void setProductid(ArrayList<String> productid) {
		this.productid = productid;
	}

	public ArrayList<String> getProductname() {
		return productname;
	}

	public void setProductname(ArrayList<String> productname) {
		this.productname = productname;
	}

	public ArrayList<String> getProductnameeng() {
		return productnameeng;
	}

	public void setProductnameeng(ArrayList<String> productnameeng) {
		this.productnameeng = productnameeng;
	}

	public ArrayList<String> getProductcategoryname() {
		return productcategoryname;
	}

	public void setProductcategoryname(ArrayList<String> productcategoryname) {
		this.productcategoryname = productcategoryname;
	}

	public ArrayList<Integer> getProductquantity() {
		return productquantity;
	}

	public void setProductquantity(ArrayList<Integer> productquantity) {
		this.productquantity = productquantity;
	}

	public ArrayList<Integer> getProductcost() {
		return productcost;
	}

	public void setProductcost(ArrayList<Integer> productcost) {
		this.productcost = productcost;
	}

	public ArrayList<Integer> getProductstockcurrent() {
		return productstockcurrent;
	}

	public void setProductstockcurrent(ArrayList<Integer> productstockcurrent) {
		this.productstockcurrent = productstockcurrent;
	}
	
	public boolean addproductid(String e) {
		return productid.add(e);
	}

	public void clearproductid() {
		productid.clear();
	}

	public boolean containsproductid(Object o) {
		return productid.contains(o);
	}

	public String getproductid(int index) {
		return productid.get(index);
	}

	public int indexOfproductid(Object o) {
		return productid.indexOf(o);
	}

	public boolean isEmptyproductid() {
		return productid.isEmpty();
	}

	public String removeproductid(int index) {
		return productcategoryname.remove(index);
	}

	public int sizeproductid() {
		return productcategoryname.size();
	}
	
	public boolean addproductname(String e) {
		return productname.add(e);
	}

	public void clearproductname() {
		productname.clear();
	}

	public boolean containsproductname(Object o) {
		return productname.contains(o);
	}

	public String getproductname(int index) {
		return productname.get(index);
	}

	public int indexOfproductname(Object o) {
		return productname.indexOf(o);
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
	
	public boolean addproductnameeng(String e) {
		return productnameeng.add(e);
	}

	public void clearproductnameeng() {
		productnameeng.clear();
	}

	public boolean containsproductnameeng(Object o) {
		return productnameeng.contains(o);
	}

	public String getproductnameeng(int index) {
		return productnameeng.get(index);
	}

	public int indexOfproductnameeng(Object o) {
		return productnameeng.indexOf(o);
	}

	public boolean isEmptyproductnameeng() {
		return productnameeng.isEmpty();
	}

	public String removeproductnameeng(int index) {
		return productnameeng.remove(index);
	}

	public int sizeproductnameeng() {
		return productnameeng.size();
	}
	
	public boolean addproductcategoryname(String e) {
		return productcategoryname.add(e);
	}

	public void clearproductcategoryname() {
		productcategoryname.clear();
	}

	public boolean containsproductcategoryname(Object o) {
		return productcategoryname.contains(o);
	}

	public String getproductcategoryname(int index) {
		return productcategoryname.get(index);
	}

	public int indexOfproductcategoryname(Object o) {
		return productcategoryname.indexOf(o);
	}

	public boolean isEmptyproductcategoryname() {
		return productcategoryname.isEmpty();
	}

	public String removeproductcategoryname(int index) {
		return productcategoryname.remove(index);
	}

	public int sizeproductcategoryname() {
		return productcategoryname.size();
	}
	
	public boolean addproductquantity(Integer e) {
		return productquantity.add(e);
	}

	public void clearproductquantity() {
		productquantity.clear();
	}

	public boolean containsproductquantity(Object o) {
		return productquantity.contains(o);
	}

	public Integer getproductquantity(int index) {
		return productquantity.get(index);
	}

	public int indexOfproductquantity(Object o) {
		return productquantity.indexOf(o);
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
	
	public boolean addproductcost(Integer e) {
		return productcost.add(e);
	}

	public void clearproductcost() {
		productcost.clear();
	}

	public boolean containsproductcost(Object o) {
		return productcost.contains(o);
	}

	public Integer getproductcost(int index) {
		return productcost.get(index);
	}

	public int indexOfproductcost(Object o) {
		return productcost.indexOf(o);
	}

	public boolean isEmptyproductcost() {
		return productcost.isEmpty();
	}

	public Integer removeproductcost(int index) {
		return productcost.remove(index);
	}

	public int sizeproductcost() {
		return productcost.size();
	}
	
	public boolean addproductstockcurrent(Integer e) {
		return productstockcurrent.add(e);
	}

	public void clearproductstockcurrent() {
		productstockcurrent.clear();
	}

	public boolean containsproductstockcurrent(Object o) {
		return productstockcurrent.contains(o);
	}

	public Integer getproductstockcurrent(int index) {
		return productstockcurrent.get(index);
	}

	public int indexOfproductstockcurrent(Object o) {
		return productstockcurrent.indexOf(o);
	}

	public boolean isEmptyproductstockcurrent() {
		return productstockcurrent.isEmpty();
	}

	public Integer removeproductstockcurrent(int index) {
		return productstockcurrent.remove(index);
	}

	public int sizeproductstockcurrent() {
		return productstockcurrent.size();
	}
}
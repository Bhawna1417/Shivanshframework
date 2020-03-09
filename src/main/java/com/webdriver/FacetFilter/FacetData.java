package com.webdriver.FacetFilter;

import java.util.ArrayList;
import org.openqa.selenium.WebElement;

public class FacetData {

	ArrayList<WebElement> facets = new ArrayList<WebElement>();

	ArrayList<String> facetnames = new ArrayList<String>();

	ArrayList<String> facettext = new ArrayList<String>();

	ArrayList<Integer> facetvaluecount = new ArrayList<Integer>();
	
	int facetcount = 0;

	public int getFacetcount() {
		return facetcount;
	}

	public void setFacetcount(int facetcount) {
		this.facetcount = facetcount;
	}

	public ArrayList<WebElement> getFacets() {
		return facets;
	}

	public void setFacets(ArrayList<WebElement> facets) {
		this.facets = facets;
	}

	public boolean addfacets(WebElement e) {
		return facets.add(e);
	}

	public void clearfacets() {
		facets.clear();
	}

	public WebElement getfacets(int index) {
		return facets.get(index);
	}

	public WebElement removefacets(int index) {
		return facets.remove(index);
	}

	public int sizefacets() {
		return facets.size();
	}

	public ArrayList<String> getFacetnames() {
		return facetnames;
	}

	public void setFacetnames(ArrayList<String> facetnames) {
		this.facetnames = facetnames;
	}

	public boolean addfacetnames(String e) {
		return facetnames.add(e);
	}

	public void clearfacetnames() {
		facetnames.clear();
	}

	public String getfacetnames(int index) {
		return facetnames.get(index);
	}

	public String removefacetnames(int index) {
		return facetnames.remove(index);
	}

	public int sizefacetnames() {
		return facetnames.size();
	}

	public ArrayList<String> getFacettext() {
		return facettext;
	}

	public void setFacettext(ArrayList<String> facettext) {
		this.facettext = facettext;
	}

	public boolean addfacettext(String e) {
		return facettext.add(e);
	}

	public void clearfacettext() {
		facettext.clear();
	}

	public String getfacettext(int index) {
		return facettext.get(index);
	}

	public String removefacettext(int index) {
		return facettext.remove(index);
	}

	public int sizefacettext() {
		return facettext.size();
	}

	public ArrayList<Integer> getFacetvaluecount() {
		return facetvaluecount;
	}

	public void setFacetvaluecount(ArrayList<Integer> facetvaluecount) {
		this.facetvaluecount = facetvaluecount;
	}

	public boolean addfacetvaluecount(Integer e) {
		return facetvaluecount.add(e);
	}

	public void clearfacetvaluecount() {
		facetvaluecount.clear();
	}

	public Integer getfacetvaluecount(int index) {
		return facetvaluecount.get(index);
	}

	public Integer removefacetvaluecount(int index) {
		return facetvaluecount.remove(index);
	}

	public int sizefacetvaluecount() {
		return facetvaluecount.size();
	}

}
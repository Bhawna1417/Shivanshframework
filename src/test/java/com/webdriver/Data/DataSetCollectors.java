package com.webdriver.Data;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.webdriver.SetupData.MappingData;

public class DataSetCollectors extends MappingData {

	Logger dataset = Logger.getLogger(DataSetCollectors.class);

	int maxproduct = 0;
	int maxquantity = 0;

	ArrayList<String> firstname = new ArrayList<String>();
	ArrayList<String> lastname = new ArrayList<String>();
	String regsiteremail1 = null;
	String registeremail2 = null;
	String password = null;
	ArrayList<String> userlist = new ArrayList<String>();
	ArrayList<String> passwordlist = new ArrayList<String>();
	ArrayList<String> aliaslist = new ArrayList<String>();
	ArrayList<String> namelist = new ArrayList<String>();
	ArrayList<String> mobilelist = new ArrayList<String>();
	// ArrayList<String> otherlist = new ArrayList<String>();
	ArrayList<String> postcodelist = new ArrayList<String>();
	ArrayList<String> addline1list = new ArrayList<String>();
	ArrayList<String> addline2list = new ArrayList<String>();
	ArrayList<String> emaillist = new ArrayList<String>();
	ArrayList<String> vehicelregnolist = new ArrayList<String>();
	ArrayList<String> searchtermslist = new ArrayList<String>();

	public ArrayList<String> getFirstname() {
		return firstname;
	}

	public void setFirstname(ArrayList<String> firstname) {
		this.firstname = firstname;
	}

	public boolean addfirstname(String e) {
		return firstname.add(e);
	}

	public void clearfirstname() {
		firstname.clear();
	}

	public String getfirstname(int index) {
		return firstname.get(index);
	}

	public boolean isEmptyfirstname() {
		return firstname.isEmpty();
	}

	public boolean removefirstname(Object o) {
		return firstname.remove(o);
	}

	public int sizefirstname() {
		return firstname.size();
	}

	public ArrayList<String> getLastname() {
		return lastname;
	}

	public void setLastname(ArrayList<String> lastname) {
		this.lastname = lastname;
	}

	public boolean addlastname(String e) {
		return lastname.add(e);
	}

	public void clearlastname() {
		lastname.clear();
	}

	public String getlastname(int index) {
		return lastname.get(index);
	}

	public boolean isEmptylastname() {
		return lastname.isEmpty();
	}

	public boolean removelastname(Object o) {
		return lastname.remove(o);
	}

	public int sizelastname() {
		return lastname.size();
	}

	public String getRegsiteremail1() {
		return regsiteremail1;
	}

	public void setRegsiteremail1(String regsiteremail1) {
		this.regsiteremail1 = regsiteremail1;
	}

	public String getRegisteremail2() {
		return registeremail2;
	}

	public void setRegisteremail2(String registeremail2) {
		this.registeremail2 = registeremail2;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMaxproduct() {
		return maxproduct;
	}

	public void setMaxproduct(int maxproduct) {
		this.maxproduct = maxproduct;
	}

	public int getMaxquantity() {
		return maxquantity;
	}

	public void setMaxquantity(int maxquantity) {
		this.maxquantity = maxquantity;
	}

	public ArrayList<String> getUserlist() {
		return userlist;
	}

	public void setUserlist(ArrayList<String> userlist) {
		this.userlist = userlist;
	}

	public int sizeuserlist() {
		return userlist.size();
	}

	public boolean isEmptyuserlist() {
		return userlist.isEmpty();
	}

	public String getuserlist(int index) {
		return userlist.get(index);
	}

	public boolean adduserlist(String e) {
		return userlist.add(e);
	}

	public String removeuserlist(int index) {
		return userlist.remove(index);
	}

	public void clearuserlist() {
		userlist.clear();
	}

	public ArrayList<String> getPasswordlist() {
		return passwordlist;
	}

	public void setPasswordlist(ArrayList<String> passwordlist) {
		this.passwordlist = passwordlist;
	}

	public int sizepasswordlist() {
		return passwordlist.size();
	}

	public boolean isEmptypasswordlist() {
		return passwordlist.isEmpty();
	}

	public String getpasswordlist(int index) {
		return passwordlist.get(index);
	}

	public boolean addpasswordlist(String e) {
		return passwordlist.add(e);
	}

	public String removepasswordlist(int index) {
		return passwordlist.remove(index);
	}

	public void clearpasswordlist() {
		passwordlist.clear();
	}

	public ArrayList<String> getAliaslist() {
		return aliaslist;
	}

	public void setAliaslist(ArrayList<String> aliaslist) {
		this.aliaslist = aliaslist;
	}

	public int sizealiaslist() {
		return aliaslist.size();
	}

	public boolean isEmptyaliaslist() {
		return aliaslist.isEmpty();
	}

	public String getaliaslist(int index) {
		return aliaslist.get(index);
	}

	public boolean addaliaslist(String e) {
		return aliaslist.add(e);
	}

	public String removealiaslist(int index) {
		return aliaslist.remove(index);
	}

	public void clearaliaslist() {
		aliaslist.clear();
	}

	public ArrayList<String> getNamelist() {
		return namelist;
	}

	public void setNamelist(ArrayList<String> namelist) {
		this.namelist = namelist;
	}

	public int sizenamelist() {
		return namelist.size();
	}

	public boolean isEmptynamelist() {
		return namelist.isEmpty();
	}

	public String getnamelist(int index) {
		return namelist.get(index);
	}

	public boolean addnamelist(String e) {
		return namelist.add(e);
	}

	public String removenamelist(int index) {
		return namelist.remove(index);
	}

	public void clearnamelist() {
		namelist.clear();
	}

	public ArrayList<String> getMobilelist() {
		return mobilelist;
	}

	public void setMobilelist(ArrayList<String> mobilelist) {
		this.mobilelist = mobilelist;
	}

	public int sizemobilelist() {
		return mobilelist.size();
	}

	public boolean isEmptymobilelist() {
		return mobilelist.isEmpty();
	}

	public String getmobilelist(int index) {
		return mobilelist.get(index);
	}

	public boolean addmobilelist(String e) {
		return mobilelist.add(e);
	}

	public String removemobilelist(int index) {
		return mobilelist.remove(index);
	}

	public void clearmobilelist() {
		mobilelist.clear();
	}

	// public ArrayList<String> getOtherlist() {
	// return otherlist;
	// }
	//
	// public void setOtherlist(ArrayList<String> otherlist) {
	// this.otherlist = otherlist;
	// }
	//
	// public int sizeotherlist() {
	// return otherlist.size();
	// }
	//
	// public boolean isEmptyotherlist() {
	// return otherlist.isEmpty();
	// }
	//
	// public String getotherlist(int index) {
	// return otherlist.get(index);
	// }
	//
	// public boolean addotherlist(String e) {
	// return otherlist.add(e);
	// }
	//
	// public String removeotherlist(int index) {
	// return otherlist.remove(index);
	// }
	//
	// public void clearotherlist() {
	// otherlist.clear();
	// }

	public ArrayList<String> getPostcodelist() {
		return postcodelist;
	}

	public void setPostcodelist(ArrayList<String> postcodelist) {
		this.postcodelist = postcodelist;
	}

	public int sizepostcodelist() {
		return postcodelist.size();
	}

	public boolean isEmptypostcodelist() {
		return postcodelist.isEmpty();
	}

	public String getpostcodelist(int index) {
		return postcodelist.get(index);
	}

	public boolean addpostcodelist(String e) {
		return postcodelist.add(e);
	}

	public String removepostcodelist(int index) {
		return postcodelist.remove(index);
	}

	public void clearpostcodelist() {
		postcodelist.clear();
	}

	public ArrayList<String> getAddline1list() {
		return addline1list;
	}

	public void setAddline1list(ArrayList<String> addline1list) {
		this.addline1list = addline1list;
	}

	public int sizeaddline1list() {
		return addline1list.size();
	}

	public boolean isEmptyaddline1list() {
		return addline1list.isEmpty();
	}

	public String getaddline1list(int index) {
		return addline1list.get(index);
	}

	public boolean addaddline1list(String e) {
		return addline1list.add(e);
	}

	public String removeaddline1list(int index) {
		return addline1list.remove(index);
	}

	public void clearaddline1list() {
		addline1list.clear();
	}

	public ArrayList<String> getAddline2list() {
		return addline2list;
	}

	public void setAddline2list(ArrayList<String> addline2list) {
		this.addline2list = addline2list;
	}

	public int sizeaddline2list() {
		return addline2list.size();
	}

	public boolean isEmptyaddline2list() {
		return addline2list.isEmpty();
	}

	public String getaddline2list(int index) {
		return addline2list.get(index);
	}

	public boolean addaddline2list(String e) {
		return addline2list.add(e);
	}

	public String removeaddline2list(int index) {
		return addline2list.remove(index);
	}

	public void clearaddline2list() {
		addline2list.clear();
	}

	public ArrayList<String> getEmaillist() {
		return emaillist;
	}

	public void setEmaillist(ArrayList<String> emaillist) {
		this.emaillist = emaillist;
	}

	public int sizeemaillist() {
		return emaillist.size();
	}

	public boolean isEmptyemaillist() {
		return emaillist.isEmpty();
	}

	public String getemaillist(int index) {
		return emaillist.get(index);
	}

	public boolean addemaillist(String e) {
		return emaillist.add(e);
	}

	public String removeemaillist(int index) {
		return emaillist.remove(index);
	}

	public void clearemaillist() {
		emaillist.clear();
	}

	public ArrayList<String> getVehicelregnolist() {
		return vehicelregnolist;
	}

	public void setVehicelregnolist(ArrayList<String> vehicelregnolist) {
		this.vehicelregnolist = vehicelregnolist;
	}

	public boolean addvehicelregnolist(String e) {
		return vehicelregnolist.add(e);
	}

	public void clearvehicelregnolist() {
		vehicelregnolist.clear();
	}

	public String getvehicelregnolist(int index) {
		return vehicelregnolist.get(index);
	}

	public boolean isEmptyvehicelregnolist() {
		return vehicelregnolist.isEmpty();
	}

	public String removevehicelregnolist(int index) {
		return vehicelregnolist.remove(index);
	}

	public int sizevehicelregnolist() {
		return vehicelregnolist.size();
	}
	
	public ArrayList<String> getSearchtermslist() {
		return searchtermslist;
	}

	public void setSearchtermslist(ArrayList<String> searchtermslist) {
		this.searchtermslist = searchtermslist;
	}	

	public boolean addsearchtermslist(String e) {
		return searchtermslist.add(e);
	}

	public void clearsearchtermslist() {
		searchtermslist.clear();
	}

	public String getsearchtermslist(int index) {
		return searchtermslist.get(index);
	}

	public boolean isEmptysearchtermslist() {
		return searchtermslist.isEmpty();
	}

	public String removesearchtermslist(int index) {
		return searchtermslist.remove(index);
	}

	public int sizesearchtermslist() {
		return searchtermslist.size();
	}

	public DataSetCollectors GetFirstNamesFromDataSet() throws Exception {
		int count = 1;
		if (containsdatasetKey("first1")) {
			do {
				dataset.info("Adding First Name entry " + count);
				String first = getdataset("first" + count);
				// System.out.println("User name at " + count + " is " + user);
				addfirstname(first);
				count++;
			} while (containsdatasetKey("first" + count));
		} else {
			dataset.info("Key Value pair is missing for First Names");
			throw new RuntimeException();
		}
		return this;
	}

	public DataSetCollectors GetLastNamesFromDataSet()
			throws Exception {
		int count = 1;
		if (containsdatasetKey("last1")) {
			do {
				dataset.info("Adding Last Name entry " + count);
				String last = getdataset("last" + count);
				// System.out.println("User name at " + count + " is " + user);
				addlastname(last);
				count++;
			} while (containsdatasetKey("last" + count));
		} else {
			dataset.info("Key Value pair is missing for Last Names");
			throw new RuntimeException();
		}
		return this;
	}

	public DataSetCollectors GetRegistrationEmail1FromDataSet()
			throws Exception {
		if (containsdatasetKey("regemail1")) {
			String getemail1 = getdataset("regemail1");
			if (getemail1 != null && !getemail1.isEmpty()) {
				dataset.info("Setting Registration Email 1 to " + getemail1
						+ " as per data set");
				setRegsiteremail1(getemail1);
			} else {
				setRegsiteremail1("test");
				dataset.info("Blank observed for Email 1. Hence Registration Email 1 set to as \"test\"");
			}
		} else {
			setRegsiteremail1("test");
			dataset.info("Key Value pair is missing Email 1. Hence Registration Email 1 set to as \"Test\"");
		}
		return this;
	}

	public DataSetCollectors GetRegistrationEmail2FromDataSet()
			throws Exception {
		if (containsdatasetKey("regemail2")) {
			String getemail2 = getdataset("regemail2");
			if (getemail2 != null && !getemail2.isEmpty()) {
				dataset.info("Setting Registration Email 2 to " + getemail2
						+ " as per data set");
				setRegisteremail2(getemail2);
			} else {
				setRegisteremail2("@test.com");
				dataset.info("Blank observed for Email 2. Hence Registration Email 2 set to as \"@test.com\"");
			}
		} else {
			setRegisteremail2("@test.com");
			dataset.info("Key Value pair is missing Email 2. Hence Registration Email 2 set to as \"@test.com\"");
		}
		return this;
	}

	public DataSetCollectors GetRegistrationPasswordFromDataSet()
			throws Exception {
		if (containsdatasetKey("regpassword")) {
			String getpassword = getdataset("regpassword");
			if (getpassword != null && !getpassword.isEmpty()) {
				dataset.info("Setting Registration PAssword to " + getpassword
						+ " as per data set");
				setPassword(getpassword);
			} else {
				setPassword("a1234567");
				dataset.info("Blank observed for Password. Hence Registration password set to as \"a1234567\"");
			}
		} else {
			setPassword("a1234567");
			dataset.info("Key Value pair is missing password. Hence Registration password set to as \"a1234567\"");
		}
		return this;
	}

	public DataSetCollectors GetUserNamesFromDataSet() throws Exception {
		int count = 1;
		if (containsdatasetKey("user1")) {
			do {
				dataset.info("Adding User Name entry " + count);
				String user = getdataset("user" + count);
				// System.out.println("User name at " + count + " is " + user);
				adduserlist(user);
				count++;
			} while (containsdatasetKey("user" + count));
		} else {
			dataset.info("Key Value pair is missing for UserName");
			throw new RuntimeException();
		}
		return this;
	}

	public DataSetCollectors GetPasswordsFromDataSet() throws Exception {
		int count = 1;
		if (containsdatasetKey("pass1")) {
			do {
				dataset.info("Adding Password entry " + count);
				String pass = getdataset("pass" + count);
				// System.out.println("User name at " + count + " is " + pass);
				addpasswordlist(pass);
				count++;
			} while (containsdatasetKey("pass" + count));
		} else {
			dataset.info("Key Value pair is missing for Password");
			throw new RuntimeException();
		}
		return this;
	}

	public DataSetCollectors GetMaxProductFromDataSet() throws Exception {
		if (containsdatasetKey("maxproduct")) {
			String getproductcount = getdataset("maxproduct");
			if (!getproductcount.isEmpty()) {
				int getvalue = Integer.parseInt(getproductcount);
				dataset.info("Setting Max Product Count to " + getvalue
						+ " as per data set");
				setMaxproduct(getvalue);
			} else {
				setMaxproduct(10);
				dataset.info("Blank observed for Product. Hence maximum products are set to 10");
			}
		} else {
			setMaxproduct(10);
			dataset.info("Key Value pair is missing for Product. Hence maximum products are set to 10");
		}
		return this;
	}

	public DataSetCollectors GetMaxQuantityFromDataSet() throws Exception {
		if (containsdatasetKey("maxquantity")) {
			String getquantity = getdataset("maxquantity");
			if (!getquantity.isEmpty()) {
				int getvalue = Integer.parseInt(getdataset("maxquantity"));
				dataset.info("Setting Max Quantity to " + getvalue
						+ " as per data set");
				setMaxquantity(getvalue);
			} else {
				setMaxquantity(10);
				dataset.info("Blank observed for Quantity. Hence maximum quantity is to 10");
			}
		} else {
			setMaxquantity(10);
			dataset.info("Key Value pair is missing for Quantity. Hence maximum quantity is to 10");
		}
		return this;
	}

	public DataSetCollectors GetAliasNamesFromDataSet() throws Exception {
		int count = 1;
		if (containsdatasetKey("alias1")) {
			do {
				dataset.info("Adding Alias Name entry " + count);
				addaliaslist(getdataset("alias" + count));
				count++;
			} while (containsdatasetKey("alias" + count));
		} else {
			dataset.info("Key Value pair is missing for Alias Names");
			throw new RuntimeException();
		}
		return this;
	}

	public DataSetCollectors GetCosgineeNamesFromDataSet() throws Exception {
		int count = 1;
		if (containsdatasetKey("name1")) {
			do {
				dataset.info("Adding Cosignee Name entry " + count);
				addnamelist(getdataset("name" + count));
				count++;
			} while (containsdatasetKey("name" + count));
		} else {
			dataset.info("Key Value pair is missing for Cosingee Names");
			throw new RuntimeException();
		}
		return this;
	}

	public DataSetCollectors GetMobileNumberFromDataSet() throws Exception {
		int count = 1;
		if (containsdatasetKey("mobile1")) {
			do {
				dataset.info("Adding Mobile Number entry " + count);
				addmobilelist(getdataset("mobile" + count));
				count++;
			} while (containsdatasetKey("mobile" + count));
		} else {
			dataset.info("Key Value pair is missing for Mobile Numbers");
			throw new RuntimeException();
		}
		return this;
	}

	public DataSetCollectors GetPostCodesFromDataSet() throws Exception {
		int count = 1;
		if (containsdatasetKey("post1")) {
			do {
				dataset.info("Adding Post Code entry " + count);
				addpostcodelist(getdataset("post" + count));
				count++;
			} while (containsdatasetKey("post" + count));
		} else {
			dataset.info("Key Value pair is missing for Post Codes");
			throw new RuntimeException();
		}
		return this;
	}

	public DataSetCollectors GetAddressLine1FromDataSet() throws Exception {
		int count = 1;
		if (containsdatasetKey("add1line1")) {
			do {
				dataset.info("Adding Address Line1 entry " + count);
				addpostcodelist(getdataset("add1line" + count));
				count++;
			} while (containsdatasetKey("add1line" + count));
		} else {
			dataset.info("Key Value pair is missing for Address Line1");
			throw new RuntimeException();
		}
		return this;
	}

	public DataSetCollectors GetAddressLine2FromDataSet() throws Exception {
		int count = 1;
		if (containsdatasetKey("add2line1")) {
			do {
				dataset.info("Adding Address Line2 entry " + count);
				addpostcodelist(getdataset("add2line" + count));
				count++;
			} while (containsdatasetKey("add2line" + count));
		} else {
			dataset.info("Key Value pair is missing for Address Line2");
			throw new RuntimeException();
		}
		return this;
	}

	public DataSetCollectors GetEmailRecipientsFromDataSet() throws Exception {
		int count = 1;
		if (containsdatasetKey("email1")) {
			do {
				dataset.info("Adding Email Recipient entry " + count);
				String user = getdataset("email" + count);
				// System.out.println("User name at " + count + " is " + user);
				addemaillist(user);
				count++;
			} while (containsdatasetKey("email" + count));
		} else {
			dataset.info("Key Value pair is missing for Email Recipients");
			throw new RuntimeException();
		}
		return this;
	}

	public DataSetCollectors GetVehicleRegistrationNumbersFromDataSet()
			throws Exception {
		int count = 1;
		if (containsdatasetKey("vehicle1")) {
			do {
				dataset.info("Adding Vehicle Registration Number entry "
						+ count);
				String regno = getdataset("vehicle" + count);
				// System.out.println("User name at " + count + " is " + user);
				addvehicelregnolist(regno);
				count++;
			} while (containsdatasetKey("vehicle" + count));
		} else {
			dataset.info("Key Value pair is missing for Vehicle Registration Numbers");
			// throw new RuntimeException();
		}
		return this;
	}

	public DataSetCollectors GetSearchTermsFromDataSet() throws Exception {
		int count = 1;
		if (containsdatasetKey("searchterm1")) {
			do {
				dataset.info("Adding Search Terms entry " + count);
				String searchterm = getdataset("searchterm" + count);
				// System.out.println("User name at " + count + " is " + user);
				addsearchtermslist(searchterm);
				count++;
			} while (containsdatasetKey("searchterm" + count));
		} else {
			dataset.info("Key Value pair is missing for Search Terms");
			throw new RuntimeException();
		}
		return this;
	}
	
}
package com.webdriver.Page;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.Data.DataSetCollectors;
import com.webdriver.MyAccount.AddNewAddress;
import com.webdriver.MyAccount.BillingAddressBook;
import com.webdriver.MyAccount.DeliveryAddressBook;
import com.webdriver.MyAccount.LoginDetails;
import com.webdriver.MyAccount.MemberShipDetails;
import com.webdriver.MyAccount.MyAccount;
import com.webdriver.MyAccount.ContactDetails;
import com.webdriver.SetupData.MappingData;
import com.webdriver.UtilSection.GetRandom;
import com.webdriver.WishList.WishList;

public class MyAccountPage extends MappingData {
	WebDriver driver = null;
	ArrayList<WebElement> sections = new ArrayList<WebElement>();
	Logger myacclog = Logger.getLogger(getClass());

	MyAccount myacc = null;
	AddNewAddress addnew = null;
	WishList wish = null;
	DataSetCollectors data = null;

	public MyAccountPage(WebDriver driver, DataSetCollectors data) {
		this.driver = driver;
		this.myacc = new MyAccount(driver);
		this.addnew = new AddNewAddress(driver, null);
		this.data = data;
		this.sections.clear();
	}

	public MyAccountPage OpenMyAccountPage(String url) {
		// driver.get(url + "/my-account");
		if (!driver.getTitle().toLowerCase().trim().contains("account")) {
			driver.findElement(By.id(getidentifier("myaccount.id.link")))
					.click();

			if (!driver.getTitle().toLowerCase().trim().contains("account")) {
				driver.get(url + "/view/secured/content/myaccount");
			}
		}
		return this;
	}

	public MyAccountPage MyAccountElements() {

		List<WebElement> sectionslist = driver
				.findElement(
						By.className(getidentifier("myaccount.class.navigation")))
				.findElements(
						By.className(getidentifier("myaccount.class.navigationlist")));

		for (WebElement ele : sectionslist) {
			sections.add(ele);
		}
		return this;
	}

	public MyAccountPage MyAccountSections() throws Exception {
		for (int i = 0; i < sections.size(); i++) {

			switch (i) {

			case 1:
				ContactDetails contactdetails = new ContactDetails(driver);
				contactdetails.OpenProfile(sections.get(i), By.tagName("a"));
				contactdetails
						.ProfileDetails(
								By.className(getidentifier("myaccount.class.contentsection")),
								By.id(getidentifier("myaccount.id.contactform")),
								By.tagName("li"));
				contactdetails.RetrieveTitle(By
						.id(getidentifier("myaccount.id.title")));
				contactdetails.RetrieveFirstName(By
						.id(getidentifier("myaccount.id.firstname")));
				contactdetails.RetrieveLastName(By
						.id(getidentifier("myaccount.id.lastname")));
				contactdetails.RetrieveContact(By
						.id(getidentifier("myaccount.id.phone")));
				contactdetails.RetrieveGender(By
						.id(getidentifier("myaccount.id.gender")));
				contactdetails.SelectNewTitle(By
						.id(getidentifier("myaccount.id.title")));
				contactdetails.EnterNewFirstName(By
						.id(getidentifier("myaccount.id.firstname")),
						data.getfirstname(GetRandom.value(data.sizefirstname(),
								-1)));
				contactdetails.EnterNewLastName(By
						.id(getidentifier("myaccount.id.lastname")), data
						.getlastname(GetRandom.value(data.sizelastname(), -1)));
				contactdetails.EnterNewContact(
						By.id(getidentifier("myaccount.id.phone")),
						data.getmobilelist(GetRandom.value(
								data.sizemobilelist(), 0)));
				contactdetails.SelectNewGender(By
						.id(getidentifier("myaccount.id.gender")));
				contactdetails.ClickUpdateDetails(By
						.id(getidentifier("myaccount.id.submit")));
				break;

			case 2:
				sections.clear();
				MyAccountElements();
				LoginDetails accountdetails = new LoginDetails(driver);
				accountdetails.OpenAccountDetails(sections.get(i),
						By.tagName("a"));
				accountdetails
						.ClickChangePassword(By
								.className(getidentifier("myaccount.class.changepassword")));
				accountdetails
						.AccountDetails(
								By.className(getidentifier("myaccount.class.contentsection")),
								By.id(getidentifier("myaccount.id.loginform")));
				accountdetails.RetrieveEmail(By
						.id(getidentifier("myaccount.id.email")));

				int selectpassword = GetRandom.value(data.sizepasswordlist(),
						-1);

				accountdetails.EnterNewPassword(
						By.id(getidentifier("myaccount.id.newpassword")),
						data.getpasswordlist(selectpassword));
				accountdetails
						.EnterNewConfirmPassword(
								By.id(getidentifier("myaccount.id.confirmnewpassword")),
								data.getpasswordlist(selectpassword));
				accountdetails.ClickUpdatePassword(By
						.id(getidentifier("myaccount.id.submitnewpassword")));
				break;

			case 3:
				sections.clear();
				MyAccountElements();
				MemberShipDetails memberdetails = new MemberShipDetails(driver);
				memberdetails.OpenMemberShipDetails(sections.get(i),
						By.tagName("a"));
				break;

			case 4:
				sections.clear();
				MyAccountElements();
				BillingAddressBook billingdetails = new BillingAddressBook(
						driver);
				billingdetails
						.OpenAddressBook(sections.get(i), By.tagName("a"));
				break;

			case 5:
				sections.clear();
				MyAccountElements();
				DeliveryAddressBook deliverydetails = new DeliveryAddressBook(
						driver);
				deliverydetails.OpenAddressBook(sections.get(i),
						By.tagName("a"));
				break;

			case 6:
				sections.clear();
				MyAccountElements();
				OrderHistoryPage orderhistory = new OrderHistoryPage(driver);
				orderhistory.OpenOrderHistory(sections.get(i),
						By.tagName("a"));
				orderhistory.GetOrdersList()
				//.GetTotalOrders()
				.CollectOrdersDetails();
				break;

			case 7:
				sections.clear();
				MyAccountElements();
				WishList wishlist = new WishList(driver);
				wishlist.OpenWishlistDetails(sections.get(i), By.tagName("a"));
				break;

			// case 3:
			// // sections.clear();
			// // driver.navigate().back();
			// // MyAccountElements();
			// OrderHistoryPage orderhistory = new OrderHistoryPage(driver);
			// // sections.clear();
			// // MyAccountElements();
			// // orderhistory.OpenOrderHistory(sections.get(i),
			// // By.tagName("a"));
			//
			// orderhistory.OpenOrderHistory(driver.findElement(By
			// .className("tabbed_componentContainer")), By
			// .partialLinkText("Histor"));
			//
			// orderhistory.GetOrdersList().GetTotalOrders()
			// .CollectOrdersDetails();
			// break;
			default:
				break;
			}
		}

		return this;
	}
}
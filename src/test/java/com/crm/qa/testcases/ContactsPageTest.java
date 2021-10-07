package com.crm.qa.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.Testutil;

public class ContactsPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	String sheetname="Contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		driver=initialization();
		contactspage = new ContactsPage(driver);
	}
	
	@Test(priority=1)
	public void validateContactsLabelTest() {
		boolean contactslabel=contactspage.verifyContactsLabel();
		Assert.assertEquals(contactslabel, false,"contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectContactsNameTest() {
		contactspage.selectContactsByName("test 1");
		//contactspage.selectContactsByName("ui uii");
	}
	
	@DataProvider
	public Iterator<Object[]> getCRMTestData() throws IOException {
		ArrayList<Object[]> al=Testutil.getFreeCRMTestData(sheetname);
		return al.iterator();
	}
	
	@Test(priority=3,dataProvider ="getCRMTestData")
	public void createContactTest(String firstname,String lastname,String Category,String Status) {
		contactspage.createContacts(firstname, lastname,Category,Status);
	}
	
	
	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
}

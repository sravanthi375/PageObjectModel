package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CallsPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	HomePage homepage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		driver=initialization();
		homepage=new HomePage(driver);
		
	}
	
	@Test(priority = 1)
	public void homePageTitleTest() {
		String title = homepage.verifyHomeTitle();
		Assert.assertEquals(title, "Cogmento CRM");
		//Assert.assertTrue(false);
	}

	@Test(priority = 2)
	public void VerifyUserNameTest() {
		boolean name = homepage.identifyUserName();
		Assert.assertEquals(name, true);
	}

	@Test(priority = 3)
	public void validateSearchBoxTest() {
		String verify = homepage.enterInSearchBox(prop.getProperty("search"));
		Assert.assertEquals(verify, "contacts");
	}

	@Test(priority = 4)
	public void clickOnContactsTest() {
		 homepage.clickOnContacts();
	}
	
	 @Test(priority=5)
	 public void clickOnDealsTest() {
	   homepage.clickOnDeals();
	}
	  
	 @Test(priority=6)
	 public void clickOnCallsTest() {
		 homepage.clickOnCalls();
	}
	 
	 @Test(priority=7)
	 public void clickOnLogOutTest() {
		 homepage.clickOnSettingsLogOut();
	}

	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}

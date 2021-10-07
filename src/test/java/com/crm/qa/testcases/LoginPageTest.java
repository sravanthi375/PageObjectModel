package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		driver=initialization();
		loginpage=new LoginPage(driver);
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest() {
	String title=loginpage.validateLoginPageTitle();
	Assert.assertEquals(title, "#1 Free CRM customer relationship management software cloud");
	}
	
	@Test(priority=2)
	public void CRMlinkTest() {
	boolean link=loginpage.validateCRMlink();
	Assert.assertTrue(link);
	}
	
	@Test(priority=3)
	public void loginTest() {
	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
	
	
	
}

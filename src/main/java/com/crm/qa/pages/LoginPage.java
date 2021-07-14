package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory or Object Repository
	@FindBy(xpath = "//a[text()='Free CRM']")
	WebElement logolink;

	@FindBy(xpath = "//span[text()='Log In']")
	WebElement loginbtn;

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//div[text()='Login']")
	WebElement login;

	@FindBy(xpath = "//button[text()='Got It']")
	WebElement cookiebutton;

	// Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCRMlink() {
		if (loginbtn.isDisplayed()) {
		} else {
			cookiebutton.isDisplayed();
			cookiebutton.click();
		}
		return logolink.isDisplayed();
	}

	public HomePage login(String un, String pwd) {
		if(loginbtn.isDisplayed()) {
			  loginbtn.click();
			  email.sendKeys(un);
			  password.sendKeys(pwd);
			  login.click();
		}else {
			cookiebutton.isDisplayed();
			cookiebutton.click();
		}
		return new HomePage();
	}

}

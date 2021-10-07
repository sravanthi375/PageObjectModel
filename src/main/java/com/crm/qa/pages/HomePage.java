package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	public  WebDriver driver;
	LoginPage loginpage;
	
	@FindBy(xpath="//span[text()='sravanthi sandineni']")
	WebElement userNameLabel;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement searchBox;
	
	@FindBy(xpath ="//div[@id='main-nav']")
	WebElement contactsicon;
	
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[text()='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//span[text()='Calls']")
	WebElement callsLink;
	
	@FindBy(xpath="//div[@role='listbox']/child::i[@class='settings icon']")
	WebElement settingsicontab;
	
	@FindBy(xpath="//div[@role='listbox']/child::div[@class='menu transition visible']/a")
	List<WebElement> settingsTab;
	
	public  HomePage(WebDriver driver) {
		
		loginpage = new LoginPage(driver);
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		this.driver=driver;
		PageFactory.initElements(driver, this);
		clickOnContacts();
	}
	
	public String verifyHomeTitle() {
		return driver.getTitle();
	}
	
	public boolean identifyUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public String enterInSearchBox(String word) {
		 searchBox.sendKeys(word);
		  return word;
	}
	
	public void clickOnContacts() {
		Actions a=new Actions(driver);
	     a.moveToElement(contactsicon).build().perform();
	     contactsLink.click();
	}
	
	public void clickOnDeals() {
		dealsLink.click();
	}
	
	public void clickOnCalls() {
		callsLink.click();
	}
	
	
	public void clickOnSettingsLogOut() {
		settingsicontab.click();
		for(int i=0;i<settingsTab.size();i++) {
		String text=settingsTab.get(i).getText();
		System.out.println(text);
		if(text.contains("Log Out")) {
			settingsTab.get(i).click();
		}
		}
	}
	
}

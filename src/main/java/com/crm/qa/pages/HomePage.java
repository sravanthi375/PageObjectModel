package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//span[text()='sravanthi sandineni']")
	WebElement userNameLabel;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement searchBox;
	
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
	
	public  HomePage() {
		PageFactory.initElements(driver, this);
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
	
	public ContactsPage clickOnContacts() {
		contactsLink.click();
	    return new ContactsPage();
	}
	
	public DealsPage clickOnDeals() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public CallsPage clickOnCalls() {
		callsLink.click();
		return new CallsPage();
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

package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//div[text()='Contacts']")
	WebElement contactslabel;

	@FindBy(xpath = "//button[@class='ui linkedin button']/parent::a")
	WebElement createContact;

	@FindBy(name = "first_name")
	WebElement firstName;

	@FindBy(name = "last_name")
	WebElement lastName;

	@FindBy(xpath = "//div[@name='category']/child::i[@class='dropdown icon']")
	WebElement category;

	@FindBy(xpath = "//div[@name='status']/child::i[@class='dropdown icon']")
	WebElement status;
	
	@FindBy(xpath="//i[@class='save icon']")
	WebElement savebtn;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLabel() {
		return contactslabel.isDisplayed();
	}

	public void selectContactsByName(String name) {
		// driver.findElement(By.xpath("//a[text()='"+name+"']/parent::td//"
		// + "preceding-sibling::td//div[@class='ui fitted read-only
		// checkbox']")).click();

		driver.findElement(By.xpath("//td[text()='testanimaton@gmail.com']")).click();

	}

	public void createContacts(String firstnme, String lastnme,String Catgory,String Status) {
		createContact.click();
		firstName.sendKeys(firstnme);
		lastName.sendKeys(lastnme);
		category.click();
		List<WebElement> catgrymenu = driver.findElements(By.xpath("//div[@class='visible menu transition']/div"));
		for (int i = 0; i < catgrymenu.size(); i++) {
			String text = catgrymenu.get(i).getText();
			if (text.equals(Catgory)) {
				catgrymenu.get(i).click();
			}
		}
			status.click();
			List<WebElement> statslist = driver.findElements(By.xpath("//div[@class='visible menu transition']/div"));
			for (int j = 0; j < statslist.size(); j++) {
				String stats = statslist.get(j).getText();
				if (stats.equals(Status)) {
					statslist.get(j).click();
				}
		}
			
			savebtn.click();
	}
}

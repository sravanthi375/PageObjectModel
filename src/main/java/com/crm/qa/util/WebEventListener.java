package com.crm.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {

	public void beforeAlertAccept(WebDriver driver) {
		System.out.println("Going to accept alert");
	}

	public void afterAlertAccept(WebDriver driver) {
      System.out.println("Alert accepted");		
	}

	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("Dismissed the alert");
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println("Going to dismiss alert");
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to "+ url +"  ");
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("After navigating to "+ url +"  ");
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated to previous page");
		
	}

	public void beforeNavigateForward(WebDriver driver) {
      System.out.println("Navigating forward to next page");		
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated to forward page,new open opened");
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		 System.out.println("Navigating to refresh button");	
	}

	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("clicked the refresh button");	
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
	System.out.println("Trying to find Element "+by.toString());
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found element "+by.toString() );
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
     System.out.println("Trying to click on"+element.toString());		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on "+element.toString());
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("value of the"+element.toString()+
        		"before any changes made");		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		  System.out.println("Element value changed to "+element.toString());
			 
	}
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		 
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
    System.out.println("Before switching to window"+windowName.toString());		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
        System.out.println("New window opened"+windowName.toString()); 		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		System.out.println("Exception occured"+throwable);
			 Testutil.takeScreenshotAtEndOfTest();
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}

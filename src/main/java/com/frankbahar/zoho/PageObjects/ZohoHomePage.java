package com.frankbahar.zoho.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.frankbahar.zoho.utilities.DriverManager;

public class ZohoHomePage extends BasePage {
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div/a[4]")
	public WebElement login;
	
	/*
	 * public ZohoHomePage(WebDriver driver) { this.driver=driver;
	 * PageFactory.initElements(driver, this); }
	 */
	
	public ZohoHomePage open(String url) {
		DriverManager.getDriver().navigate().to(url);
		return (ZohoHomePage) openPage(ZohoHomePage.class);
	}
	
	public ZohoLoginPage gotoLogin() {
		click(login, "Login Link");
		return (ZohoLoginPage) openPage(ZohoLoginPage.class);
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(login);
	}
}

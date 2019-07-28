package com.frankbahar.zoho.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ZohoConnectPage extends BasePage {
	@FindBy(xpath="//span[contains(text(),'Network')]")
	public WebElement connectText;

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(connectText);
	}

}

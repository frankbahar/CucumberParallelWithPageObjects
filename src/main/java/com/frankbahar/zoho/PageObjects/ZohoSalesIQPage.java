package com.frankbahar.zoho.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ZohoSalesIQPage extends BasePage {
	@FindBy(xpath="/html/body/div[1]/div[1]/span")
	public WebElement salesIQHeader;

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(salesIQHeader);
	}

}

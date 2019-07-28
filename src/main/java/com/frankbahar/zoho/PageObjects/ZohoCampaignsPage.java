package com.frankbahar.zoho.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ZohoCampaignsPage extends BasePage {
	@FindBy(xpath="//span[contains(text(),'Welcome')]")
	public WebElement campaignsHeader;

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(campaignsHeader);
	}

}

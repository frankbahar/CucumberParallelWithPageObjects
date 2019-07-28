package com.frankbahar.zoho.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ZohoCliqPage extends BasePage {
	@FindBy(xpath="//*[@id='bodycontent']/section[3]/section[2]/h2)")
	public WebElement clickHeader;
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(clickHeader);
	}

}

package com.frankbahar.zoho.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ZohoAppPage extends BasePage {
	@FindBy(xpath="//*[contains(text(),'Cliq')]")	
	public WebElement cliq;
	@FindBy(xpath="//*[@id=\"zl-myapps\"]/div[1]/div[6]/div/a/div")	
	public WebElement crm;
	@FindBy(xpath="//*[contains(text(),'SalesIQ')]")	
	public WebElement salesIQ;
	@FindBy(xpath="//*[contains(text(),'Campaigns')]")	
	public WebElement campaigns;
	@FindBy(xpath="//div[contains(text(),'Connect')]")	
	public WebElement connect;
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(cliq);
	}
	
	public ZohoCRMPage gotoCRM() {
		click(crm, "CRM Link");
		return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	}
	
	public ZohoCliqPage gotoCliq() {
		click(cliq, "Cliq Link");
		return (ZohoCliqPage) openPage(ZohoCliqPage.class);
	}
	
	public ZohoSalesIQPage gotoSalesIQ() {
		click(salesIQ, "SalesIQ Link");
		return (ZohoSalesIQPage) openPage(ZohoSalesIQPage.class);
	}
	
	public ZohoCampaignsPage gotoCampaigns() {
		click(campaigns, "Campaigns Link");
		return (ZohoCampaignsPage) openPage(ZohoCampaignsPage.class);
	}
	
	public ZohoConnectPage gotoConnect() {
		click(connect, "Connect Link");
		return (ZohoConnectPage) openPage(ZohoConnectPage.class);
	}
}

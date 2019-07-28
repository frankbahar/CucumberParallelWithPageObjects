package com.frankbahar.bdd.zoho.steps;

import com.aventstack.extentreports.Status;
import com.frankbahar.zoho.ExtentListeners.ExtentManager;
import com.frankbahar.zoho.ExtentListeners.ExtentTestManager;
import com.frankbahar.zoho.PageObjects.ZohoAppPage;
import com.frankbahar.zoho.PageObjects.ZohoHomePage;
import com.frankbahar.zoho.PageObjects.ZohoLoginPage;
import com.frankbahar.zoho.utilities.DriverFactory;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ZohoSteps extends BaseSteps {
	protected Scenario scenario;
	static String scenarioName;
	static int x = 0;

	public ZohoHomePage home;
	public ZohoLoginPage login;
	public ZohoAppPage app;

	@Before
	public void before(Scenario scenario) {
		x = x + 1;
		this.scenario = scenario;
		this.scenarioName = scenario.getName();
		ExtentTestManager.startTest("Scenario No : " + x + " : " + scenario.getName());
		ExtentTestManager.getTest().log(Status.INFO, "Scenario started : - " + scenario.getName());
		setUpFramework();
	}

	@After
	public void after(Scenario scenario) {
		if (scenario.isFailed()) {
			ExtentTestManager.logFail("Scenario Failed");
			ExtentTestManager.addScreenShotsOnFailure();
		} else {
			ExtentTestManager.logPass("Scenario Passed");
		}
		ExtentManager.getReporter().flush();
		quit();
	}

	@Given("^launch browser \"([^\"]*)\"$")
	public void launch_browser(String browserName) throws Throwable {
		openBrowser(browserName);
		ExtentTestManager.logInfo("Browser opened: " + browserName);
	}

	@When("^user navigates to the URL \"([^\"]*)\"$")
	public void user_navigates_to_the_URL(String url) throws Throwable {
		home = new ZohoHomePage().open(url);
	}

	@Then("^user click on login$")
	public void user_click_on_login() throws Throwable {
		login = home.gotoLogin();
		app = login.doLoginAsValidUser(getDefaultUsername(), getDefaultPassword());
		logInfo("User name enterred as " + getDefaultUsername() + " and Password entered as " + getDefaultPassword());
	}

	@Then("^user click on CRM$")
	public void user_click_on_CRM() throws Throwable {
		app.gotoCRM();
	}

	@Then("^user click on Campaigns$")
	public void user_click_on_Campaigns() throws Throwable {
		app.gotoCampaigns();
	}

	@Then("^user click on Cliq$")
	public void user_click_on_Cliq() throws Throwable {
		app.gotoCliq();
	}

	@Then("^user click on Connect$")
	public void user_click_on_Connect() throws Throwable {
		app.gotoConnect();
	}

	@Then("^user click on SalesIQ$")
	public void user_click_on_SalesIQ() throws Throwable {
		app.gotoSalesIQ();
	}
}

package com.frankbahar.bdd.zoho.runners;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
		features = "src/test/resources/features/validateConnect.feature", 
		glue = "com.frankbahar.bdd.zoho.steps")

public class ValidateConnectFeatureRunner {

	@Test
	public void runCukes() {
		new TestNGCucumberRunner(getClass()).runCukes();

	}

}
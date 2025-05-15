package com.testautomation.tests;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testautomation.listeners.MyTestListener;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;

@CucumberOptions(features = "src/test/resources/features/UI", glue = "com.testautomation.stepdefinitions",tags="@runthis", plugin = {
		"pretty", "html:target/cucumber-reports" })

@Listeners(MyTestListener.class)
public class uiTestSuiteRunner extends AbstractTestNGCucumberTests {

	String testType = null;

	@Parameters("testType")
	@BeforeTest
	public void setUp(String testType) {

		System.out.println("Test Type: " + testType);
		this.testType = testType;
	}

	@Test(dataProvider = "scenarios")
	public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
		if (this.testType.equals("UI")) {
			super.runScenario(pickleWrapper, featureWrapper);
		}
	}

	@DataProvider
	public Object[][] scenarios() {
		return super.scenarios();
	}

	@AfterClass
	public void tearDown() {

	}
}

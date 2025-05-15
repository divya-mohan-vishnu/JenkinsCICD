package com.testautomation.stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.testautomation.ui.LoginPage;
import com.testautomation.utils.DriverManager;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UIStepdefinition {

	LoginPage loginPage;
	DriverManager driverManager = new DriverManager();
	WebDriver driver;

//////////////////////Scenario Outline ///////////////////////////////////
	@Given("the user is on the login page of the app {string}")
	public void theUserIsOnTheLoginPage(String appUrl) {
		driver = driverManager.getDriver();
		loginPage = new LoginPage(driver);
		loginPage.goToLoginPage(appUrl);
		System.out.println("User is on the login page");
	}

	@When("the user enters {string} and {string}")
	public void theUserEntersValidCredentials(String userName, String password) {

		loginPage.enteruserandpassword(userName, password);
	}

	@Then("the user should be redirected to the homepage")
	public void theUserShouldBeRedirectedToTheHomepage() {

	}

//////////////////////Scenario : Check and validate Search in Google page ///////////////////////////////////

	@Given("the user is on the login page of the facebook app")
	public void theUserIsOnTheSearchPage(DataTable dataTable) {
		Map<String, String> appurl = dataTable.asMap();
		driver = driverManager.getDriver();
		loginPage = new LoginPage(driver);
		loginPage.goToLoginPage(appurl.get("facebookUrl"));
		System.out.println("User is on the login page");
	}

	@When("the user enters username and password")
	public void theUserEntersCredentials(DataTable dataTable) {
		Map<String, String> map = dataTable.asMap();
		loginPage.enteruserandpassword(map.get("userName"), map.get("password"));
	}

	@And("clicks on the login button")
	public void ClickOnLoginButton() {
		
		loginPage.ClickOnLoginButton();
	}

}

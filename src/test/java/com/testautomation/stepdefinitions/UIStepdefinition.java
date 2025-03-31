package com.testautomation.stepdefinitions;



import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import com.testautomation.ui.LoginPage;
import com.testautomation.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class UIStepdefinition {

	LoginPage loginPage;
	DriverManager driverManager=new DriverManager();
	WebDriver driver;
	
	 @Given("the user is on the login page")
	    public void theUserIsOnTheLoginPage() {
		driver= driverManager.getDriver();
		loginPage=new LoginPage(driver);
		loginPage.goToLoginPage("https://www.instagram.com");
	        System.out.println("User is on the login page");
	    }

	    @When("the user enters valid credentials")
	    public void theUserEntersValidCredentials() {
	       
	    }

	    @Then("the user should be redirected to the homepage")
	    public void theUserShouldBeRedirectedToTheHomepage() {
	        
	       
	    }
	}
	


package com.testautomation.stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class APIStepdefinition {

	Response apiResponse;
	String requestBody = null;

	@Given("the API is available at {string}")
	public void givenTheApiIsAvailable(String url) {
		RestAssured.baseURI = url;
	}

	@When("the user makes a GET request to {string}")
	public void whenTheUserMakesGetRequest(String endpoint) {
		apiResponse = RestAssured.get(endpoint);
	}

	@Then("the response should have status code {int}")
	public void thenTheResponseShouldHaveStatusCode(int statusCode) {
		assertEquals(apiResponse.statusCode(), statusCode);
	}

	@Given("the user has valid input data for creating a user")
	public void theUserHasValidInputData() {

		requestBody = "{\n +" + "  \"name\" : \"John Doe\",\\n\" +\r\n"
				+ "                             \"  \\\"job\\\": \\\"Software Developer\\\"\\n\" +\r\n"
				+ "                             \"}";

	}

	@When("the user sends a POST request to the API")
	public void the_user_sends_a_post_request_to_the_api() {
		RestAssured.baseURI = "https://reqres.in/api";

		apiResponse = given().header("Content-Type", "application/json").body(requestBody).when().post("/users");
		System.out.println(apiResponse.statusCode());
	}

	// Step to validate the response status code
	@Then("the response status should be {int}")
	public void theResponseStatusShouldBe(int statusCode) {
		assertEquals(apiResponse.statusCode(), statusCode);
	}

	@And("the response body should contain the user ID, name, and job")
	public void validateResponse(int statusCode) {
		String userId = apiResponse.jsonPath().getString("id");
		String userName = apiResponse.jsonPath().getString("name");
		String job = apiResponse.jsonPath().getString("job");

		assertTrue(userName.contains("John Doe"));
		assertTrue(job.contains("Software Developer"));

	}
}

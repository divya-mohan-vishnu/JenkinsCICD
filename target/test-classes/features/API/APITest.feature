#Author: divya_mohan@yahoo.com
Feature: Valid Get Request
  I want to use this template for my feature file

  Scenario: Verify API Get Request
    Given the API is available at "https://jsonplaceholder.typicode.com"
    When the user makes a GET request to "/posts"
    Then the response should have status code 200
    
    
    Scenario: Verify API POST Request to verify a user
     Given the user has valid input data for creating a user
    When the user sends a POST request to the API
    Then the response status should be 201
    And the response body should contain the user ID, name, and job
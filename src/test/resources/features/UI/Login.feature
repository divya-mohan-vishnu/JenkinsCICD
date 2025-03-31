#Author: divya_mohan@yahoo.com
Feature: Login Functionality

  Scenario: Check Login instagram page
    Given the user is on the login page
    When the user enters valid credentials
    Then the user should be redirected to the homepage
 

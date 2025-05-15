#Author: divya_mohan@yahoo.com
Feature: Login Functionality

  Scenario Outline:
    Check Login page
    Given the user is on the login page of the app "<AppUrl>"
    When the user enters "<UserName>" and "<Password>"
    Then the user should be redirected to the homepage

Examples:
 |UserName         |Password    |
|divya.mohan      |12345|
 |divu_m06@yahoo.com|12345   |

 @runthis
 Scenario:
    Check and validate Search in Google page
    Given the user is on the google page 
    When the user searches for apple word
    Then the result should contain word apple
    
    @runthis
    Scenario:
    Check Facebook Login page
    Given the user is on the login page of the facebook app
    | facebookUrl   | https://www.facebook.com/ |     
    When the user enters username and password
    | username   | divu_m06@yahoo.com |  
    | password   | 12345 |  
    And clicks on the login button
    Then the user should be redirected to the facebook homepage
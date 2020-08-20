Feature: Login feature
  As a customer, I want to be able to login using login page

  Background: 
    Given I am on homepage
    When I click on sign in button

  @smoke
  Scenario: Verify login page title #Title
    As a user, I should be able to land on login page #Description

    Then I should land on login page and the title should be Login - My store

  @smoke 
  Scenario: Verify login page url
    Then I should land on login page and the url should be correct

  @smoke
  Scenario: Verify login page elements
    Then The username, password and login button elements should be enabled
    
   
   Scenario: Verify login using multiple credentials
   
   And I enter "duotech@gmail.com" to email field
   And I enter "dt123" to password field
   Then I should be able to login and name should be "Duotech Academy"
   
     
   Scenario Outline: Verify login using multiple credentials  using SO
  
   And I enter "<email>" to email field
   And I enter "<password>" to password field
   Then I should be able to login and name should be "<name>"
   
   Examples:
   			| email             | password | name            |
   			| duotech@gmail.com | dt123    | Duotech Academy |
   			| duotech1@gmail.com| duotech1 | Duotech One     |
   			| duotech2@gmail.com| duotech2 | Duotech Two     |
   			 


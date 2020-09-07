
Feature: Register a user

  Scenario: Creating a new user in UI and verify in DB
    Given I am on registration page
    When I should be able to register with credentials
    And click sign up
    Then I should be able to login
    And the database user table should contain the correct information about the new user

@db @ui
    Scenario: Creating a new user in DB and verify in UI
    Given I create a new user in db
    When I should be able to login using credentials
    
    
    Scenario: Updateting an email in DB and logging in through UI
    Given I update the email in db
    Then I should be able to login in ui 
    
    
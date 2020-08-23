

Feature: Register a user
  

  @temp
  Scenario: Verify user registration in DB
    Given I am on registration page
    When I enter new user deatils and click sign up
    Then I should be able to login
    And the database user table should contain the correct information about the new user

  


Feature: Register a user
  

  @db
  Scenario: Verify user registration in DB
    Given I am on registration page
    When I enter the following new user deatils and click sign up
    |username |firstName| lastName | email            |  password |
    |murad123 |Murad    | Safarzade| murads@gmail.com | murads    |
    Then I should be able to login
    And the database user table should contain the correct information about the new user

  
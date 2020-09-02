@db @ui
Feature: Register a user

  Scenario: Verify user registration in DB
    Given I am on registration page
#    When I enter <email>, <firstName>, <lastName>, <password>
#    | email            | firstName | lastName | password       |
#    | julie.89@mail.ru | Julia     | Cruz     | groupdpractice |

    When I should be able to register with credentials
    And click sign up
      
    Then I should be able to login
    And the database user table should contain the correct information about the new user

@db
Feature: Database tests
  

  
  
  Scenario: Verify employees table
    Given I an connected to hr db
    When I send a query to retrieve all employees
    Then I should be able to retrieve the data and print out

 
  Scenario: Verify salaries table
    Given I an connected to hr db
    When I send a query to retrieve all salaries of employees
    Then I should be able to retrieve the data and print out

 
Feature: Genres

  @db
  Scenario: Verify genres according to the brd
   
   
    Given I send a query to retrieve the count of similar users 
    Then The count column should not be more than one
    
    

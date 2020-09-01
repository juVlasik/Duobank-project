Feature: Genres

  #@db
  Scenario: Verify genres according to the brd
    Given I retrieve the  genres table from the database
    Then The table contents should have the following genres
      | rap        |
      | pop        |
      | techno     |
      | rnb        |
      | house      |
      | classical  |
      | jazz       |
      | electronic |
      | dance      |
      | reggae     |
      | reggaeton  |
  
    

     @api
  Feature: API test


  Scenario: post body
    
    Given I send a post request
    Then The payload should contain correct first name, last name, email and password
    
   
   Scenario: using token and ID
   
    When I login using API and receive a token
    Then I use the token to get ID
    And I use the ID and token

    
    
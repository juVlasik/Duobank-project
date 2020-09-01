Feature: Verify get place endpoint

 
  Scenario: Verify the get place response body
    
    Given I send a get request to getplace endpoint with place id "ccc672ef5aa902129b06d09f603725be"
    Then The payload should contain "Duotech Academy" name, "8133 Leesburg Pike STE 300, Vienna, VA 22182" address
      
    

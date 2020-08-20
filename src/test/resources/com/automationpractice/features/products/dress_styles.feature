
Feature: Verify dress styles
  

  
  Scenario: Verify dress subcategories 
    Given I am on homepage
   
    When I click on dresses button
    Then The following subcategories should be there
       		| Casual Dresses  |
   				| Evening Dresses |  
  				| Summer Dresses  |
  				
  				
  			
  Scenario: Verify sizes 
    Given I am on homepage
   
    When I click on dresses button
    Then The following sizes should be there
       		| S |
       		| M |
       		| L |
   				
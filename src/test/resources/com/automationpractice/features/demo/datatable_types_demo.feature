
Feature: Demo of DataTable types
  

  	 
  Scenario: Verify customer info using list
    Then I should be able to enter the following customer info using list of lists
    
    | firstName   | lastName | birthDate  |
		| Annie M. G. | Schmidt  | 1911-03-20 |
		| Roald       | Dahl     | 1916-09-13 |
		| Astrid      | Lindgren | 1907-11-14 |
		
		
		
		Scenario: Verify customer info using map
    Then I should be able to enter the following customer info using list of maps
    
    | firstName   | lastName | birthDate  |
		| Annie M. G. | Schmidt  | 1911-03-20 |
		| Roald       | Dahl     | 1916-09-13 |
		| Astrid      | Lindgren | 1907-11-14 |
		
		
		
		
  Scenario: Verify airport names
    Then I should be able to seethe following airports
		
		| KMSY | Louis Armstrong New Orleans International Airport 	|
		| KSFO | San Francisco International Airport               	|
		| KSEA | Seattle–Tacoma International Airport              	|
		| KJFK | John F. Kennedy International Airport             	|
		
		
		
		
  Scenario: Verify airport location
    Then I should be able to seethe following airports with their location info
		
		| KMSY | 29.993333 |  -90.258056 |
		| KSFO | 37.618889 | -122.375000 |
		| KSEA | 47.448889 | -122.309444 |
		| KJFK | 40.639722 |  -73.778889 |
		
		
		
		
  Scenario: Verify airport location
    Then I should be able to see the following airports with their location info with headers
		
		
		|      |       lat |         lon |
		| KMSY | 29.993333 |  -90.258056 |
		| KSFO | 37.618889 | -122.375000 |
		| KSEA | 47.448889 | -122.309444 |
		| KJFK | 40.639722 |  -73.778889 |
		
		
		
    
    

  
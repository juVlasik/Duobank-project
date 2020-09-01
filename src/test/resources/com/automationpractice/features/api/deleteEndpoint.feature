Feature: Verify delete place endpoint

  @api
  Scenario: Verify the deletePlace endpoint
    
    Given I send a post request to addPlace endpoint with a payload that contains the following
           |name          | address 																		 | phone          |
           |Olive garden  | 8133 Leesburg Pike STE 300, Vienna, VA 22182 | (571) 295-5326 |
    When  I retrieve the place using the place id
    Then  The payload should contain the following info
			 	 | response code  			|name          | address 																		 | phone          |
			   | 200                  |Olive garden  | 8133 Leesburg Pike STE 300, Vienna, VA 22182 | (571) 295-5326 |
    When I send delete request using the place id
    Then The place should be deleted successfully
    
    

package com.automationpractice.stepDefs;

import java.util.List;
import java.util.Map;


import com.automationpractice.pojos.User;

import io.cucumber.java.DataTableType;

public class CustomTypeTransformer {
	
	

	
	
	@DataTableType
	public User userEntry ( Map<String, String> row) {
		
			
		return new User(row.get("firstName"), 
						row.get("lastName"), 
						row.get("password"),
						
						row.get("username"),
						row.get("email"));
	}
	
	

	
	
	
	

}

package com.automationpractice.stepDefs;

import java.util.List;
import java.util.Map;

import com.automationpractice.pojos.Cart;
import com.automationpractice.pojos.Product;
import com.automationpractice.pojos.User;

import io.cucumber.java.DataTableType;

public class CustomTypeTransformer {
	
	
	@DataTableType
	public Product productEntry ( Map<String, String> row) {
		
		String productName = row.get("Product name");
		String quantity = row.get("Quantity");
		String condition = row.get("Condition");
		String price = row.get("Price");
		String size = row.get("Size");
		String model = row.get("Model");
		
		
		return new Product(productName, quantity, condition, price, size, model);
	}
	
	
	
	
	@DataTableType
	public User userEntry ( Map<String, String> row) {
		
			
		return new User(row.get("firstName"), 
						row.get("lastName"), 
						row.get("password"),
						
						row.get("username"),
						row.get("email"));
	}
	
	
	@DataTableType
	public Cart cartEntry ( List<String> row) {
		
			
		String productName = row.get(0);
		double unitPrice = Double.parseDouble(row.get(1));
		int quantity = Integer.parseInt(row.get(2));
		
		
		
		
		return new Cart(productName, unitPrice, quantity);
	}
	
	
	
	
	

}

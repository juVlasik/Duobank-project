package com.automationpractice.pojos;

import com.automationpractice.utilities.DatabaseUtils;



public class DBUtilTester {

	public static void main(String[] args)  {
		
		DatabaseUtils.establishConnection();
		
		System.out.println("Connection successful");
		
		System.out.println(DatabaseUtils.getColumnNames("Select * from employees limit 10"));
		
		

	}

}

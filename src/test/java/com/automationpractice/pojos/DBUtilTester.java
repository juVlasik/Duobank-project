package com.automationpractice.pojos;

import java.util.List;
import java.util.Map;

import com.automationpractice.utilities.DatabaseUtils;



public class DBUtilTester {

	public static void main(String[] args)  {
		
		DatabaseUtils.establishConnection();
		
		System.out.println("Connection successful");
		
		System.out.println(DatabaseUtils.getColumnNames("Select * from employees limit 10"));
		
		System.out.println(DatabaseUtils.getRowCount());
		
		List<List<Object>> queryResultList = DatabaseUtils.getQueryResultList("Select * from employees limit 10");
		
		for (List<Object> list : queryResultList) {
			System.out.println(list);
		}
		
		List<Map<String, Object>> queryResultMap = DatabaseUtils.getQueryResultMap("Select * from employees limit 10");


		System.out.println(queryResultMap);
		
		DatabaseUtils.updateQuery("Update employees set first_name=\"Murad\" where emp_no=10001");
		
	}

}

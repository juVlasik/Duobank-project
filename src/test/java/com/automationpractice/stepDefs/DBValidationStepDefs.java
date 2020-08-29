package com.automationpractice.stepDefs;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.automationpractice.utilities.DatabaseUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class DBValidationStepDefs {
	
List<Map<String, Object>> queryResultMap;
private List<List<Object>> queryResultList;

@Given("I retrieve the  genres table from the database")
public void iRetrieveTheGenresTableFromTheDatabase() {
	String query = "select name from genres";
	
	queryResultList = DatabaseUtils.getQueryResultList(query);
	
	
	


}

@Then("The table contents should have the following genres")
public void theTableContentsShouldHaveTheFollowingGenres(List<List<Object>> list) {

   Assert.assertEquals(list, queryResultList);
    
}

@Given("I send a query to retrieve the count of similar users")
public void iSendAQueryToRetrieveTheCountOfSimilarUsers() {
	
	 queryResultMap = DatabaseUtils.getQueryResultMap("select firstName, lastName, email, count(*) as c from users group by email");

	
	

}

@Then("The count column should not be more than one")
public void theCountColumnShouldNotBeMoreThanOne() {

	 for (Map<String, Object> map : queryResultMap) {
			
		   Assert.assertTrue("Duplicate value found" + map.get("email"),Integer.parseInt(map.get("c").toString())==1);
	}

}


}

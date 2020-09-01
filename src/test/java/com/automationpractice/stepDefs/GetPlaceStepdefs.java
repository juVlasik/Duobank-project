package com.automationpractice.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.*;


public class GetPlaceStepdefs {
	
	Response response;
	
	@Given("I send a get request to getplace endpoint with place id {string}")
	public void iSendAGetRequestToGetplaceEndpointWithPlaceId(String string) {
		
		RestAssured.baseURI = "http://3.6.24.244";
//		RestAssured.basePath = "maps/api/place/add/json";
		
		 response = given().
				queryParam("place_id", string).
				queryParam("key", "qaclick123").
				
		when(). log().all().
				get("/maps/api/place/get/json");
		
		
	  
	}

	@Then("The payload should contain {string} name, {string} address")
	public void thePayloadShouldContainNameAddress(String string, String string2) {
		
		response.then(). log().all().
					assertThat().
					body("name", equalTo(string)).
					body("address", equalTo(string2));
	   
	}

}

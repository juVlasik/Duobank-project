package com.duobank.stepDefs;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.util.HashMap;
import java.util.Map;

import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APIStepDefinitions {

	Faker f = new Faker();
	static String  email;
    String token;
	String id;
	Response response;
	
	
	//step 1
	
	@Given("I send a post request")
	public void iSendAPostRequest() {

		email = f.internet().emailAddress();
		System.out.println(email);
		RestAssured.baseURI = "http://duobank-env.eba-bgkwzq3h.us-east-2.elasticbeanstalk.com";
	
	response = given().body("{\n" + 
				"  \"first_name\":\"Julia\",\n" + 
				"  \"last_name\": \"zoo\",\n" + 
				"  \"email\": \""+email+"\",\n" + 
				"  \"password\":\"groupdpractice\"\n" + 
				"}").
		when().
               post("/api/register.php").
        then().log().all().
        assertThat().
                     statusCode(200).
                     extract().response();
	}

	@Then("The payload should contain correct first name, last name, email and password")
	public void thePayloadShouldContainCorrectFirstNameLastNameEmailAndPassword() {
	    
		response.then().
		               assertThat().
		body("status", equalTo(201)).and().
        body("success", equalTo(1)).and().
        body("message", equalTo("You have successfully registered."));
	}

	
	//step 2
	
	
	
	@Given("I login using API and receive a token")
	public void iLoginUsingAPIAndReceiveAToken() {
		System.out.println(email);
		RestAssured.baseURI = "http://duobank-env.eba-bgkwzq3h.us-east-2.elasticbeanstalk.com";
		
		JsonPath jp = given().body("{\n" + 
				
				"  \"email\": \"julie.888889@mail.ru\",\n" + 
				"  \"password\":\"groupdpractice\"\n" + 
				"}").
		when().
               post("/api/login.php").
        then().log().all().
        assertThat().
                     statusCode(200).
                     
                     body("success", equalTo(1)).and().
                     body("message", equalTo("You have successfully logged in.")).extract().response().jsonPath();
		
		token = jp.getString("token");
		System.out.println("Token:" + token);
	
		
		
		    
		}

		
	//step 3
	
			@Given("I use the token to get ID")
			public void iUseTheTokenToGetID() {
				
				RestAssured.baseURI="http://duobank-env.eba-bgkwzq3h.us-east-2.elasticbeanstalk.com";
				
				JsonPath jp = given().
						header("Authorization" ,token).
						when().get("/api/getmortagage.php").prettyPeek().
						then().log().all().
						extract().response().jsonPath();
				
				System.out.println(jp.getString("mortagage_applications"));
				id  = jp.getString("mortagage_applications[0].id");

				System.out.println("ID" + id);
		             
	}
			
	
	//step 4
			@Then("I use the ID and token")
			public void iUseTheIDAndToken() {
				
				RestAssured.baseURI="http://duobank-env.eba-bgkwzq3h.us-east-2.elasticbeanstalk.com";
				
				Map<String, Object> bodyContent = new HashMap<>();
				
				bodyContent.put("id", id);
				
				given().header("Authorization" ,token).
				           body(bodyContent).
				              when().post("/api/mortagagedetails.php").
				                        then().log().all().
				                              assertThat().
				                              statusCode(200).
				                              body("success", equalTo(1));
				                                          
				
			}
			
}

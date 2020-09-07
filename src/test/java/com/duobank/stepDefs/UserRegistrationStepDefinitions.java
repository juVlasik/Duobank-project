package com.duobank.stepDefs;

import java.util.List;
import java.util.Map;

import org.junit.Assert;


import com.duobank.pages.RegistrationPage;
import com.duobank.utilities.BrowserUtilities;
import com.duobank.utilities.DatabaseUtils;
import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserRegistrationStepDefinitions {

	//db test 1
	Faker f = new Faker();
	String firstName = f.name().firstName();
	String lastName = f.name().lastName();
	String email = f.internet().emailAddress();
	String pass = f.internet().password();
	
	@Given("I am on registration page")
	public void iAmOnRegistrationPage() {
	   new RegistrationPage().accSignUpButton.click();
	}

	@When("I should be able to register with credentials")
	public void iShouldBeAbleToRegisterWithCredentials() {
	    RegistrationPage rp = new RegistrationPage();
	    rp.firstName.sendKeys(firstName);
	    rp.lastName.sendKeys(lastName);
	    rp.emailField2.sendKeys(email);
	    rp.passwordField2.sendKeys(pass);
	}

	@When("click sign up")
	public void clickSignUp() {
		new RegistrationPage().signUp.click();
		BrowserUtilities.waitFor(2);
	}

	@Then("I should be able to login")
	public void iShouldBeAbleToLogin() {
		RegistrationPage rp = new RegistrationPage();
		rp.emailField.sendKeys(email);
		rp.passwordField.sendKeys(pass);
		rp.loginButton.click();
		BrowserUtilities.waitFor(2);
		
		String expected = firstName + " " + lastName;
		String actual = new RegistrationPage().nameConfirmation.getText();
		Assert.assertEquals(expected, actual);
	}

	@Then("the database user table should contain the correct information about the new user")
	public void theDatabaseUserTableShouldContainTheCorrectInformationAboutTheNewUser() {
	   
      
        String query = "select * from tbl_user where email='"+email+"'" ;
		
		
		List<Map<String, Object>> queryResultMap = DatabaseUtils.getQueryResultMap(query);
		System.out.println(queryResultMap);
		
		Map<String, Object> map = queryResultMap.get(0);	
		
		Assert.assertEquals(firstName, map.get("first_name"));
		Assert.assertEquals(lastName, map.get("last_name"));
		
	
		
		
		DatabaseUtils.updateQuery("delete from tbl_user where email='"+ email +"'");
		
	}
	
	//db test 2
	
	@Given("I create a new user in db")
	public void iCreateANewUserInDb() {
		
		
		String query = "INSERT INTO tbl_user (id, email, password, first_name, last_name, phone,"
				+ " image, type, created_at, modified_at, zone_id, church_id, country_id, active) "
				+ "VALUES (100, 'bpitt@gmail.com', 'williambradley', 'Brad', 'Pitt' ,'7654321',"
				+ " , 1, '2020-07-16 21:28:00','0000-00-00 00:00:00',1 , 1 , 1 ,1)" ;
		
		DatabaseUtils.updateQuery(query);;
		
		
	}

	@When("I should be able to login using credentials")
	public void iShouldBeAbleToLoginUsingCredentials() {
	    String firstName = "Brad";
		String lastName = "Pitt";
		
		RegistrationPage rp = new RegistrationPage();
		rp.emailField.sendKeys("bpitt@gmail.com");
		rp.passwordField.sendKeys("williambradley");
		rp.loginButton.click();
		BrowserUtilities.waitFor(2);
		
		String expected = firstName + " " + lastName;
		String actual = new RegistrationPage().nameConfirmation.getText();
		Assert.assertEquals(expected, actual);
	}
	
	
	
	
}

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
	   
        //String query = "select * from tbl_user" ;
        String query = "select * from tbl_user where email='"+email+"'" ;
		System.out.println(query);
		
		List<Map<String, Object>> queryResultMap = DatabaseUtils.getQueryResultMap(query);
		System.out.println(queryResultMap);
		
		Map<String, Object> map = queryResultMap.get(0);	
		
		Assert.assertEquals(firstName, map.get("first_name"));
		Assert.assertEquals(lastName, map.get("last_name"));
		
	
		
		
		DatabaseUtils.updateQuery("delete from tbl_user where email='"+ email +"'");
		
	}
	
	
}

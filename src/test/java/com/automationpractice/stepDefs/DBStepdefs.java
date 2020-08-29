package com.automationpractice.stepDefs;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.automationpractice.pages.MainPage;
import com.automationpractice.pages.RegistrationPAge;
import com.automationpractice.pojos.User;
import com.automationpractice.utilities.ConfigReader;
import com.automationpractice.utilities.DatabaseUtils;
import com.automationpractice.utilities.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class DBStepdefs {
	String firstName;
	String lastName;
	String username;
	String email;
	String password;

	@Given("I am on registration page")
	public void iAmOnRegistrationPage() {
		
		
		new RegistrationPAge().signUpButton.click();




	}

	@When("I enter the following new user deatils and click sign up")
	public void iEnterTheFollowingNewUserDeatilsAndClickSignUp(User user) {
	    
		
		RegistrationPAge r = new RegistrationPAge();
		
		
		firstName = user.getFirstName();
		
		lastName = user.getLastName();
		
		username = user.getUsername();
		
		DatabaseUtils.updateQuery("delete from users where username='"+ username +"'");
		
		email = user.getEmail();
		
		password = user.getPassword();
		
		
		
		
		r.username.sendKeys(username);
		r.firstName.sendKeys(firstName);
		r.lastName.sendKeys(lastName);
		r.email.sendKeys(email);
		r.email2.sendKeys(email);
		r.password.sendKeys(password);
		r.password2.sendKeys(password);
		r.registerButton.click();
		


	}

	@Then("I should be able to login")
	public void iShouldBeAbleToLogin() {
		
		String expected = firstName + " " + lastName;
		Assert.assertEquals(expected, new MainPage().name.getText());

	}

	@Then("the database user table should contain the correct information about the new user")
	public void theDatabaseUserTableShouldContainTheCorrectInformationAboutTheNewUser() {
		
		
		
		String query = "select * from users where username='"+username+"'" ;
		
		System.out.println(query);
		
		List<Map<String, Object>> queryResultMap = DatabaseUtils.getQueryResultMap(query);
		
		
		Map<String, Object> map = queryResultMap.get(0);
		
		Assert.assertEquals(username, map.get("username"));
		Assert.assertEquals(firstName, map.get("firstName"));
		Assert.assertEquals(lastName, map.get("lastName"));
		Assert.assertEquals(email, map.get("email"));
	
		
		
		DatabaseUtils.updateQuery("delete from users where username='"+ username +"'");


	}

}

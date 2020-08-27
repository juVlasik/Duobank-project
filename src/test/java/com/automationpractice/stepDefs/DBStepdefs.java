package com.automationpractice.stepDefs;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.automationpractice.pages.RegistrationPAge;
import com.automationpractice.pojos.User;
import com.automationpractice.utilities.ConfigReader;
import com.automationpractice.utilities.DatabaseUtils;
import com.automationpractice.utilities.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class DBStepdefs {

	@Given("I am on registration page")
	public void iAmOnRegistrationPage() {
		
		Driver.getDriver().get(ConfigReader.getProperty("url"));
		new RegistrationPAge().signUpButton.click();




	}

	@When("I enter the following new user deatils and click sign up")
	public void iEnterTheFollowingNewUserDeatilsAndClickSignUp(User user) {
	    
		RegistrationPAge r = new RegistrationPAge();
		
		
		
		r.username.sendKeys(user.getUsername());
		r.firstName.sendKeys(user.getFirstName());
		r.lastName.sendKeys(user.getLastName());
		r.email.sendKeys(user.getEmail());
		r.email2.sendKeys(user.getEmail());
		r.password.sendKeys(user.getPassword());
		r.password2.sendKeys(user.getPassword());
		r.registerButton.click();
		


	}

	@Then("I should be able to login")
	public void iShouldBeAbleToLogin() {
//		Assert.assertEquals("Welcome to Duotify!", Driver.getDriver().getTitle());

	}

	@Then("the database user table should contain the correct information about the new user")
	public void theDatabaseUserTableShouldContainTheCorrectInformationAboutTheNewUser() {
		
		
//		DatabaseUtils.getQueryResultMap("select * from users where email=\"Murads@gmail.com\"");


	}

}

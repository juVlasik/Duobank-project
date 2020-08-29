package com.automationpractice.stepDefs;

import org.junit.Assert;

import com.automationpractice.pages.MainPage;
import com.automationpractice.pages.RegistrationPAge;
import com.automationpractice.pages.UserDetailsPage;
import com.automationpractice.utilities.DatabaseUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class EmailUpdateStepDefs {
	String username;
	String expectedEmail;
	
	@Given("I am on logged in using {string} as username and {string} as password")
	public void iAmOnLoggedInUsingAsUsernameAndAsPassword(String un, String pass) {
		
		username = un;
		new RegistrationPAge().loginUsername.sendKeys(username);
		new RegistrationPAge().loginPassword.sendKeys(pass);
		new RegistrationPAge().loginButton.click();

	   
	}

	@When("I update the email in the database with {string}")
	public void iUpdateTheEmailInTheDatabase(String newEmail) {
		
		expectedEmail = newEmail;
		
		String query = "update  users set email='"+ newEmail+ "' where username='"+ username +"'";
		
    	DatabaseUtils.updateQuery(query);
		
	}
	   

	@Then("The correct email should be diplayed in the user details page")
	public void theCorrectEmailShouldBeDiplayedInTheUserDetailsPage() {
		
		new MainPage().name.click();
		
		UserDetailsPage up = new UserDetailsPage();
		
		up.userDetailsButton.click();
		
		String actual = up.emailBox.getAttribute("value");
		
		Assert.assertEquals(expectedEmail, actual);
		
		
	}
	

}

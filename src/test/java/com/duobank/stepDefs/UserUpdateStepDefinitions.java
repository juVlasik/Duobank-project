package com.duobank.stepDefs;

import org.junit.Assert;

import com.duobank.pages.RegistrationPage;
import com.duobank.utilities.BrowserUtilities;
import com.duobank.utilities.DatabaseUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class UserUpdateStepDefinitions {

	String newEmail = "julie.89@hotmail.com";
	
	@Given("I update the email in db")
	public void iUpdateTheEmailInDb() {
		
        String query = "update  tbl_user set email='"+ newEmail+ "' where first_name='Julia'";
	
    	DatabaseUtils.updateQuery(query);
	}

	@Then("I should be able to login in ui")
	public void iShouldBeAbleToLoginInUi() {
		String firstName = "Julia";
		String lastName = "Cruz";
		
		RegistrationPage rp = new RegistrationPage();
		rp.emailField.sendKeys(newEmail);
		rp.passwordField.sendKeys("groupdpractice");
		rp.loginButton.click();
		BrowserUtilities.waitFor(2);
		
		String expected = firstName + " " + lastName;
		String actual = new RegistrationPage().nameConfirmation.getText();
		Assert.assertEquals(expected, actual);
	}
	
}

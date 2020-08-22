package com.automationpractice.stepDefs;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

import com.automationpractice.pages.CreateAccountPage;
import com.automationpractice.pages.LoginPage;
import com.automationpractice.pages.MyAccountPage;
import com.automationpractice.pojos.User;
import com.github.javafaker.Faker;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class RegistrationStepDefs {
	
	@When("I enter a valid email")
	public void iEnterAValidEmail() {
		LoginPage lp =  new LoginPage();
		lp.registerEmail.sendKeys("");
		lp.createAccountButton.click();
	    
	}

	@Then("I should be able to register with the following details")
	public void iShouldBeAbleToRegisterWithTheFollowingDetails(User user) {
		
		
		
		CreateAccountPage ca = new CreateAccountPage();
		ca.firstName.sendKeys(user.getFirstName());
		ca.lastName.sendKeys(user.getLastName());
		ca.pass.sendKeys(user.getPassword());
		ca.selectDob();
		ca.address.sendKeys(user.getAddress());
		ca.city.sendKeys(user.getCity());
		ca.selectState();
		ca.zip.sendKeys(user.getZip());
		ca.phone.sendKeys(user.getPhoneNo());
		ca.registerButton.click();
		
		
		String expected = user.getFirstName() + " " + user.getLastName();
		
		try {
			String actual = new MyAccountPage().customerNameLink.getText();
			Assert.assertEquals(expected, actual);
		} catch (NoSuchElementException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw e;
		}
	   
	}


}

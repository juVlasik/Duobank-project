package com.automationpractice.stepDefs;

import org.junit.Assert;
import org.openqa.selenium.By;

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
		Driver.getDriver().findElement(By.id("hideLogin")).click();




	}

	@When("I enter new user deatils and click sign up")
	public void iEnterNewUserDeatilsAndClickSignUp() {
		
		
		
		Driver.getDriver().findElement(By.id("username")).sendKeys("murad2020");
		Driver.getDriver().findElement(By.id("firstName")).sendKeys("Murad");
		Driver.getDriver().findElement(By.id("lastName")).sendKeys("Safarzade");
		Driver.getDriver().findElement(By.id("email")).sendKeys("murads@gmail.com");
		Driver.getDriver().findElement(By.id("email2")).sendKeys("murads@gmail.com");
		Driver.getDriver().findElement(By.id("password")).sendKeys("murad2020");
		Driver.getDriver().findElement(By.id("password2")).sendKeys("murad2020");
		Driver.getDriver().findElement(By.name("registerButton")).click();
		


	}

	@Then("I should be able to login")
	public void iShouldBeAbleToLogin() {
		Assert.assertEquals("Welcome to Duotify!", Driver.getDriver().getTitle());

	}

	@Then("the database user table should contain the correct information about the new user")
	public void theDatabaseUserTableShouldContainTheCorrectInformationAboutTheNewUser() {
		
		DatabaseUtils.establishConnection();
		DatabaseUtils.getQueryResultMap("select * from users where email=\"Murads@gmail.com\"");


	}

}

package com.automationpractice.stepDefs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.LoginPage;
import com.automationpractice.pages.MyAccountPage;
import com.automationpractice.utilities.ConfigReader;
import com.automationpractice.utilities.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
 

public class LoginStepDefinitions {
	
	
	@When("I am on homepage")
	public void i() {
		
		
		
		Driver.getDriver().get(ConfigReader.getProperty("url"));


		
	}
	
	


	

	@When("I click on sign in button")
	public void i_click_on_sign_in_button() {
		
		HomePage hp = new HomePage();
		
		hp.signInButton.click();
		
		



	}
	
	
	@Then("I should land on login page and the title should be Login - My store")
	public void i_should_land_on_login_page_and_the_title_should_be_login_my_store() {
		String title = Driver.getDriver().getTitle();
		Assert.assertEquals("Login - My Stor", title);
		 
	}
	
	
	@Then("I should land on login page and the url should be correct")
	public void i_should_land_on_login_page_and_the_url_should_be_correct() {
		String url = Driver.getDriver().getCurrentUrl();
		Assert.assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account", url);
		 
	}
	
	
	@Then("The username, password and login button elements should be enabled")
	public void the_username_password_and_login_button_elements_should_be_enabled() {
	    LoginPage lp= new LoginPage();
	    
	    Assert.assertTrue(lp.usernameField.isEnabled());
	    Assert.assertTrue(lp.passwordField.isEnabled());
	    Assert.assertTrue(lp.loginButton.isEnabled());
	    
	  
		
	}
	
	
	
	@When("I enter {string} to email field")
	public void iEnterToEmailField(String email) {
	   new LoginPage().usernameField.sendKeys(email);
	}

	@When("I enter {string} to password field")
	public void iEnterToPasswordField(String pass) {
		 new LoginPage().passwordField.sendKeys(pass);
		 new LoginPage().loginButton.click();
	}

	@Then("I should be able to login and name should be {string}")
	public void iShouldBeAbleToLogin(String name) {
	    
		Assert.assertEquals(name, new MyAccountPage().customerNameLink.getText());
	}
	

}

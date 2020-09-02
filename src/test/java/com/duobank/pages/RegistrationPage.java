package com.duobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.duobank.utilities.Driver;



public class RegistrationPage {

	public RegistrationPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	//Julia's elements 
	
	//login
	@FindBy (xpath = "//input[@id='exampleInputEmail1']")
	public WebElement emailField;
	
	@FindBy (xpath = "//input[@id='exampleInputPassword1']")
	public WebElement passwordField;
	
	@FindBy (xpath = "//button[@name='login']")
	public WebElement loginButton;
	
	//sign up
	@FindBy (xpath = "//input[@name='first_name']")
	public WebElement firstName;
	
	@FindBy (xpath = "//input[@name='last_name']")
	public WebElement lastName;

	@FindBy (xpath = "//input[@id='email']")
	public WebElement emailField2;//sign up email
	
	@FindBy (xpath = "//input[@id='exampleInputPassword1']")
	public WebElement passwordField2;//sign up password
	
	@FindBy (xpath = "//button[@name='register']")
	public WebElement signUp;
	
	
	
	@FindBy (xpath = "//a[.='Sign up']")
	public WebElement accSignUpButton;
	
	@FindBy (xpath = "//a[@href=\"index.php\"]")
	public WebElement accSignInButton;
	
	
	
	@FindBy (xpath = "//span[@class='user-name']")
	public WebElement nameConfirmation;
	
}

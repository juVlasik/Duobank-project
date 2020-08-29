package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.utilities.Driver;

public class UserDetailsPage {
	
	public UserDetailsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (xpath = "//button[.='USER DETAILS']")
	public WebElement userDetailsButton;
	
	@FindBy (name = "email")
	public WebElement emailBox;
	
	
	
	
	
	

}

package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.utilities.Driver;

public class MainPage {
	
	public MainPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (xpath = "//span[@onclick=\"openPage('settings.php')\"]")
	public WebElement name;
	
	
	
	
	

}

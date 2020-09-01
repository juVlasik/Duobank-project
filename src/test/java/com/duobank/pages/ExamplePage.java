package com.duobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.duobank.utilities.Driver;

public class ExamplePage {
	
	public ExamplePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
}

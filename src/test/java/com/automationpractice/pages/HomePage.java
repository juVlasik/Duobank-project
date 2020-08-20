package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.utilities.Driver;

public class HomePage {
	
	public HomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	
	@FindBy (xpath = "//a[@title='Log in to your customer account']")
	public WebElement signInButton;
	

	@FindBy (xpath = "(//a[contains( text(), 'Blouse')])[2]")
	public WebElement blouse;
	
	@FindBy (xpath = "(//a[contains( text(), 'Blouse')])[2]")
	public WebElement product;


	@FindBy (xpath = "(//a[@title='Dresses'])[2]")
	public WebElement dressButton;
	
	
	public void clickOnProduct(String product) {
		getProduct(product).click();
		
	}
	
	public WebElement getProduct(String product) {
		String xpath = "//h5//a[@title='"+product+"']";
		return Driver.getDriver().findElement(By.xpath(xpath));
		
	}

}

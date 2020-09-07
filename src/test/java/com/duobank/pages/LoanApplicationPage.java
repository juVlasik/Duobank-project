package com.duobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.duobank.utilities.Driver;

public class LoanApplicationPage {

	public LoanApplicationPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	//loan application elements
	
	@FindBy (xpath = "(//label[.='No'])[1]")
	public WebElement checkbox1;
	
	@FindBy (xpath = "(//label[.='No'])[2]")
	public WebElement checkbox2;
	
	@FindBy (xpath = "//input[@name='est_purchase_price']")
	public WebElement estPurchPrice;
	
	@FindBy (xpath = "//input[@id='downpayment']")
	public WebElement downPaymentAmount;
	
	@FindBy (xpath = "//a[.='Next']")
	public WebElement nextButton;
	
	@FindBy (xpath = "(//label[.='No'])[3]")
	public WebElement checkbox3;
	
	@FindBy (xpath = "//input[@id='b_firstName']")
	public WebElement firstName;
	
	@FindBy (xpath = "//input[@id='b_middleName']")
	public WebElement middleName;
	
	@FindBy (xpath = "//input[@id='b_lastName']")
	public WebElement lastName;
	
	@FindBy (xpath = "//input[@id='b_dob']")
	public WebElement email;
	
	@FindBy (xpath = "//input[@id='b_dob']")
	public WebElement dobField;
	
	@FindBy (xpath = "//input[@id='b_ssn']")
	public WebElement ssnField;
	
	@FindBy (xpath = "//span[@id='select2-b_marital-container']")
	public WebElement maritalStatusField;
	
	@FindBy (xpath = "//input[@id='b_cell']")
	public WebElement cellField;
	
	@FindBy (xpath = "//a[.='Next']")
	public WebElement nextButton2;
	
	@FindBy (xpath = "//input[@value='Own']")
	public WebElement houseOwnCheckbox;
	
	@FindBy (xpath = "firtmortagagetotalpayment")
	public WebElement mortgagePayment;
	
	@FindBy (xpath = "//input[@id='grossmonthlyincome']")
	public WebElement grossMonthlyIncome;
	
	@FindBy (xpath = "//a[.='Next']")
	public WebElement nextButton3;
	
	@FindBy (xpath = "//input[@id='employername1']")
	public WebElement employerName;
	
	@FindBy (xpath = "//a[.='Next']")
	public WebElement nextButton4;
	
	@FindBy (xpath = "//a[.='Next']")
	public WebElement nextButton5;
	
	@FindBy (xpath = "//input[@id='eConsentdeclarerFirstName']")
	public WebElement firstNameConsent;
	
	@FindBy (xpath = "//input[@id='eConsentdeclarerLastName']")
	public WebElement lastNameConsent;
	
	@FindBy (xpath = "eConsentdeclarerEmail']")
	public WebElement emailConsent;
	
	@FindBy (xpath = "//a[.='Next']")
	public WebElement nextButton6;
	
	@FindBy (xpath = "//a[.='Save']")
	public WebElement saveButton;
	
	
	
	
	
}

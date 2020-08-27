package com.automationpractice.pojos;

public class User {
	
	
	private String firstName;
	private String lastName;
	private String password;
	
	private String username;
	private String email;
	
	
	public User(String firstName, String lastName, String password, String username, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.username = username;
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	
	
	
	public String getUsername() {
		return username;
	}


	
	public String getEmail() {
		return email;
	}


	
	
	
	
	

}

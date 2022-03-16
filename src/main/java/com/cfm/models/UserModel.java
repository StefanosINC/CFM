package com.cfm.models;

/*
 * UserModel Class that is going to hold the variables for the User
 * This class will need a relationship with the addressbook
 */

public class UserModel {


	private String username;
	
	private String password;

	
	
	/*
	 * Constructor for the UserModel
	 */
	public UserModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	/*
	 * Getters and Setters
	 */

	public UserModel() {
		// TODO Auto-generated constructor stub
	}


	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}

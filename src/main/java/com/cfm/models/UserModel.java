package com.cfm.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * UserModel Class that is going to hold the variables for the User
 * This class will need a relationship with the addressbook
 */

public class UserModel {


	/*
	 * Values for the User Model
	 * @Param - Not Null, Size
	 */
	@NotNull(message="Username is a required field")
	@Size(min=1, max=32, message="Username must be between 1 and 32 charachters")
	private String username;
	
	
	@NotNull(message="Password is a required field")
	@Size(min=1, max=32, message="Password must be between 1 and 32 charachters")
	private String password;

	
	
	/*
	 * Constructor for the UserModel
	 */
	public UserModel(String username, String password) {
		
		this.username = username;
		this.password = password;
	}

	/*
	 * Default Constructor
	 */
	public UserModel() {
		// TODO Auto-generated constructor stub
	}



	/*
	 * Getters and Setters
	 */


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

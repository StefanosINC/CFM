package com.cfm.business;

import com.cfm.models.UserModel;

/*
 * Interface for the User Model services
 * This interface instantiates the Spring Beans and calls the Init and Destroy methods
 * This handles the Register and login methods
 */
public interface UserModelBusinessInterface {

	
	public void init();
	public void destroy();
	public void Register(UserModel user);
	public boolean Login(UserModel user);
}

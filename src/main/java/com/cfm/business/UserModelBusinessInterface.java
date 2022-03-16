package com.cfm.business;

import com.cfm.models.UserModel;

public interface UserModelBusinessInterface {

	public void init();
	public void destroy();
	public void Register(UserModel user);
	public boolean Login(UserModel user);
}

package com.cfm.data;

import com.cfm.models.UserModel;

public interface UserModelDataInterface {

	public void init();
	public void destroy();
	
	public boolean Register(UserModel user);
	
	public boolean Login(UserModel user);
}

package com.cfm.data;

import com.cfm.models.UserModel;

/*
 * This is the UserModeldataInterface.
 * This interface is responsible for the Register and Login methods and anything related that may arise for the dataservice
 */
public interface UserModelDataInterface {
	
	public boolean Register(UserModel user);
	
	public boolean Login(UserModel user);
}

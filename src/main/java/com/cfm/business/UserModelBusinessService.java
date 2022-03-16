package com.cfm.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfm.data.UserModelDataInterface;
import com.cfm.models.UserModel;

@Service
public class UserModelBusinessService implements UserModelBusinessInterface {

	@Autowired
	UserModelDataInterface dataservice;
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Register(UserModel user) {
		
		dataservice.Register(user);
		
	}

	@Override
	public boolean Login(UserModel user) {
	
		return dataservice.Login(user);
	}

}

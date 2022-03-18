package com.cfm.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfm.data.UserModelDataInterface;
import com.cfm.models.UserModel;

/*
 * Service class for the business logic for the UserModel services
 * This is responsible for inheriting the database service logic to push methods to the controller!
 */
@Service
public class UserModelBusinessService implements UserModelBusinessInterface {

	/*
	 * Autowire the datainterface service
	 */
	@Autowired
	UserModelDataInterface dataservice;
	
	/*
	 * Spring Bean init
	 */
	@Override
	
	public void init() {
		// TODO Auto-generated method stub
		System.out.println(" Spring Bean init Business ");
	}

	/*
	 * Spring Bean destroy
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println(" Spring Bean init");
	}

	/*
	 * Registering a user. Call on the dataservice object autowired to register a usermodel
	 * @Param - UserModel user
	 * @Return user
	 */
	@Override
	public void Register(UserModel user) {
		
		dataservice.Register(user);
		
	}

	/*
	 * Login a user. Call on the dataservice object autowired to Login a usermodel
	 * @Param - UserModel user
	 * @Return user
	 */
	@Override
	public boolean Login(UserModel user) {
	
		return dataservice.Login(user);
	}

}

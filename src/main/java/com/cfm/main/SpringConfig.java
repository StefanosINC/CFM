package com.cfm.main;

import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.SessionScope;

import com.cfm.business.AddressBookModelBusinessInterface;
import com.cfm.business.AddressBookModelBusinessService;
import com.cfm.business.UserModelBusinessInterface;
import com.cfm.business.UserModelBusinessService;



public class SpringConfig {

	
	@Bean(name="AddressBookModelBusinessService", initMethod="init", destroyMethod="destroy")
	@SessionScope
	public AddressBookModelBusinessInterface getAddressBook() {
		return new AddressBookModelBusinessService();
	}

	
	@Bean(name="UserModelBusinessService", initMethod="init", destroyMethod="destroy")
	@SessionScope
	public UserModelBusinessInterface getUserModel() {
		return new UserModelBusinessService();
			
}
}
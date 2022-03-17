package com.cfm.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.context.annotation.SessionScope;

import com.cfm.business.AddressBookModelBusinessInterface;
import com.cfm.business.AddressBookModelBusinessService;
import com.cfm.business.UserModelBusinessInterface;
import com.cfm.business.UserModelBusinessService;


/*
 *SpringConfig class
 *This class is responsible for creating the Spring Beans for the Spring Boot Framework! 
 * 
 */
@Configuration
public class SpringConfig {

	
	@Bean(name="AddressBookModelBusinessService", initMethod="init", destroyMethod="destroy")
	
	public AddressBookModelBusinessInterface getAddressBook() {		return new AddressBookModelBusinessService();
	}

	
	@Bean(name="UserModelBusinessService", initMethod="init", destroyMethod="destroy")
	@Primary
	public UserModelBusinessInterface getUserModel() {
		return new UserModelBusinessService();
			
}
}
package com.cfm.business;

import java.util.List;

import com.cfm.models.AddressBookModel;
/*
 * Interface for the AddressBook functionality CRUD and findbyID
 * This interface instantiates the Spring Beans and calls the Init and Destroy methods
 */
public interface AddressBookModelBusinessInterface {

	public List<AddressBookModel> FindAllContacts();
	
	public AddressBookModel FindById(int id);
	
	public boolean create(AddressBookModel contact);
	
	public boolean update( AddressBookModel contact);
	
	public int RemoveContact(int id);
	
	public void init();
	
	public void destroy();
}

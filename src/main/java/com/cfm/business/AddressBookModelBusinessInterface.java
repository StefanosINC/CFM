package com.cfm.business;

import java.util.List;

import com.cfm.models.AddressBookModel;

public interface AddressBookModelBusinessInterface {

	public List<AddressBookModel> FindAllContacts();
	
	public AddressBookModel FindById(int id);
	
	public boolean create(AddressBookModel contact);
	
	public boolean update( AddressBookModel contact);
	
	public int RemoveContact(int id);
	
	public void init();
	
	public void destroy();
}

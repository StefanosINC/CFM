package com.cfm.data;

import java.util.List;

import com.cfm.models.AddressBookModel;

public interface AddressBookDataInterface{

	
	public List<AddressBookModel> FindAllContacts();
	
	public AddressBookModel findById(int id);

	public boolean create(AddressBookModel contact);
	
	public boolean update(AddressBookModel contact);
	
	public int RemoveContact(int id);
}

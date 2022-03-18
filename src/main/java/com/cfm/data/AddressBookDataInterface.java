package com.cfm.data;

import java.util.List;

import com.cfm.models.AddressBookModel;

/*
 * Address Book Interface. 
 * This class is responsible for the AddressBookDataService.
 * @Param - AddressBookModel, int id, and List of AddressBookModel
 */
public interface AddressBookDataInterface{

	
	public List<AddressBookModel> FindAllContacts();
	
	public AddressBookModel findById(int id);

	public boolean create(AddressBookModel contact);
	
	public boolean update(AddressBookModel contact);
	
	public int RemoveContact(int id);
}

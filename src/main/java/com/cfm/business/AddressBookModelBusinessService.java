package com.cfm.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfm.data.AddressBookDataInterface;
import com.cfm.models.AddressBookModel;

/*
 * This is the AddressBookModel Business service which will implement the methods from the Interface provided
 * This class will be responsible for implementing and creating seperation between teh dataservice class and the views as well
 * MVC architecture.
 * THis implements the CRUD functionality and find by ID
 */
@Service
public class AddressBookModelBusinessService implements AddressBookModelBusinessInterface{

	
	/*
	 * @Autwire the datainterface service
	 */
	@Autowired
	private AddressBookDataInterface service;
	
	/*
	 * Find all the contacts in the addressbook
	 * @return - all the contacts in the list
	 */
	@Override
	public List<AddressBookModel> FindAllContacts() {
		
		return service.FindAllContacts();
		
	}

	/*
	 * Find the AddressBookModel object by the Id
	 * @Param - id
	 * @Return - find the specific object by its ID
	 */
	
	@Override
	public AddressBookModel FindById(int id) {
		
		return service.findById(id);
	}

	/*
	 * Create the AddressBook object
	 * @Param - AddressBookModel
	 * @Return - a created object of AddressBookModel
	 */
	@Override
	public boolean create(AddressBookModel contact) {
		
		return service.create(contact);
	}

	/*
	 * Update the AddressBookModel Object
	 * @Param - AddressBookModel
	 * @Return - updated contact object of(AddressBookModel)
	 */
	@Override
	public boolean update(AddressBookModel contact) {
		
		return service.update(contact);
	}

	/*
	 * Delete the AddressBookModel Object
	 * @Param - int id
	 * @Return - delete contact object of(AddressBookModel)
	 */
	@Override
	public int RemoveContact(int id) {
		
		return service.RemoveContact(id);
		
	}

	/*
	 * Spring Bean Init
	 */
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Spring Bean destroy
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	
}

package com.cfm.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfm.data.AddressBookDataInterface;
import com.cfm.models.AddressBookModel;


@Service
public class AddressBookModelBusinessService implements AddressBookModelBusinessInterface{

	
	@Autowired
	private AddressBookDataInterface service;
	
	@Override
	public List<AddressBookModel> FindAllContacts() {
		
		return service.FindAllContacts();
		
	}

	@Override
	public AddressBookModel FindById(int id) {
		
		return service.findById(id);
	}

	@Override
	public boolean create(AddressBookModel contact) {
		
		return service.create(contact);
	}

	@Override
	public boolean update(AddressBookModel contact) {
		
		return service.update(contact);
	}

	@Override
	public int RemoveContact(int id) {
		
		return service.RemoveContact(id);
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	
}

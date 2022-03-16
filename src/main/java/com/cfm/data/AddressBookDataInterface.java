package com.cfm.data;

import java.util.List;

public interface AddressBookDataInterface <T>{

	
	public List<T> FindAllContacts();
	
	public T findById(int id);

	public boolean create(T contact);
	
	public boolean update(T contact);
	
	public long RemoveContact(int id);
}

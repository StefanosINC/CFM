package com.cfm.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * 
 * This is the AddressBookModel Class
 * This class will declare the varaibles, constructors, and getters and setters for the adressbook
 * 
 */
public class AddressBookModel {

	
	private long id;
	@NotNull(message="LocationName is a required field")
	@Size(min=1, max=32, message="LocationName must be between 1 and 32 charachters")
	private String locationname;
	
	@NotNull(message="Phone is a required field")
	@Size(min=1, max=32, message="Phone must be between 1 and 32 charachters")
	private String phone;
	

	
	@NotNull(message="Street is a required field")
	@Size(min=1, max=32, message="Street must be between 1 and 32 charachters")
	private String street;
	
	@NotNull(message="Street is a required field")
	@Size(min=1, max=32, message="Street must be between 1 and 32 charachters")
	private String zipcode;
	
	@NotNull(message="City is a required field")
	@Size(min=1, max=32, message="City must be between 1 and 32 charachters")
	private String city;
	
	@NotNull(message="State is a required field")
	@Size(min=1, max=32, message="State must be between 1 and 32 charachters")
	private String state;

	
	
public AddressBookModel(long id, String locationname, String phone, String street, String zipcode,
		String city, String state) {
	super();
	this.id = id;
	this.locationname = locationname;
	this.phone = phone;
	this.street = street;
	this.zipcode = zipcode;
	this.city = city;
	this.state = state;
}
public AddressBookModel() {
	
}







public long getId() {
	return id;
}



public void setId(long id) {
	this.id = id;
}



public String getLocationname() {
	return locationname;
}



public void setLocationname(String locationname) {
	this.locationname = locationname;
}



public String getPhone() {
	return phone;
}



public void setPhone(String phone) {
	this.phone = phone;
}



public String getStreet() {
	return street;
}



public void setStreet(String street) {
	this.street = street;
}



public String getZipcode() {
	return zipcode;
}



public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}



public String getCity() {
	return city;
}



public void setCity(String city) {
	this.city = city;
}



public String getState() {
	return state;
}



public void setState(String state) {
	this.state = state;
}
	
	
	
	
	
	
}

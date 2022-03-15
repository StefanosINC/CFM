package com.cfm.models;

/*
 * 
 * This is the AddressBookModel Class
 * This class will declare the varaibles, constructors, and getters and setters for the adressbook
 * 
 */
public class AddressBookModel {

	
	private long id;
	
	private String firstname;
	private String lastname;
	private String phone;
	private String address;
	
	
	
	
	/*
	 * AddressBookModel Constructor
	 */
	public AddressBookModel(long id, String firstname, String lastname, String phone, String address) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.address = address;
	}
	
	/*
	 * AddressBookModel Default Constructor
	 */
	public AddressBookModel() {
		
	}

	
	/*
	 * 
	 * Getters and Setters
	 */
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}

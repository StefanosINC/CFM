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
	@NotNull(message="Firstname is a required field")
	@Size(min=1, max=32, message="Firstname must be between 1 and 32 charachters")
	private String firstname;
	
	
	@NotNull(message="Lastname is a required field")
	@Size(min=1, max=32, message="Lastname must be between 1 and 32 charachters")
	private String lastname;
	
	@NotNull(message="Phone is a required field")
	@Size(min=1, max=32, message="Phone must be between 1 and 32 charachters")
	private String phone;
	
	
	@NotNull(message="Phone is a required field")
	@Size(min=1, max=32, message="Phone must be between 1 and 32 charachters")
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

	@Override
	public String toString() {
		return "AddressBookModel [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", phone=" + phone
				+ ", address=" + address + "]";
	}
	
	
}

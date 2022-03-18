package com.cfm.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.cfm.models.AddressBookModel;

/*
 * Service class AddresBookDataService implementing the Interface
 * This class is responisble for the logic connecting to the database and CRUD functionality!
 * This class instanciates a jdbctemplate object and Datasource
 * 
 */
@Service
public class AddressBookDataService implements AddressBookDataInterface {

	/*
	 * @Autowired the datasource object.
	 */
	@Autowired
	private DataSource dataSource;
	
	/*
	 * @Autowired the JdbcTemplate Object
	 */
	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	
	/*
	 * AddressBookDataService constructor for the datasource and jdbc template
	 */
	public AddressBookDataService(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	
	/*
	 * This method is responsible for finding all the contacts in the AddressBookModel
	 * I query for the list with an SQL statement and loop through the database
	 * I add each to the contacts ArrayList I instantiated. 
	 * @Param -List<AddressBookModel>
	 * @Return -Contacts ( AddressBookList) 
	 */
	@Override
	public List<AddressBookModel> FindAllContacts() {
		
		String sql = "Select * FROM ADDRESSBOOK";
		List<AddressBookModel> contacts = new ArrayList<AddressBookModel>();
		
		try {
			
			// execute SQL
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next())
			{
				contacts.add(new AddressBookModel(
						srs.getLong("ID"),
						srs.getString("LOCATIONNAME"),
						srs.getString("PHONE"),
						srs.getString("STREET"),
						srs.getString("ZIPCODE"),
						srs.getString("CITY"),
						srs.getString("STATE")));
					
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return contacts;
	}

	/*
	 * @Param int id,
	 * Initiate a Sql statement to find the addressbook where ID =? 
	 * Initiate a AddressBook Model object
	 * Query the row set and get gather the data into a contact and the ID
	 * @Return contact
	 */
	@Override
	public AddressBookModel findById(int id) {
	
		String sql = "SELECT * FROM ADDRESSBOOK WHERE ID = ? ";
		
		AddressBookModel contact;
		
		try {
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql, id);
			srs.next();
			contact = new AddressBookModel(	
					srs.getLong("ID"),
					srs.getString("LOCATIONNAME"),
					srs.getString("PHONE"),
					srs.getString("STREET"),
					srs.getString("ZIPCODE"),
					srs.getString("CITY"),
					srs.getString("STATE"));
				
			return contact;
					
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * This is method is responsible for a insert query into the database to create a AddressBookModel into the database.
	 * This is a boolean method and if there is a failure when creating a new Addres it will return false, if not it will return true.
	 * @Param - AddressModel user
	 * @Return - true ( new contact object) 
	 */
	@Override
	public boolean create(AddressBookModel contact) {
	
		String sql = "INSERT INTO ADDRESSBOOK(LOCATIONNAME, PHONE, STREET, ZIPCODE, CITY, STATE) VALUES (?, ? , ? ,?, ?, ?)";
		try {
			int NewRow = jdbcTemplateObject.update(sql, contact.getLocationname(), contact.getPhone(), contact.getStreet(), contact.getZipcode(), contact.getCity(), contact.getState());
			return NewRow == 1 ? true : false;
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return false;
		
	}

	
	/*
	 * This method is responsible for the updating aspect for the AddressBookModel objects.
	 * Instantiate a Sql query to update the data in the database
	 * Try Catch and call on the jdbcTemplateObject to update the statement
	 * @Param - AddressBookModel
	 * @Return - true ( an updated contact)
	 */
	@Override
	public boolean update(AddressBookModel contact) {
		
		String sql = "UPDATE ADDRESSBOOK SET LOCATIONNAME = ?, PHONE = ?, STREET = ?, ZIPCODE = ?, CITY = ?, STATE =? WHERE id = ?";
		
		try {
			int UpdateRow = jdbcTemplateObject.update(sql,  contact.getLocationname(), contact.getPhone(), contact.getStreet(), contact.getZipcode(), contact.getCity(), contact.getState(), contact.getId());
			return UpdateRow == 1 ? true : false;
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}





	/*
	 * Remove a contact from the database
	 * return a JdbcTemplateObject and delete it. Reference the object you want to grab by the ID
	 */
	@Override
	public int RemoveContact(int id) {
		
		return jdbcTemplateObject.update("DELETE FROM ADDRESSBOOK WHERE id =?", id);
		
		
	}
	
	

	
	
	
}

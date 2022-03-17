package com.cfm.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.cfm.models.AddressBookModel;

@Service
public class AddressBookDataService implements AddressBookDataInterface {

	// ?
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplateObject;
	
	public AddressBookDataService(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	
	
	
	
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
						srs.getInt("ID"),
						srs.getString("FIRSTNAME"),
						srs.getString("LASTNAME"),
						srs.getString("PHONE"),
						srs.getString("ADDRESS")));
					
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return contacts;
	}

	@Override
	public AddressBookModel findById(int id) {
	
		String sql = "SELECT * FROM ADDRESSBOOK WHERE ID = ? ";
		
		AddressBookModel contact;
		
		try {
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql, id);
			srs.next();
			contact = new AddressBookModel(	
						srs.getInt("ID"),
						srs.getString("FIRSTNAME"),
						srs.getString("LASTNAME"),
						srs.getString("PHONE"),
						srs.getString("ADDRESS"));
			return contact;
					
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean create(AddressBookModel contact) {
	
		String sql = "INSERT INTO ADDRESSBOOK(FIRSTNAME, LASTNAME, PHONE, ADDRESS) VALUES (?, ? , ? , ?)";
		try {
			int NewRow = jdbcTemplateObject.update(sql, contact.getFirstname(), contact.getLastname(), contact.getPhone(), contact.getAddress());
			return NewRow == 1 ? true : false;
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return false;
		
	}

	
	@Override
	public boolean update(AddressBookModel contact) {
		
		String sql = "UPDATE ADRESSBOOK SET FIRSTNAME = ?, LASTNAME = ?, PHONE = ? , ADDRESS = ? WHERE id = ?";
		
		try {
			int UpdateRow = jdbcTemplateObject.update(sql, contact.getFirstname(), contact.getLastname(), contact.getPhone(), contact.getAddress());
			return UpdateRow == 1 ? true : false;
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}





	@Override
	public int RemoveContact(int id) {
		
		return jdbcTemplateObject.update("DELETE FROM ADDRESSBOOK WHERE id =?", id);
		
		
	}
	
	

	
	
	
}

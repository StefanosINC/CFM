package com.cfm.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.cfm.models.UserModel;

/*
 * @Service
 * This is the UserModelDataService, This implements methods from the UserModelDataInterface. \
 * This class will be responsible for handling the logic to the database
 * and responsible for declaring a JDBC data soruce.
 */
@Service
public class UserModelDataService implements UserModelDataInterface {

	/*
	 * @Autowire the DataSource
	 */
	@SuppressWarnings("unused")
	@Autowired
	private DataSource dataSource;
	
	/*
	 * @Autowire an instance of the JdbcTemplate
	 */
	@Autowired
	private JdbcTemplate jdbcTemplateObject;

	
	/*
	 * Create a constructor using the datasource and teh jdbc template.
	 *  
	 */
	public UserModelDataService(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	
}


	/*
	 * This is method is responsible for a insert query into the database to create a new User into the database.
	 * This is a boolean method and if there is a failure when creating a user it will return false, if not it will return true.
	 * @Param - UserModel user
	 * @Return - true ( new user object) 
	 */
	@Override
	public boolean Register(UserModel user) {
		
		// sql
			String sql = "INSERT INTO users(USERNAME, PASSWORD) VALUES(?,?)";
		
		try {
			// row set
			int rows = jdbcTemplateObject.update(sql, user.getUsername(), user.getPassword());
			return rows == 1 ? true : false;
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * This is method is responsible for a verifyin users into the database.
	 * This is a boolean method and if there is a failure when logging in  a user it will return false, if not it will return true.
	 * Loop through try catch to verify the data and if false then return so
	 * @Param - UserModel user
	 * @Return - true ( validate the user object) 
	 */
	@Override
	public boolean Login(UserModel user) {
		
		// sql
		  String sql = "SELECT * FROM users WHERE USERNAME = '" + user.getUsername() + "' AND PASSWORD = '"
	                + user.getPassword() + "'";
	 try {
	
		 // login set
		 SqlRowSet LoginRowSet = jdbcTemplateObject.queryForRowSet(sql);
	
		 
		 if(LoginRowSet.next()) {
			 System.out.println(" The login verified ");
			 
			 return true;
			 
		 }
		 // catch
	 }	 catch(Exception E) {
		 System.out.println("Login failed");
			 E.printStackTrace();
		
			 return false;
		 }
	 
	return false;
	}

}

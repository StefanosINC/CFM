package com.cfm.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.cfm.models.UserModel;

@Service
public class UserModelDataService implements UserModelDataInterface {

	@SuppressWarnings("unused")
	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplateObject;

	
	//Using JDBC datasource 
	public UserModelDataService(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	
}
	
	
	
	@Override
	public void init() {
		// Spring bean
	}

	@Override
	public void destroy() {
		
		// Spring Bean
	}

	@Override
	public boolean Register(UserModel user) {
		
			String sql = "INSERT INTO users(USERNAME, PASSWORD) VALUES(?,?)";
		
		try {
			int rows = jdbcTemplateObject.update(sql, user.getUsername(), user.getPassword());
			return rows == 1 ? true : false;
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean Login(UserModel user) {
	
		String sql = "SELECT * FROM users WHERE USERNAME = '" + user.getUsername() + "' AND PASSWORD = '"
                + user.getPassword() + " ";
	 try {
	
		 SqlRowSet LoginRowSet = jdbcTemplateObject.queryForRowSet(sql);
	
		 
		 if(LoginRowSet.next()) {
			 System.out.println(" The login verified ");
			 
			 return true;
			 
		 }
	 }	 catch(Exception E) {
		 System.out.println("Login failed");
			 E.printStackTrace();
		
			 return false;
		 }
	 
	return false;
	}

}

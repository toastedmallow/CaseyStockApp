package cs3750.stock.app.controller;

import java.sql.ResultSet;  
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cs3750.stock.app.model.User;

@SuppressWarnings("rawtypes")
public class UserMapper implements RowMapper{
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {  
		String firstName = rs.getString("FIRST_NAME");
		String lastName = rs.getString("LAST_NAME");
		String username = rs.getString("username");
		double balance = rs.getDouble("BALANCE");
		int userId = rs.getInt("USER_ID");
		User user = new User(firstName, lastName, username, balance, userId);
		return user;
	} 
}

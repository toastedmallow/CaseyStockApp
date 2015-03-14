package cs3750.stock.app.controller;

import java.sql.ResultSet;  
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cs3750.stock.app.model.User;

@SuppressWarnings("rawtypes")
public class UserMapper implements RowMapper{
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {    
		User user = new User();    
		user.setFirst_name(rs.getString("FIRST_NAME"));
		user.setLast_name(rs.getString("LAST_NAME"));
		user.setBalance(rs.getDouble("BALANCE"));
		return user;    
	} 
}

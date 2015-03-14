package cs3750.stock.app.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cs3750.stock.app.model.Transaction;

@SuppressWarnings("rawtypes")
public class TransactionMapper implements RowMapper{
	public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {    
		Transaction transaction = new Transaction();    
		transaction.setStck_id(rs.getInt("STCK_ID"));
		transaction.setUser_id(rs.getInt("USER_ID"));
		transaction.setStck_qnty(rs.getInt("STCK_QNTY"));
		return transaction;    
	} 
}

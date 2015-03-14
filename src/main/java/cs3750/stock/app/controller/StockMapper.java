package cs3750.stock.app.controller;

import java.sql.ResultSet;  
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cs3750.stock.app.model.Stock;

@SuppressWarnings("rawtypes")
public class StockMapper implements RowMapper{
	public Stock mapRow(ResultSet rs, int rowNum) throws SQLException {    
		Stock stocks = new Stock();    
		stocks.setStck_price(rs.getDouble("STCK_PRICE"));
		stocks.setStck_symbl(rs.getString("STCK_SYMBL"));
		return stocks;    
	} 
}

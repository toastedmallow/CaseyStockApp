package cs3750.stock.app.model;

import java.util.List;

public class MainModel {

	private User user;
	private List<Stock> stockList;
	
	public MainModel(User user, List<Stock> stockList){
		this.user = user;
		this.stockList = stockList;
	}

	public User getUser() {
		return user;
	}

	public List<Stock> getStockList() {
		return stockList;
	}
	
	
}

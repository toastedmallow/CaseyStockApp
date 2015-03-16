package cs3750.stock.app.model;

import java.util.List;

public class MainModel implements java.io.Serializable{

	private static User user;
	private static List<Stock> stockList;
	
	public MainModel(){
	}

	public static void setUser(User user) {
		MainModel.user = user;
	}

	public static void setStockList(List<Stock> stockList) {
		MainModel.stockList = stockList;
	}


	public static User getUser() {
		return user;
	}

	public static List<Stock> getStockList() {
		return stockList;
	}
}

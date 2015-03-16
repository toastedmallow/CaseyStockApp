package cs3750.stock.app.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cs3750.stock.app.model.MyYapi;
import cs3750.stock.app.model.Stock;
import cs3750.stock.app.model.Transaction;
import cs3750.stock.app.model.User;

@Controller
public class ContentController {
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
    @RequestMapping("/login")
    public String getLogin(Model m){
        return "login";
    }
    
    @SuppressWarnings("unchecked")
    @RequestMapping("/successfulLogin")
    public String setupModel(ModelMap model, Principal principal){
    	String username = principal.getName(); //get logged in username
        
        String SQL = "SELECT * FROM users WHERE username = :username";  
		SqlParameterSource namedParameters = new MapSqlParameterSource("username", String.valueOf(username));
		User user = (User) jdbc.queryForObject(SQL, namedParameters, new UserMapper()); 
		System.out.println("Model is setup");
        
        model.addAttribute("user", user);
        return "viewstocks";
    }
    
	@RequestMapping("/getAllStocks")
	public @ResponseBody Object getAllStocks(){
		Map<String, Object> data = new HashMap<>();
		data.put("STCK_ID", 1);
		data.put("STCK_SYMBL", 2);
		data.put("STCK_PRICE", 3);
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<Stock> stocks = jdbc.query("select * from STOCKS", new BeanPropertyRowMapper(Stock.class) ); 
		return stocks;
	}
	
	@RequestMapping("/getStock/{stockId}")
	public @ResponseBody Object getSomeStock(@PathVariable int stockId){
		Map<String, Object> data = new HashMap<>();
		data.put("STCK_ID", stockId);
		
		@SuppressWarnings("unchecked")
		List<Stock> stocks = jdbc.query("select * from STOCKS where stck_id = :STCK_ID", data, new BeanPropertyRowMapper(Stock.class) );		
		return stocks.isEmpty() ? null : stocks.get(0);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/insertTransaction")
	public @ResponseBody Object insertTransaction(String stockId, Integer userId, Integer stockQnty){
		String sql = "insert into stocks (TRANS_ID, STCK_ID, USER_ID, STCK_QNTY) values (:TRANS_ID, :STCK_ID, :USER_ID, :STCK_QNTY)";
		@SuppressWarnings("rawtypes")
		Map data = new HashMap();
		data.put("TRANS_ID",  null);
		data.put("STCK_ID", stockId);
		data.put("USER_ID", userId);
		data.put("STCK_QNTY", stockQnty);
		jdbc.update(sql, data);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/insertStocks")
	public @ResponseBody Object insertStocks(String symbol){
		MyYapi stockInsert = new MyYapi(symbol);
		String sql = "insert into stocks (STCK_ID, STCK_SYMBL, STCK_PRICE) values (:STCK_ID, :STCK_SYMBL, :STCK_PRICE)";
		@SuppressWarnings("rawtypes")
		Map data = new HashMap();
		data.put("STCK_ID", null);
		data.put("STCK_SYMBL", symbol);
		data.put("STCK_PRICE", stockInsert.getPrice());
		jdbc.update(sql, data);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/insertUser")
	public @ResponseBody Object insertUser(String firstName, String lastName, double balance){
		String sql = "insert into users (USER_ID, FIRST_NAME, LAST_NAME, BALANCE) values (:USER_ID, :FIRST_NAME, :LAST_NAME, :BALANCE)";
		@SuppressWarnings("rawtypes")
		Map data = new HashMap();
		data.put("USER_ID", null);
		data.put("FIRST_NAME", firstName);
		data.put("LAST_NAME", lastName);
		data.put("BALANCE", balance);
		jdbc.update(sql, data);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/updateStocks")
	public @ResponseBody Object updateStockPrice(String symbol){
		MyYapi stockUpdate = new MyYapi(symbol);
		String sql = "update stocks set STCK_PRICE = :STCK_PRICE where STCK_SYMBL = :STCK_SYMBL";
		@SuppressWarnings("rawtypes")
		Map data = new HashMap();
		data.put("STCK_PRICE", stockUpdate.getPrice());
		data.put("STCK_SYMBL", symbol);
		jdbc.update(sql, data);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/updateUser")
	public @ResponseBody Object updateStockQnty(Integer transId, Integer stockQnty){
		String sql = "update stocks set STCK_QNTY = :STCK_QNTY where TRANS_ID = :TRANS_ID";
		@SuppressWarnings("rawtypes")
		Map data = new HashMap();
		data.put("STCK_QNTY", stockQnty);
		data.put("TRANS_ID", transId);
		jdbc.update(sql, data);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/updateTransaction")
	public @ResponseBody Object updateBalance(Integer userId, double balance){
		String sql = "update stocks set BALANCE = :BALANCE where USER_ID = :USER_ID";
		@SuppressWarnings("rawtypes")
		Map data = new HashMap();
		data.put("BALANCE", balance);
		data.put("USER_ID", userId);
		jdbc.update(sql, data);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/getStocks")
	public @ResponseBody Object getStocks(Integer stockId){
		   String SQL = "SELECT * FROM stocks WHERE STCK_ID = :STCK_ID";  
		   SqlParameterSource namedParameters = new MapSqlParameterSource("STCK_ID", Integer.valueOf(stockId));  
		   Stock stocks = (Stock) jdbc.queryForObject(SQL, namedParameters, new StockMapper());  
		 return stocks; 
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/getUser")
	public @ResponseBody Object getUser(Integer userId){
		   String SQL = "SELECT * FROM users WHERE USER_ID = :USER_ID";  
		   SqlParameterSource namedParameters = new MapSqlParameterSource("USER_ID", Integer.valueOf(userId));  
		   User user = (User) jdbc.queryForObject(SQL, namedParameters, new UserMapper());  
		 return user; 
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/getTransaction")
	public @ResponseBody Object getTransaction(Integer transId){
		   String SQL = "SELECT * FROM transactions WHERE TRANS_ID = :TRANS_ID";  
		   SqlParameterSource namedParameters = new MapSqlParameterSource("TRANS_ID", Integer.valueOf(transId));  
		   Transaction transaction = (Transaction) jdbc.queryForObject(SQL, namedParameters, new TransactionMapper()); 
		 return transaction; 
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/TestGrab")
	public @ResponseBody Object TestGrab(){
		MyYapi test = new MyYapi("TM");
		String sql = "insert into stocks (STCK_ID, STCK_SYMBL, STCK_PRICE) values (:STCK_ID, :STCK_SYMBL, :STCK_PRICE)";
		@SuppressWarnings("rawtypes")
		Map data = new HashMap();
		data.put("STCK_ID", null);
		data.put("STCK_SYMBL", test.getSymbol());
		data.put("STCK_PRICE", test.getPrice());
		jdbc.update(sql, data);
		return true;
	}
	
	public static void invest(double balance, double price1, double price2, double price3) {
		//amounts invested in each stock
		double invested1 = 0;
		double invested2 = 0;
		double invested3 = 0;
		//number of stocks
		double qty1 = 0;
		double qty2 = 0;
		double qty3 = 0;
		//the user's balance split equally between the three stocks
		double div = 0;
		//what is left over after purchasing as much of one stock as possible 
		double mod = 0;
		//the total of the mod variables from each stock
		double remainder = 0;

		div = balance/3;
		
		//STOCK 1

		mod = div % price1;
		remainder += mod;
		
		invested1 = div - mod;
		qty1 = invested1 / price1;
		
		System.out.println("STOCK 1:");
		System.out.println(invested1);
		System.out.println(qty1);
		
		//STOCK 2
		
		mod = div % price2;
		remainder += mod;
		
		invested2 = div - mod;
		qty2 = invested2 / price2;
		
		System.out.println("STOCK 2:");
		System.out.println(invested2);
		System.out.println(qty2);
		
		//STOCK 3
		
		mod = div % price3;
		remainder += mod;
		
		invested3 = div - mod;
		qty3 = invested3 / price3;
		
		System.out.println("STOCK 3:");
		System.out.println(invested3);
		System.out.println(qty3);
		
		//REMAINDER
		System.out.println("REMAINDER:");
		System.out.println(remainder);
		
		System.out.println(invested1 + invested2 + invested3 + remainder);
	}
	
	public static void main (String[] args) {
		invest(1000, 2.35, 5.60, 7.0);
	}
	
}

package cs3750.stock.app.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cs3750.stock.app.model.Stock;

@Controller
public class ContentController {
	@Autowired
	private NamedParameterJdbcTemplate jdbc;

//    @RequestMapping("/")
//    public String getHomepage(Model m){
//        m.addAttribute("title", "Stock App");
//        m.addAttribute("someList", Arrays.asList("String1", "string2"));
//        return "home";
//    }
	
    @RequestMapping("/login")
    public String getLogin(Model m){
        return "login";
    }
    
	@RequestMapping("/getAllStocks")
	public @ResponseBody Object getAllStocks(){
		Map<String, Object> data = new HashMap<>();
		data.put("STCK_ID", 1);
		data.put("STCK_SYMBL", 2);
		data.put("STCK_PRICE", 3);
		
		List<Stock> stocks = jdbc.query("select * from STOCKS", new BeanPropertyRowMapper(Stock.class) ); 
		return stocks;
	}
	
	@RequestMapping("/getStock/{stockId}")
	public @ResponseBody Object getSomeStock(@PathVariable int stockId){
		Map<String, Object> data = new HashMap<>();
		data.put("STCK_ID", stockId);
		
		List<Stock> stocks = jdbc.query("select * from STOCKS where stck_id = :STCK_ID", data, new BeanPropertyRowMapper(Stock.class) );		
		return stocks.isEmpty() ? null : stocks.get(0);
	}

	@RequestMapping(value="/dummyPost", method=RequestMethod.POST)
	public String postDummyData(@ModelAttribute LoginBean bean, HttpServletRequest request, HttpServletResponse response, HttpSession session){

		return "test";
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
	public @ResponseBody Object insertStocks(String symbol, double price){
		String sql = "insert into stocks (STCK_ID, STCK_SYMBL, STCK_PRICE) values (:STCK_ID, :STCK_SYMBL, :STCK_PRICE)";
		@SuppressWarnings("rawtypes")
		Map data = new HashMap();
		data.put("STCK_ID", null);
		data.put("STCK_SYMBL", symbol);
		data.put("STCK_PRICE", price);
		jdbc.update(sql, data);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/insertUser")
	public @ResponseBody Object insertUser(String firstName, String lastName, double balance){
		String sql = "update stocks (USER_ID, FIRST_NAME, LAST_NAME, BALANCE) values (:USER_ID, :FIRST_NAME, :LAST_NAME, :BALANCE)";
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
	public @ResponseBody Object updateStockPrice(Integer stckId, double price){
		String sql = "update stocks set STCK_PRICE = :STCK_PRICE where STCK_ID = :STCK_ID";
		@SuppressWarnings("rawtypes")
		Map data = new HashMap();
		data.put("STCK_PRICE", price);
		data.put("STCK_ID", stckId);
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

	
	public static class LoginBean{
		private String username, password;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		
	}
	
}

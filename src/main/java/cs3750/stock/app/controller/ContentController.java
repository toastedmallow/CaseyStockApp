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

<<<<<<< HEAD
=======
import cs3750.stock.app.model.Stock;
>>>>>>> 5c5cf311f8a0e0f7788340c1799e88c47e160171

@Controller
public class ContentController {
	@Autowired
	private NamedParameterJdbcTemplate jdbc;

    @RequestMapping("/")
    public String getHomepage(Model m){
        m.addAttribute("title", "Stock App");
        m.addAttribute("someList", Arrays.asList("String1", "string2"));
        return "home";
    }
	
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

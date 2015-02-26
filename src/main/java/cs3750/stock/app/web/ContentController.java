package cs3750.stock.app.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContentController {
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	@RequestMapping("/data")
	public @ResponseBody Object getSomeData(){
		Map<String, Object> data = new HashMap<>();
		data.put("STCK_ID", 1);
		data.put("STCK_SYMBL", 2);
		data.put("STCK_PRICE", 3);
		
		List<Stock> stocks = jdbc.query("select * from STOCKS", data, new BeanPropertyRowMapper(Stock.class) ); 
		return stocks;
	}
	
	@RequestMapping("/person")
	public @ResponseBody Object getSomePerson(){
		return new Person("Tyler", "Evans");
	}
	
	@RequestMapping("/getStock/{stockId}")
	public @ResponseBody Object getSomeStock(@PathVariable String stockId){
		return 45;
	}
	
	public static class Stock {
		private Integer stck_id;
		private String stck_symbl;
		private double stck_price;
		
		public Integer getStck_id() {
			return stck_id;
		}
		public void setStck_id(Integer stck_id) {
			this.stck_id = stck_id;
		}
		public String getStck_symbl() {
			return stck_symbl;
		}
		public void setStck_symbl(String stck_symbl) {
			this.stck_symbl = stck_symbl;
		}
		public double getStck_price() {
			return stck_price;
		}
		public void setStck_price(double stck_price) {
			this.stck_price = stck_price;
		}
	}
	
	
	public static class Person {
		private final String firstName, lastName;

		public Person(String firstName, String lastName) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}
		
	}
}

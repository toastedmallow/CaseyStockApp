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
		data.put("Id", 1);
		
		List<Stock> stocks = jdbc.query("select * from stock", data, new BeanPropertyRowMapper(Stock.class) ); 
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
		private Integer id;
		private String company;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getCompany() {
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
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

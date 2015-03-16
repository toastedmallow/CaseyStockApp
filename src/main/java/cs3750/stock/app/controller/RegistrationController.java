package cs3750.stock.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs3750.stock.app.model.RegisterUser;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {
		RegisterUser registerUser = new RegisterUser();
		model.put("registerForm", registerUser);
		return "registration";
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("registerForm")
									RegisterUser user, Map<String, Object> model ) {
		
		String sql = "insert into users (USER_ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, BALANCE) values (:USER_ID, :USERNAME, :PASSWORD, :FIRST_NAME, :LAST_NAME, :BALANCE)";
		Map data = new HashMap();
		data.put("USER_ID", null);
		data.put("USERNAME", user.getUsername());
		data.put("PASSWORD", user.getPassword());
		data.put("FIRST_NAME", user.getFirstName());
		data.put("LAST_NAME", user.getLastName());
		data.put("BALANCE", 0);
		jdbc.update(sql, data);
		
		return "login";
	}
}

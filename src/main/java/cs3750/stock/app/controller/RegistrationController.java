package cs3750.stock.app.controller;

import java.util.Map;

import cs3750.stock.app.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {
		User registerForm = new User();
		model.put("registerForm", registerForm);
		return "registration";
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("registerForm")
									User user, Map<String, Object> model ) {
		// registration logic
		
		// Pretty much connect to the DB, Query the database for the username if it exists NO GO.
		// If it doesn't we're GUCCI.
		
		// test registration
		System.out.println("User_Id: " + user.getUser_id());
		//System.out.println("Username: " + user.getUsername());
		System.out.println("First Name: " + user.getFirst_name());
		System.out.println("Last Name: " + user.getLast_name());
		
		return "RegistrationSuccess";
		
	}
}

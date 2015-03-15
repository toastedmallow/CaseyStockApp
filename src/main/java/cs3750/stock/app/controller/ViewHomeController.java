package cs3750.stock.app.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs3750.stock.app.model.User;


@Controller
@RequestMapping("/")
public class ViewHomeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ViewHomeController.class);
	
	// Mapping for index pages
	@RequestMapping(method = RequestMethod.GET)
	public String getHomePageLoginView(Map<String, Object> model) {
		LOGGER.debug("Tried to request default page view with Login Form");
		User loginForm = new User();
		model.put("loginForm", loginForm);
		return "login";
	}
}



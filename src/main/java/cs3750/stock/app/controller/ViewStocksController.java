package cs3750.stock.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs3750.stock.app.model.MainModel;
import cs3750.stock.app.model.User;

@Controller
public class ViewStocksController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ViewStocksController.class);
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	  
	@RequestMapping(value="/viewstocks", method = RequestMethod.GET)
    public User printWelcome(HttpServletRequest request) {
    	LOGGER.debug("A Request was made for the View Stocks Prices Page");
    	
    	User user = MainModel.getUser();
    	String result = "First: " + user.getFirstName() + ", Last: " + user.getLastName() + ", Username: " + user.getUsername() + ", User ID: " + user.getUserId();
    	System.out.println(result);
    	
        return user;
   
    }
}

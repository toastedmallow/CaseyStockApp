package cs3750.stock.app.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs3750.stock.app.model.User;

@Controller
public class ViewStocksController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ViewStocksController.class);
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	  
	@RequestMapping(value="/viewstocks", method = RequestMethod.GET)
    public String printWelcome(ModelMap model, Principal principal ) {
    	LOGGER.debug("A Request was made for the View Stocks Prices Page");
        return "viewstocks";
   
    }
}

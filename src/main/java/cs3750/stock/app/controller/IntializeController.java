package cs3750.stock.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs3750.stock.app.model.Intializer;
import cs3750.stock.app.model.MainModel;

@Controller
@RequestMapping(value = "/intialize")
public class IntializeController {
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewSetup(Map<String, Object> model) {
		Intializer intializer = new Intializer();
		model.put("intializeForm", intializer);
		return "intialize";
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processSetup(@ModelAttribute("intializeForm") Intializer intializer) {
		
		//System.out.println(intializer.getSymbol1() + " " + intializer.getSymbol2() + " " + intializer.getSymbol3());
		String[] array = {intializer.getSymbol1(), intializer.getSymbol2(), intializer.getSymbol3()};
		MainModel.setStockArray(array);
		MainModel.getUser().setBalance(intializer.getBalance());
		new ContentController().invest(intializer.getBalance(), array, jdbc);
		
		return "viewstocks";
		
	}
}

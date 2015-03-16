package cs3750.stock.app.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs3750.stock.app.model.Intializer;

@Controller
@RequestMapping(value = "/intialize")
public class IntializeController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewSetup(Map<String, Object> model) {
		Intializer intializer = new Intializer();
		model.put("intializeForm", intializer);
		return "intialize";
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processSetup(@ModelAttribute("intializeForm") Intializer intializer) {
		
		//System.out.println(intializer.getSymbol1() + " " + intializer.getSymbol2() + " " + intializer.getSymbol3());
		
		return "viewstocks";
		
	}
}

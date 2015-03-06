package cs3750.stock.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewContactUsController {
	
	@RequestMapping("/Contact")
	public String viewContactUsPage() {
		return "contactus";
	}
}

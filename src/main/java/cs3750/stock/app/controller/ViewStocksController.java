package cs3750.stock.app.controller;

import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewStocksController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ViewStocksController.class);
	
	//mapping for view stocks pages
	@RequestMapping("/viewstocks")
	public String getViewStockPricesPage() {
		LOGGER.debug("A Request was made for the View Stocks Prices Page");
		return "viewstocks";
	}
	
	
	
	
}

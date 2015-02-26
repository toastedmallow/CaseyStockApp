package cs3750.stock.app.controller;

import java.util.HashMap;

import cs3750.stock.app.model.Stock;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;

import de.hdtconsulting.yahoo.finance.Yapi;
import de.hdtconsulting.yahoo.finance.core.YQuote;
import de.hdtconsulting.yahoo.finance.core.YSymbol;
import de.hdtconsulting.yahoo.finance.server.csv.connection.YConnectionManager;
import de.hdtconsulting.yahoo.finance.server.csv.connection.YHost;
import de.hdtconsulting.yahoo.finance.server.csv.format.YFormat;
import de.hdtconsulting.yahoo.finance.server.csv.format.YTag;

@Controller
public class ContentController {
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	private Yapi yapi;
	
	@RequestMapping("/getAllStocks")
	public @ResponseBody Object getAllStocks(){
		Map<String, Object> data = new HashMap<>();
		data.put("STCK_ID", 1);
		data.put("STCK_SYMBL", 2);
		data.put("STCK_PRICE", 3);
		
		List<Stock> stocks = jdbc.query("select * from STOCKS", data, new BeanPropertyRowMapper(Stock.class) ); 
		return stocks;
	}
	
	@RequestMapping("/getStock/{stockId}")
	public @ResponseBody Object getSomeStock(@PathVariable String stockId){
		Map<String, Object> data = new HashMap<>();
		data.put("STCK_ID", 1);
		data.put("STCK_SYMBL", 2);
		data.put("STCK_PRICE", 3);
		
		Stock stock = (Stock) jdbc.query("select * from STOCKS where stck_id = "+stockId, data, new BeanPropertyRowMapper(Stock.class) ); 
		return stock;
	}
	
	private void initYapi() {
		YHost proxy = new YHost("localhost", 6588);
		
		YConnectionManager connectionManager = new YConnectionManager();
		connectionManager.setMaxConnections(5);
		yapi.setConnectionManager(connectionManager);
		
		connectionManager.setProxy(proxy);
		
		YFormat format = new YFormat();
		format.setStatusOn(YTag.BID);
		format.setStatusOn(YTag.BID_REAL_TIME);
		format.setStatusOn(YTag.NAME);
		yapi.setFormat(format);
	}
	
	public void addYapiSymbol(String str) {
		YSymbol sym = new YSymbol(str);
		yapi.addQuote(sym);
	}
	
	public void refreshYapi() {
		try {
			yapi.refreshRealTime();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERROR 1 IN refresh()");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERROR 2 IN refresh()");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERROR 3 IN refresh()");
		}
	}
	
	public void getYapiData() {
		//System.out.println(yapi.getCsv());
		
		//System.out.println(yapi.getCsv());
		//System.out.println(yapi.getRefreshTime());

		//System.out.println("------------------------------");
		
		//yapi.refresh();
		
		//System.out.println("------------------------------");
		//System.out.println();
		//System.out.println(yapi.getCsv());
		//System.out.println(yapi.getRefreshTime());
		
		yapi.refresh();
		System.out.println(yapi.getCsv());
	}
	
}

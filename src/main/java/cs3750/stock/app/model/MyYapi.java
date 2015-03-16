package cs3750.stock.app.model;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import au.com.bytecode.opencsv.CSVReader;
import de.hdtconsulting.yahoo.finance.Yapi;
import de.hdtconsulting.yahoo.finance.core.YSymbol;
import de.hdtconsulting.yahoo.finance.server.csv.connection.YConnectionManager;
import de.hdtconsulting.yahoo.finance.server.csv.connection.YHost;
import de.hdtconsulting.yahoo.finance.server.csv.format.YFormat;
import de.hdtconsulting.yahoo.finance.server.csv.format.YTag;

public class MyYapi {
	private Yapi yapi;
	private String symbol;
	private double price;
	private String name;
	private File csv;
	
	
	public MyYapi() {
		yapi = new Yapi();
		this.init();
	}
	
	public MyYapi(String sym) {
		yapi = new Yapi();
		this.init();
		this.addSymbol(sym);
		this.update();
	}
	
	private void init() {
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
	
	private void refresh() {
		try {
			yapi.refreshRealTime();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("ERROR 1 IN refresh()");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERROR 2 IN refresh()");
		} catch (URISyntaxException e) {
			e.printStackTrace();
			System.out.println("ERROR 3 IN refresh()");
		}
	}
	
	private void addSymbol(String str) {
		this.symbol = str;
		YSymbol sym = new YSymbol(str);
		yapi.addQuote(sym);
	}
	
	
	public void printData() {
		this.refresh();
		System.out.println(yapi.getCsv());
	}
	
	public void update() {
		this.refresh();
		try {
			csv = File.createTempFile("stockapp" + this.symbol, "csv");
			FileWriter csvWriter = new FileWriter(csv);
			csvWriter.write(yapi.getCsv());
			csvWriter.close();
			csv.deleteOnExit();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			CSVReader csvReader = new CSVReader(new FileReader(csv));
			String[] nextLine;
			while((nextLine = csvReader.readNext()) != null) {
				this.name = nextLine[3];
				try {
					this.price = Double.parseDouble(nextLine[1]);
				} catch(NumberFormatException e) {
					System.out.println("hello");
				}
			}
			csvReader.close();
		} catch (IOException e) {
			System.out.println("error in ParseData()");
			e.printStackTrace();
		}
	}
	
	public void setSymbol(String sym) {
		yapi.removeAllQuotes();
		this.addSymbol(sym);
		this.update();
	}
	
	public String getSymbol() {
		return this.symbol;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	
	public static void main(String args[]) {
		MyYapi test = new MyYapi("AAPL");
		System.out.println(test.getSymbol());
		System.out.println(test.getPrice());
		System.out.println(test.getName());
		//test.setSymbol("APPL");
		//System.out.println(test.getSymbol());
		//System.out.println(test.getPrice());
		//System.out.println(test.getName());
	}
}

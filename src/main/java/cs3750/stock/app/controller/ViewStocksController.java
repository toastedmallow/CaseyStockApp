package cs3750.stock.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

import com.googlecode.charts4j.AxisLabels;
import com.googlecode.charts4j.AxisLabelsFactory;
import com.googlecode.charts4j.AxisStyle;
import com.googlecode.charts4j.AxisTextAlignment;
import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.Data;
import com.googlecode.charts4j.Fills;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.LinearGradientFill;
import com.googlecode.charts4j.PieChart;
import com.googlecode.charts4j.Plots;
import com.googlecode.charts4j.Slice;
import com.googlecode.charts4j.BarChart;
import com.googlecode.charts4j.BarChartPlot;

import cs3750.stock.app.model.MainModel;
import cs3750.stock.app.model.User;

@Controller
public class ViewStocksController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ViewStocksController.class);
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	  
	@RequestMapping(value="/viewstocks", method = RequestMethod.GET)
    public String printWelcome(HttpServletRequest request) {
    	LOGGER.debug("A Request was made for the View Stocks Prices Page");
    	
    	User user = MainModel.getUser();
    	String result = "First: " + user.getFirstName() + ", Last: " + user.getLastName() + ", Username: " + user.getUsername() + ", User ID: " + user.getUserId();
    	System.out.println(result);
    	
        return "viewstocks";
   
    }
	
	@RequestMapping(value = "/barchart", method = RequestMethod.GET)
	public String drawBarChart(ModelMap model) {
		
		// define the data plots
		BarChartPlot stock1 = Plots.newBarChartPlot(Data.newData(1), Color.GREEN, "GOOG");
		BarChartPlot stock2 = Plots.newBarChartPlot(Data.newData(4), Color.SLATEGRAY, "AAPL");
		BarChartPlot stock3 = Plots.newBarChartPlot(Data.newData(3), Color.BLUE, "MSFT");
		BarChartPlot leftover = Plots.newBarChartPlot(Data.newData(00.23), Color.RED, "Left Over Amount");
		
		// init the bar chart
		BarChart barChart = GCharts.newBarChart(stock1, stock2, stock3, leftover);
		
		// Define Axis and other stuffs
		AxisStyle axisStyle = AxisStyle.newAxisStyle(Color.BLACK, 13, AxisTextAlignment.CENTER);
		AxisLabels amount = AxisLabelsFactory.newAxisLabels("Amount of Shares", 50.0);
		amount.setAxisStyle(axisStyle);
		AxisLabels ticker = AxisLabelsFactory.newAxisLabels("Ticker Symbol", 50.0);
		ticker.setAxisStyle(axisStyle);
		
		//adding axis info to chart
		//barChart.addYAxisLabels(AxisLabelsFactory.newAxisLabels("GOOG", "AAPL", "MSFT", "Left Over"));
		barChart.addXAxisLabels(AxisLabelsFactory.newNumericRangeAxisLabels(0,20));
		barChart.addXAxisLabels(amount);
		barChart.addYAxisLabels(ticker);
		
		barChart.setSize(720,360);
		barChart.setBarWidth(BarChart.AUTO_RESIZE);
		//barChart.setSpaceBetweenGroupsOfBars(5);
		barChart.setHorizontal(true);
		barChart.setTitle("Stock Bar Chart", Color.BLACK, 15);
		barChart.setBackgroundFill(Fills.newSolidFill(Color.ALICEBLUE));
		LinearGradientFill fill = Fills.newLinearGradientFill(0, Color.LAVENDER, 100);
		fill.addColorAndOffset(Color.WHITE, 0);
		barChart.setAreaFill(fill);
		
		model.addAttribute("barUrl", barChart.toURLString());
		
		return "barchart";
	}
	
	@RequestMapping(value = "/piechart", method= RequestMethod.GET)
	public String drawPieChart(ModelMap model) {
		
		/**
		 * Param1 is the Percentage of Stocks
		 * Param2 is the Amount of Shares or Amount of Money Invested
		 * Param3 is the Ticker Symbol of the Stock
		 */
		// separate chart slices for the graphs
		Slice stock1 = Slice.newSlice(15, Color.newColor("CACACA"), "710.11", "GOOG");
		Slice stock2 = Slice.newSlice(50, Color.newColor("DF7417"), "300.24", "AAPL");
		Slice stock3 = Slice.newSlice(25, Color.newColor("951800"), "642.22", "MSFT");
		Slice remainder = Slice.newSlice(10, Color.newColor("01A1DB"), "00.23", "Left Over");
		
		// chart init
		PieChart pieChart = GCharts.newPieChart(stock1, stock2, stock3, remainder);
		pieChart.setTitle("Stock Pie Chart", Color.BLACK, 15);
		pieChart.setSize(720, 360);
		pieChart.setThreeD(true);
		
		model.addAttribute("pieUrl", pieChart.toURLString());
		
		return "piechart";
	}
}

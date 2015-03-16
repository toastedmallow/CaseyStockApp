<!-- Include Header File -->
<%@ include file="header.jsp" %>

	<p align="center">View Stocks Mapping Test</p>
	
	<div align="center" id="my_chart" style="width: 400px; height:400px">
	
	</div>
	
	<!-- Script function to show charts -->
	<script type="text/javascript" src="Chart.js-master/Chart.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.2/Chart.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.2/Chart.min.js"></script>
	
	<script type="text/javascript">
		var myNewChart = new Chart(ctx);

		google.load("visualization", "1", {packages:
			["corechart"]};

		
		function showStockView(str) 
		{
			if (str == "")
			{
			
			}
			// determine the value of select object to draw a specific object
			else if (str == "table")
			{
				// make a database request call to get the stocks for the user
				// draw a table
				drawTable();
			}

			else if (str =="bar")
			{
				// make a database request call for the information for a user
				google.setOnLoadCallback(drawBarChart);
				drawBarChart();
				
			}
			else if (str=="pie")
			{
				// draw pie chart
				google.setOnLoadCallback(drawPieChart);
				drawPieChart();
			}
			else if (str=="all")
			{
				// draw all of them
				drawAllCharts();
			}

		}

		// function to draw the table
		function drawTable() 
		{
			window.alert("Draw Table Working");
		}

		// function to draw the bar chart
		function drawBarChart()
		{
			
			// hard coded datastructure
			// Only show how much money is invested in each Ticker symbol.
//			var chartData = {
//					labels: ["GOOG", "AAPL", "MSFT"],
//					datasets: [
//						{
//							fillColor: "rgba(151,187,205,0.5)",
//							strokeColor: "rgba(151,187,205,0.8)",
//							highlightFill: "rgba(151,187,205,0.75)",
//							highlightStroke: "rgba(151,187,205,1)",
//							data: [550.38, 150.11, 48.99]
	//					}
		//			]
					
		//	}
		//	window.onload = function() {
				//var ctx = $("#myChart").get(0).getContext("2d");
		//		var ctx = document.getElementById("myChart").getContext("2d");
		//		window.myBar = new Chart(ctx).Bar(chartData, {
		//				responsive : true
		//			});
		//		window.alert("Draw Bar Charts tab Working");
		//	};


			// GOOGLE API DRAW CHART

			var data = google.visualization.arrayToDataTable([
				['Stock Symbol', 'Amount Invested'],
				['GOOG', 550.38],
				['AAPL', 150.11],
				['MSFT', 48.99]
			]);

			var options = {
					title: 'Bar Chart of Invested Funds'
			};

			// Create and draw the graph
			new google.visualization.BarChart(
					document.getElementById('my_chart')).draw(data, options);
		}

		// function to draw the pie chart
		function drawPieChart()
		{
			window.alert("Draw pie charts tab working");
		}

		// function to draw all the charts
		function drawAllCharts()
		{
			window.alert("Draw all charts tab working");
		}
	</script>
	
	<!-- Drop Down menu for charts  -->
	<form align="center" action=""> <!--  Remove this if we don't want to use AJAX -->
	<select name="chartTypes" onchange="showStockView(this.value)">
		<option value="">Pick a stock view...</option>
		<option value="table">Table View</option>
		<option value="bar">Bar Chart View</option>
		<option value="pie">Pie Chart View</option>
		<option value="all">View All Charts</option>
	</select>
	</form> <!--  remove if we don't want AJAX -->
<!-- Include footer file -->
<%@include file="footer.jsp" %>
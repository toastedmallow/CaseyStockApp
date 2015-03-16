<!-- Include Header File -->
<%@ page import="java.awt.*" %>
<%@ page import="java.io.*" %>
<%@ include file="header.jsp" %>

	<div align="left">
		<form:form action="/viewstocks" method="get" commandName="printWelcome">
			
			<table height="200px" width="300px" border="0">
				<tr>
					<td align="center"><h2 style="color:white; font-size:16pt">Stock Symbol</h2></td>
					<td align="center"><h2 style="color:white; font-size:16pt">Price</h2></td>
					<td align="center"><h2 style="color:white; font-size:16pt">Quantity</h2></td>
					<td align="center"><h2 style="color:white; font-size:16pt">Amount Invested</h2></td>
				</tr>
					<!-- Password implementation possibly? -->
				<tr>
					<td style="color:white; font-size:14pt"><%= request.getParameter("firstName") %></td>
					<td style="color:white; font-size:14pt">114.22</td>
					<td style="color:white; font-size:14pt">4</td>
					<td style="color:white; font-size:14pt">502.24</td>
				</tr>
				<tr>
					<td style="color:white; font-size:14pt">AAPL</td>
					<td style="color:white; font-size:14pt">444.22</td>
					<td style="color:white; font-size:14pt">2</td>
					<td style="color:white; font-size:14pt">1748.00</td>
				</tr>
				<tr>
					<td style="color:white; font-size:14pt">TM</td>
					<td style="color:white; font-size:14pt">54.22</td>
					<td style="color:white; font-size:14pt">25</td>
					<td style="color:white; font-size:14pt">502.24</td>
				</tr>
			</table>

		</form:form>
	</div>
	

<!-- Include footer file -->
<%@include file="footer.jsp" %>
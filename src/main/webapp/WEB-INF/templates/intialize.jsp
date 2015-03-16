<%@ include file = "header.jsp" %>

<br></br>
<p style="font-size:24pt" align="center">Set-up</p>
<br></br>

<!--  Create User account form -->

	<div align="center">
		<form:form action="/intialize" method="post" commandName="intializeForm">
			<table width="25%" height="35%" border="0">
				<tr>
					<td colspan="2" align="center"><h2 style="color:white; font-size:16pt">Buy Stocks</h2></td>
				</tr>
				<tr>
					<td style="color:white; font-size:14pt" width="25%">Symbol 1:</td>
					<td><form:input path="symbol1" /></td>
				</tr>
				<tr>
					<td style="color:white; font-size:14pt" width="25%">Symbol 2:</td>
					<td><form:input path="symbol2" /></td>
				</tr>
				<tr>
					<td style="color:white; font-size:14pt" width="25%">Symbol 3:</td>
					<td><form:input path="symbol3" /></td>
				</tr>
				<tr>
					<td style="color:white; font-size:14pt" width="25%">Balance:</td>
					<td><form:input path="balance" type="number" step="0.01"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Register" /></td>
				</tr>
			</table>
		</form:form>
	</div>
	<br></br>

<%@include file = "footer.jsp" %>

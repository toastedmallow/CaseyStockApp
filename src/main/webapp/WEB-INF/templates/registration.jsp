<%@ include file = "header.jsp" %>

<br></br>
<p style="font-size:24pt" align="center">New User Registration </p>
<br></br>

<!--  Create User account form -->

	<div align="center">
		<form:form action="register" method="post" commandName="registerForm">
			<table width="25%" height="35%" border="0">
				<tr>
					<td colspan="2" align="center"><h2 style="color:white; font-size:16pt">User Registration Form</h2></td>
				</tr>
					<!-- Password implementation possibly? -->
				<tr>
					<td style="color:white; font-size:14pt" width="25%">First Name:</td>
					<td><form:input path="first_name" /></td>
				</tr>
				<tr>
					<td style="color:white; font-size:14pt" width="25%">Last Name:</td>
					<td><form:input path="last_name" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Register" /></td>
				</tr>
			</table>
		</form:form>
	</div>
	<br></br>
	<p align="center">If you have already registered, please click the link below to login</p>
	<br></br>
	<p align="center"><a href="/">Login Page</a></p>

<%@include file = "footer.jsp" %>

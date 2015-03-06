<!-- Include Header File -->
<%@ include file="header.jsp" %>

<!-- Default Home Page Content -->
	<p style="font-size:28pt;" align="center">A Spring MVC Maven Stock Application</p>
	
	<br></br>
	<br></br>
	
	<p style="font-size:14pt;" align="center">Login if already a User</p>
	
	<!--  Create User account form -->

<html>
<body>
<form action="/doLogin" method="post">
<div id="wrapper" style="text-align: center">    
    <div id="yourdiv" style="display: inline-block;">
		<h2>Username</h2>
		<input name="username">
		<h2>Password</h2>
		<input name="password" type="password">
		<br/>
		<br/>
		<button type="submit">Submit</button>
	</div>
</div>
</form>
</body>
</html>

<!-- Include footer file -->
<%@include file="footer.jsp" %>
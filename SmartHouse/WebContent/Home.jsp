<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SHAS Home</title>
<style>
@import url(http://fonts.googleapis.com/css?family=Exo:100,200,400);

@import
	url(http://fonts.googleapis.com/css?family=Source+Sans+Pro:700,400,300)
	;

body {
	margin: 0;
	padding: 0;
	background: #fff;
	color: #fff;
	font-family: Arial;
	font-size: 12px;
}

.body {
	position: absolute;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	background-image: url(theater.jpg);
	background-size: cover;
	-webkit-filter: blur(5px);
	z-index: -1;
}
.grad{
	position: absolute;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.65))); /* Chrome,Safari4+ */
	z-index: 1;
	opacity: 0.7;
}

</style>
</head>
<body>
	<br />
	<br />
	<br />
	<br />
	<br />
	
	<center>
	<div class="body"></div>
	<div class="grad"></div>
		<h1>Welcome to SHAS</h1>
		<h2>
			<%
				String a = session.getAttribute("username").toString();
				out.println("Hello " + a);
			%>
		</h2>
		<a href="Testbed.jsp">Go to Testbed</a>
		<br /> 
		<a href="Logout.jsp">Logout</a><br />
		
	</center>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SHAS Home</title>
<link rel="stylesheet"
	href="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/themes/smoothness/jquery-ui.css" />
<script
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>
<style>
@import url(http://fonts.googleapis.com/css?family=Exo:100,200,400);

@import
	url(http://fonts.googleapis.com/css?family=Source+Sans+Pro:700,400,300)	;

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

.grad {
	position: absolute;
	top: 100px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, rgba(0, 0
		, 0, 0)), color-stop(100%, rgba(0, 0, 0, 0.65)));
	/* Chrome,Safari4+ */
	z-index: 1;
	opacity: 0.9;
	
}

.content {
	background-color: rgba(255, 255, 255, 0.5);
	width: 60%;
	
}

.text {
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 35px;
	font-weight: 200;
	
}

a {
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 20px;
	font-weight: 200;
}
</style>
</head>
<body>
<center>
	<div class="body">
		<div class="grad">
			<div class="content ui-corner-all">
				<a href="Logout.jsp" style="float: right; right: 30 px;">Logout</a><br />
				<div class="text">
					Welcome to SHAS
					<div>
						<a href="Testbed.jsp" style="float: left; left: 20px;">Go to
							Testbed</a> <br />
					</div>
				</div>
			</div>
		</div>
	</div>
</center>

</body>
</html>
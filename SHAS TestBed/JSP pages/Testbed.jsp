<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter Testbed values</title>
</head>
<body>
<H1>Adjust your values here....</H1>
<table>
<tr>
<th>Security Breached:</th>
<th><select name="securitybreached" id="securitybreached" onchange="onSecurityBreached();">
<option>Yes</option>
<option>No</option>
</select></th>
</tr>
</table>
</body>
<script type="text/javascript">
function onSecurityBreached(){
	alert("Security has been breached!!!")
}
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
  <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
  <script>
$(function() {
    $( ".datepicker" ).datepicker();
});
</script>
 <title>Test Bed</title>
</head>
<body>
<form name="Simulation" action="DateCheck.jsp" method="post">
<H1>Enter Simulation Dates:</H1>
Start Date: <input type="text" name="startdate" class="datepicker" />
End Date: <input type="text" name="enddate" class="datepicker" />
<input type="submit" id="submit" value="Submit">
</form>
</body>
  </html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert student</title>
</head>
<body>
<h3>Insert Student details below</h3>
	<form name="studentinformation" action="<%=request.getContextPath()%>/student/insertdata" method="POST">
	
	 <label for="fname">First name:</label><br>
     <input type="text" name="firstname"><br>
     
     <label for="lname">Last name:</label><br>
     <input type="text" name="lastname"> <br>
     
     <label for="phno">Phone Number:</label><br>
     <input type="text" name="phoneno"><br>
     
     <input type="submit" value="Submit">
     
	</form>

</body>
</html>
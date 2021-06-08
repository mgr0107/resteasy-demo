<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update student</title>
</head>
<body>
<h3>Update student information</h3>
  <form name="studentinformation" action="<%=request.getContextPath()%>/student/updatedata" method="POST">
	 <label for="id">ID:</label><br>
     <input type="number" name="id"><br>
	 <label for="fname">First name:</label><br>
     <input type="text" name="firstname"><br>
     <label for="lname">Last name:</label><br>
     <input type="text" name="lastname"> <br>
     <label for="phoneno">Phone no:</label><br>
     <input type="text" name="phoneno">
     <input type="submit" value="Submit">
	</form>

</body>
</html>
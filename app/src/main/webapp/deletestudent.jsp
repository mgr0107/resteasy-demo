<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete student</title>
</head>
<body>
<h3>Delete Student Information</h3>
<form name="deleteinformation" action="<%=request.getContextPath()%>/student//deletedata/{usn}" method="POST">
	 <label for="usn">USN:</label><br>
     <input type="text" name="usn"><br>
     <input type="submit" value="Submit">
</form>

</body>
</html>
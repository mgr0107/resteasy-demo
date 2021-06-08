<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Get Student By ID</h3>
<form name="getinformation" action="<%=request.getContextPath()%>/student/getStudentById" method="GET">
	 <label for="id">ID:</label><br>
     <input type="number" name="id"><br>
     <input type="submit" value="Submit">
</form>

</body>
</html>
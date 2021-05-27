<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.axelor.student.db.Student"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All students</title>
</head>
<body>
<h3> Viewing all students</h3>
<table>
  <tr>
   <th>USN</th>
   <th>First name</th>
   <th>Last Name</th>
  </tr>
  <% 
							if(request.getAttribute("StudInfo")!=null) {
								List<Student> student= (ArrayList<Student>)request.getAttribute("StudInfo");
								for(Student s : student) {
									
									out.print("<tr>");
									
									out.print("<td>");
									out.print(s.getUsn());
									out.print("</td>");
								
									out.print("<td>");
									out.print(s.getFirstName());
									out.print("</td>");
									
									out.print("<td>");
									out.print(s.getLastName());
									out.print("</td>");
									
									out.print("</tr>");
								}
									student = null;
							}
   %>


</table>

</body>
</html>
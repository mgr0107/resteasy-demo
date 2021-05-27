package com.axelor.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;


import com.axelor.student.db.Student;
import com.google.inject.Inject;

@Path("student")
public class StudentResource {
	
	@Inject
	StudentService StudentService;
	
	@POST
	@Path("/insertdata")
	public void Insert(@Context HttpServletRequest request,@Context HttpServletResponse response) throws IOException, ServletException {
		Student student = new Student(request.getParameter("usn"),request.getParameter("firstname"),request.getParameter("lastname"));
		StudentService.Insert(student);
		response.sendRedirect("showdata");
	}
	
	/*@GET             
	@Path("/getData/{usn}")
	public void getData(@PathParam("usn") String usn, @Context HttpServletRequest request, @Context HttpServletResponse response)  throws IOException, ServletException {
		 
		request.setAttribute("usn", StudentService.getData(usn).get(0).getUsn());
		request.setAttribute("firstname", StudentService.getData(usn).get(0).getFirstName());
		request.setAttribute("lastname", StudentService.getData(usn).get(0).getLastName());
		request.getRequestDispatcher("../../updateStudent.jsp").forward(request, response);
	}*/
	
	@POST
	@Path("/deletedata/{usn}")
	public void Delete(@PathParam("usn") String usn, @Context HttpServletRequest request,@Context HttpServletResponse response) throws IOException, ServletException {
		try {
			StudentService.Delete(usn);
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			response.sendRedirect("showdata");
		}
	}
	
	
	
	@GET
	@Path("/updatedata/{usn}")
	public void Update(@PathParam("usn") Integer usn, @Context HttpServletRequest request, @Context HttpServletResponse response) throws IOException, ServletException { 
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		StudentService.Update("usn",firstname,lastname);
		response.sendRedirect("../showdata");
	}
	
	@GET
	@Path("/showdata")
	public void Show(@Context HttpServletRequest request,@Context HttpServletResponse response) throws IOException, ServletException {
		
		request.setAttribute("allContacts", StudentService.Show());
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}
}

package com.axelor.app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import com.axelor.student.db.Phone;
import com.axelor.student.db.Student;
import com.google.inject.Inject;

@Path("student")
public class StudentResource {

	@Inject
	StudentService StudentService;

	@POST
	@Path("/insertdata")
	public void insert(@Context HttpServletRequest request, @Context HttpServletResponse response)
			throws IOException, ServletException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String phno = request.getParameter("phoneno");
		Phone ph = new Phone(phno);
		Student student = new Student(firstname, lastname, ph);
		student.setPh(ph);
		StudentService.insert(student);
		response.sendRedirect(request.getContextPath() + "/student/showdata");
	}

	@POST
	@Path("/updatedata")
	public void Update(@Context HttpServletRequest request, @Context HttpServletResponse response)
			throws IOException, ServletException {
		String usn = request.getParameter("usn");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		Student st = new Student(firstname, lastname, null);
		StudentService.update(st);
		response.sendRedirect(request.getContextPath() + "/student/showdata");
	}

	@POST
	@Path("/deletedata")
	public void delete(@Context HttpServletRequest request, @Context HttpServletResponse response)
			throws IOException, ServletException {
		try {
			String id = request.getParameter("id");
			StudentService.deleteById(Integer.parseInt(id));
			response.sendRedirect(request.getContextPath() + "/student/showdata");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GET
	@Path("/getStudentById")
	public void getStudentById(@Context HttpServletRequest request, @Context HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("debug");
		String usn = request.getParameter("usn");
		ArrayList<String> stud = StudentService.getStudentById(usn);
		/*
		 * request.setAttribute("usn",
		 * StudentService.getStudentById(usn).get(0).getUsn());
		 * request.setAttribute("firstname",
		 * StudentService.getStudentById(usn).get(0).getFirstName());
		 * request.setAttribute("lastname",
		 * StudentService.getStudentById(usn).get(0).getLastName());
		 * request.setAttribute("phoneno",
		 * StudentService.getStudentById(usn).get(0).getPhoneno());
		 */
		System.out.println("debug2");
		// System.out.println;
		// response.sendRedirect(request.getContextPath() + "/student/showdata");
	}

	@GET
	@Path("/showdata")
	public void Show(@Context HttpServletRequest request, @Context HttpServletResponse response)
			throws IOException, ServletException {

		request.setAttribute("StudInfo", StudentService.show());
		request.getRequestDispatcher("/viewStudents.jsp").forward(request, response);

	}
}

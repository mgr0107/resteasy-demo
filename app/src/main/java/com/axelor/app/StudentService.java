package com.axelor.app;

import java.io.IOException;
import java.util.ArrayList;

import com.axelor.student.db.Student;

public interface StudentService {
	
	public void Insert(Student c) throws IOException;
	
	public void Update(String usn, String firstName, String lastName) throws IOException;
	
	public void Delete(String usn) throws IOException;
	
	 public ArrayList<Student> Show();
	
}

package com.axelor.app;

import java.io.IOException;
import java.util.ArrayList;

import com.axelor.student.db.Student;

public interface StudentService {

	public void insert(Student c) throws IOException;

	public ArrayList<String> getStudentById(String usn);

	public void update(Student s) throws IOException;

	public ArrayList<Student> show();

	void deleteById(Integer id) throws IOException;

}

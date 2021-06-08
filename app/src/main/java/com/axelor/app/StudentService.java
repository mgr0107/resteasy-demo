package com.axelor.app;

import java.io.IOException;
import java.util.ArrayList;

import com.axelor.student.db.Student;

public interface StudentService {

	public void insert(Student c) throws IOException;

	public ArrayList<Student> getStudentById(String usn);

	public void update(Integer id, Student s) throws IOException;

	public ArrayList<Student> show();

	void deleteById(Integer id) throws IOException;

}

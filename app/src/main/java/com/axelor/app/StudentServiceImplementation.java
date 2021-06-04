package com.axelor.app;

import javax.persistence.EntityManager;

import java.io.*;
import java.util.*;

import com.axelor.student.db.Student;
import com.google.inject.*;
import com.google.inject.persist.Transactional;

@Singleton
public class StudentServiceImplementation implements StudentService{
	
	@Inject
	private Provider<EntityManager> emp;
	
	
	@Override
	@Transactional(rollbackOn =IOException.class)
	public void insert(Student student) throws IOException {
		EntityManager em = emp.get(); //creating instance of EntityManager
		em.persist(student);
	}
	
	@Override
	@Transactional(rollbackOn = IOException.class)
	public void update(Student s) {
		EntityManager em = emp.get();
		Student student = em.find(Student.class, s.getUsn());
		student.setFirstName(s.getFirstName());
		student.setLastName(s.getLastName());
		student.setPhoneno(s.getPhoneno());
	}
	
	@Override
	@Transactional(rollbackOn = IOException.class)
	public void deleteById(String usn) throws IOException {
		EntityManager em = emp.get();		
		Student student = em.find(Student.class, usn);
		em.remove(student);
	}
	
	@Override
	@Transactional(rollbackOn =IOException.class)
    public ArrayList<Student> getStudentById(String usn){
		EntityManager em = emp.get();
		ArrayList<Student> stud = new ArrayList<>();
		Student s = em.find(Student.class, usn);
		stud.add(s);
		return stud;
	}

	
	

	@Override
	@Transactional(rollbackOn = IOException.class)
	public ArrayList<Student> show() {
		EntityManager em = emp.get();
		
		return (ArrayList<Student>)em.createQuery("select student from Student student",Student.class).getResultList();
	}
}

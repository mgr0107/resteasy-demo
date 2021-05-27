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
	
	EntityManager em = emp.get();
	
	@Override
	@Transactional(rollbackOn =IOException.class)
	public void Insert(Student student) throws IOException {
		em.persist(student);
	}
	
	@Override
	@Transactional(rollbackOn = IOException.class)
	public ArrayList<Student> getData (String usn) {
	
		ArrayList<Student> stud = new ArrayList<>();
		try {
			stud = (ArrayList<Student>)em.createQuery("select s from Student s where s.usn = :usn",Student.class).setParameter("usn", usn).getResultList();
		}catch (Exception e) {}
		return stud;
	}
	
	@Override
	@Transactional(rollbackOn = IOException.class)
	public void Update(String usn, String firstname, String lastname) {
		
		try {
			em.createQuery("update Student set firstName = :firstname, lastName = :lastname where usn = :usn").setParameter("usn", usn).setParameter("firstname", firstname).setParameter("lastname", lastname).executeUpdate();
		}catch (Exception e) {}
	}
	
	@Override
	@Transactional(rollbackOn = IOException.class)
	public void Delete(String usn) throws IOException {
		
		Student Student = em.find(Student.class, usn);
		em.remove(Student);
	}

	@Override
	@Transactional(rollbackOn = IOException.class)
	public ArrayList<Student> Show() {
		
		return (ArrayList<Student>)em.createQuery("select student from Student student",Student.class).getResultList();
	}
}

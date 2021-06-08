package com.axelor.app;

import javax.persistence.EntityManager;

import java.io.*;
import java.util.*;

import com.axelor.student.db.Student;
import com.google.inject.*;
import com.google.inject.persist.Transactional;

@Singleton
public class StudentServiceImplementation implements StudentService {

	@Inject
	private Provider<EntityManager> emp;

	@Override
	@Transactional(rollbackOn = IOException.class)
	public void insert(Student student) throws IOException {
		EntityManager em = emp.get(); // creating instance of EntityManager
		em.persist(student);
	}

	@Override
	@Transactional(rollbackOn = IOException.class)
	public void update(Student s) {
		EntityManager em = emp.get();
		Student student = em.find(Student.class, s.getId());
		student.setFirstName(s.getFirstName());
		student.setLastName(s.getLastName());

	}

	@Override
	@Transactional(rollbackOn = IOException.class)
	public void deleteById(Integer id) throws IOException {
		EntityManager em = emp.get();
		Student student = em.find(Student.class, id);
		em.remove(student);
	}

	@Override
	@Transactional(rollbackOn = IOException.class)
	public ArrayList<String> getStudentById(String id) {
		EntityManager em = emp.get();
		Student student = em.find(Student.class, id);
		ArrayList<String> studentList = new ArrayList<>();
		studentList.add(student.getId().toString());
		studentList.add(student.getFirstName());
		studentList.add(student.getLastName());
		return studentList;
	}

	@Override
	@Transactional(rollbackOn = IOException.class)
	public ArrayList<Student> show() {
		EntityManager em = emp.get();
		return (ArrayList<Student>) em.createQuery("select student from Student student", Student.class)
				.getResultList();
	}
}

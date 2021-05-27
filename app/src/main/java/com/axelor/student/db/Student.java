package com.axelor.student.db;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Student {
	@Id
	private String usn;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	public Student(String usn, @NotNull String firstName, @NotNull String lastName) {
		super();
		this.usn = usn;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Student [usn=" + usn + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	

}

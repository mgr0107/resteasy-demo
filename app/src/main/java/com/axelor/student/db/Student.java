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
	@NotNull
	private String phoneno;
	public Student(String usn, @NotNull String firstName, @NotNull String lastName, @NotNull String phoneno) {
		super();
		this.usn = usn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneno = phoneno;
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
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	@Override
	public String toString() {
		return "Student [usn=" + usn + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneno=" + phoneno
				+ "]";
	}
	
	
	}
	
	


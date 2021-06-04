package com.axelor.student.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private String usn;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	
	@OneToOne
	private Phone ph;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(String usn, @NotNull String firstName, @NotNull String lastName, Phone ph) {
		super();
		this.usn = usn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ph = ph;
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

	public Phone getPh() {
		return ph;
	}

	public void setPh(Phone ph) {
		this.ph = ph;
	}

	@Override
	public String toString() {
		return "Student [usn=" + usn + ", firstName=" + firstName + ", lastName=" + lastName + ", ph=" + ph + "]";
	}
	
		
	}
	
	


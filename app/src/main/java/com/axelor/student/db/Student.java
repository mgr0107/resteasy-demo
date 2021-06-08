package com.axelor.student.db;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;

	@OneToOne(cascade = CascadeType.ALL)
	private Phone ph;

	public Student() {
		super();
	}

	public Student(String firstName, String lastName, Phone ph) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.ph = ph;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return "Student [usn=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", ph=" + ph + "]";
	}

}

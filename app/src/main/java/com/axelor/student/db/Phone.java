package com.axelor.student.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Phone {
	
	@Id
	private String phno;
	private String isp;
	public Phone() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Phone(String phno, String isp) {
		super();
		this.phno = phno;
		this.isp = isp;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getIsp() {
		return isp;
	}
	public void setIsp(String isp) {
		this.isp = isp;
	}
	
	
}
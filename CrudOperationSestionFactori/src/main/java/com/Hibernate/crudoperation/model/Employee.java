package com.Hibernate.crudoperation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int eid;
private String ename;
private int esalary;
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public int getEsalary() {
	return esalary;
}
public void setEsalary(int esalary) {
	this.esalary = esalary;
}
public Employee(String ename, int esalary) {
	super();
	this.ename = ename;
	this.esalary = esalary;
}
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}



}
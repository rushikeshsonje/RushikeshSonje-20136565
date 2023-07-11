package com;

public class Employee {

	private Integer empId;
	private String empName;
	private String[] programming;
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String[] getProgramming() {
		return programming;
	}
	public void setProgramming(String[] programming) {
		this.programming = programming;
	}
	public void display() {
		System.out.println("Id : "+empId);
		System.out.println("Name : "+empName);

	}
	
}

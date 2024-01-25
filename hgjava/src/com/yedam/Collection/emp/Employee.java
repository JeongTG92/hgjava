package com.yedam.Collection.emp;

import java.util.Date;

public class Employee {
	private int empNo;
	private String empName;
	private Date hireDate;
	private int salary;
	
	public Employee(int empNo, String empName, Date hireDate, int salary) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.hireDate = hireDate;
		this.salary = salary;
	}

	
	
	public Date getHireDate() {
		return hireDate;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", hireDate=" + hireDate + ", salary=" + salary
				+ "]";
	}
	
	
	
}

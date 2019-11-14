package com.example.demo.model;

import java.time.LocalDate;

public class Employee {
	
	private int empID;
	private int projectID;
	private LocalDate dateFrom;
	private LocalDate dateTo;
	
	public Employee(int empID, int projectID, LocalDate dateFrom, LocalDate dateTo) {
		this.empID = empID;
		this.projectID = projectID;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}

	public int getEmpID() {
		return empID;
	}

	public int getProjectID() {
		return projectID;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", projectID=" + projectID + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo
				+ "]";
	}

}

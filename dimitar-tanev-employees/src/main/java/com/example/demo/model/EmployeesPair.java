package com.example.demo.model;

public class EmployeesPair {
	
	private int firstEmpID;
	private int secondEmpID;
	private int projectID;
	private long daysWorked;
	
	public EmployeesPair(int firstEmpID, int secondEmpID, int projectID, long daysWorked) {
		this.firstEmpID = firstEmpID;
		this.secondEmpID = secondEmpID;
		this.projectID = projectID;
		this.daysWorked = daysWorked;
	}

	public int getFirstEmpID() {
		return firstEmpID;
	}

	public int getSecondEmpID() {
		return secondEmpID;
	}

	public int getProjectID() {
		return projectID;
	}

	public long getDaysWorked() {
		return daysWorked;
	}

	@Override
	public String toString() {
		return "EmployeesPair [firstEmpID=" + firstEmpID + ", secondEmpID=" + secondEmpID + ", projectID=" + projectID
				+ ", daysWorked=" + daysWorked + "]";
	}
	
	
}

package com.emp.bonous.dto;

import java.util.List;

public class EmployeeRequest {

	 private List<EmployeeDto> employees;

	public List<EmployeeDto> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeDto> employees) {
		this.employees = employees;
	}
	 
}

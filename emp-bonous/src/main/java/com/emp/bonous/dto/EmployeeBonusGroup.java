package com.emp.bonous.dto;

import java.util.List;

public class EmployeeBonusGroup {
    private String currency;
    private List<EmployeeBonus> employees;
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public List<EmployeeBonus> getEmployees() {
		return employees;
	}
	public void setEmployees(List<EmployeeBonus> employees) {
		this.employees = employees;
	}
	public EmployeeBonusGroup(String currency, List<EmployeeBonus> employees) {
		super();
		this.currency = currency;
		this.employees = employees;
	}
	public EmployeeBonusGroup() {
		// TODO Auto-generated constructor stub
	}
	

}
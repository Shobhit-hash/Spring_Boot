package com.emp.bonous.dto;

public class EmployeeBonus {
	 private String empName;
	 private int amount;
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public EmployeeBonus(String empName, int amount) {
		super();
		this.empName = empName;
		this.amount = amount;
	}


}

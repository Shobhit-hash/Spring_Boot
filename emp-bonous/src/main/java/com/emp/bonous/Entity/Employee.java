package com.emp.bonous.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String empName;
    private String department;
    private int amount;
    private String currency;
    private LocalDate joiningDate;
    private LocalDate exitDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	public LocalDate getExitDate() {
		return exitDate;
	}
	public void setExitDate(LocalDate exitDate) {
		this.exitDate = exitDate;
	}
	public Employee(Long id, String empName, String department, int amount, String currency, LocalDate joiningDate,
			LocalDate exitDate) {
		super();
		this.id = id;
		this.empName = empName;
		this.department = department;
		this.amount = amount;
		this.currency = currency;
		this.joiningDate = joiningDate;
		this.exitDate = exitDate;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}
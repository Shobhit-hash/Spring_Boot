package com.emp.bonous.dto;

import java.util.List;

public class EmployeeBonusResponse {
    private String errorMessage;
    private List<EmployeeBonusGroup> data;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public List<EmployeeBonusGroup> getData() {
		return data;
	}
	public void setData(List<EmployeeBonusGroup> data) {
		this.data = data;
	}

}
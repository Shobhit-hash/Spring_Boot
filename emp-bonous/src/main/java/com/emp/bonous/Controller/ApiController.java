package com.emp.bonous.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emp.bonous.dto.EmployeeBonusGroup;
import com.emp.bonous.dto.EmployeeBonusResponse;
import com.emp.bonous.dto.EmployeeRequest;
import com.emp.bonous.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private EmployeeService employeeService;



    @PostMapping("/tci/employee-bonus")
    public ResponseEntity<String> saveEmployees(@RequestBody EmployeeRequest request) {
        try {
            employeeService.saveEmployees(request.getEmployees());
            return ResponseEntity.status(HttpStatus.CREATED).body("Employees saved successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving employees: " + e.getMessage());
        }
    }
    
    @GetMapping("/tci/employee-bonus")
    public ResponseEntity<EmployeeBonusResponse> getEmployeeBonus(@RequestParam("dateParam") String dateParam) {
    	DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("MMM-dd-yyyy")
                .toFormatter(Locale.ENGLISH);
    	 LocalDate date = LocalDate.parse(dateParam, formatter);
    	 String formattedDate = date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        EmployeeBonusResponse response = new EmployeeBonusResponse();
        try {
            List<EmployeeBonusGroup> employeeGroups = employeeService.getEligibleEmployees(date);
            response.setErrorMessage("");
            response.setData(employeeGroups);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setErrorMessage("Error retrieving employee bonus data: " + e.getMessage());
            response.setData(Collections.emptyList());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}

package com.emp.bonous.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.bonous.Entity.Employee;
import com.emp.bonous.Repo.EmployeeRepository;
import com.emp.bonous.dto.EmployeeBonus;
import com.emp.bonous.dto.EmployeeBonusGroup;
import com.emp.bonous.dto.EmployeeDto;

@Service 
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    private final DateTimeFormatter dateFormatter = new DateTimeFormatterBuilder()
        .parseCaseInsensitive()
        .appendPattern("MMM-dd-yyyy")
        .toFormatter();

    public void saveEmployees(List<EmployeeDto> employeeDtos) {
        List<Employee> employees = employeeDtos.stream()
            .map(this::convertDtoToEntity)
            .collect(Collectors.toList());
        employeeRepository.saveAll(employees);
    }

    private Employee convertDtoToEntity(EmployeeDto dto) {
        Employee employee = new Employee();
        employee.setEmpName(dto.getEmpName());
        employee.setDepartment(dto.getDepartment());
        employee.setAmount(dto.getAmount());
        employee.setCurrency(dto.getCurrency());
        employee.setJoiningDate(LocalDate.parse(dto.getJoiningDate(), dateFormatter));
        employee.setExitDate(LocalDate.parse(dto.getExitDate(), dateFormatter));
        return employee;
    }
    public List<EmployeeBonusGroup> getEligibleEmployees(LocalDate date) {
        List<Employee> employees = employeeRepository.findEligibleEmployees(date);
        LOGGER.info("Employee list size {}",employees.size());
        Map<String, List<EmployeeBonus>> employeesByCurrency = employees.stream()
            .collect(Collectors.groupingBy(Employee::getCurrency,
                     Collectors.mapping(employee -> new EmployeeBonus(employee.getEmpName(), employee.getAmount()),
                                       Collectors.toList())));

        List<EmployeeBonusGroup> result = new ArrayList<>();
        employeesByCurrency.forEach((currency, bonusList) -> {
            EmployeeBonusGroup group = new EmployeeBonusGroup();
            group.setCurrency(currency);
            group.setEmployees(bonusList);
            result.add(group);
        });
        return result;
    }
}


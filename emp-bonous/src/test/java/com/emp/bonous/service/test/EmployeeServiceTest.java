package com.emp.bonous.service.test;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.emp.bonous.Entity.Employee;
import com.emp.bonous.Repo.EmployeeRepository;
import com.emp.bonous.dto.EmployeeBonusGroup;
import com.emp.bonous.dto.EmployeeDto;
import com.emp.bonous.service.EmployeeService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveEmployees() {
        // Arrange
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        // Add employeeDtos to the list

        // Act
        employeeService.saveEmployees(employeeDtos);

        // Assert
        // Verify that the employeeRepository.saveAll method was called once with the correct list of employees
        verify(employeeRepository, times(1)).saveAll(anyList());
    }

    @Test
    public void testGetEligibleEmployees() {
        // Arrange
        LocalDate date = LocalDate.now(); // Or any specific date you want to test
        List<Employee> employees = new ArrayList<>();
        // Add employees to the list
        when(employeeRepository.findEligibleEmployees(date)).thenReturn(employees);

        // Act
        List<EmployeeBonusGroup> result = employeeService.getEligibleEmployees(date);

        // Assert
        // Verify that the employeeRepository.findEligibleEmployees method was called once with the correct date
        verify(employeeRepository, times(1)).findEligibleEmployees(date);
        // Add more assertions based on the expected result
    }
}

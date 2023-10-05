package com.emp.bonous.controller.test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.emp.bonous.Controller.ApiController;
import com.emp.bonous.dto.EmployeeBonusGroup;
import com.emp.bonous.dto.EmployeeBonusResponse;
import com.emp.bonous.dto.EmployeeRequest;
import com.emp.bonous.service.EmployeeService;

public class ApiControllerTest {

    @InjectMocks
    private ApiController apiController;

    @Mock
    private EmployeeService employeeService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveEmployees() {
        // Arrange
        EmployeeRequest request = new EmployeeRequest(); // create your request object

        // Act
        ResponseEntity<String> response = apiController.saveEmployees(request);

        // Assert
        assert(response.getStatusCode()).equals(HttpStatus.CREATED);
        verify(employeeService).saveEmployees(request.getEmployees());
    } 

    @Test
    public void testGetEmployeeBonus() {
        // Arrange
        String dateParam = "may-27-2022";
        LocalDate date = LocalDate.of(2022, 5, 27); // May is month number 5
        List<EmployeeBonusGroup> expectedGroups = Collections.emptyList();

        // Mocking service method
        when(employeeService.getEligibleEmployees(date)).thenReturn(expectedGroups);

        // Act
        ResponseEntity<EmployeeBonusResponse> responseEntity = apiController.getEmployeeBonus(dateParam);

        // Assert
        assert(responseEntity.getStatusCode()).equals(HttpStatus.OK);
        EmployeeBonusResponse response = responseEntity.getBody();
        assert(response.getErrorMessage()).equals("");
        assert(response.getData()).equals(expectedGroups);
        verify(employeeService).getEligibleEmployees(date);
    }
}

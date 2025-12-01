package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @Test
    void helloReturnsGreetingMessage() {
        String result = employeeController.hello();

        assertEquals("Hello, World!", result);
    }

    @Test
    void getAllEmployeesReturnsListOfEmployees() {
        List<Employee> expectedEmployees = new ArrayList<>();
        expectedEmployees.add(new Employee("John Doe", "IT", new BigDecimal("1000")));
        expectedEmployees.add(new Employee("Jane Smith", "HR", new BigDecimal("0")));
        when(employeeService.getAllEmployees()).thenReturn(expectedEmployees);

        List<Employee> result = employeeController.getAllEmployees();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(employeeService).getAllEmployees();
    }


    @Test
    void getAllEmployeesReturnsEmptyListWhenNoEmployeesExist() {
        when(employeeService.getAllEmployees()).thenReturn(Collections.emptyList());

        List<Employee> result = employeeController.getAllEmployees();

        assertNotNull(result);
        assertEquals(0, result.size());
        verify(employeeService).getAllEmployees();
    }
}
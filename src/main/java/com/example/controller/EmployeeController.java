package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/hello")
    public String hello() {


        return "Hello, World!";
    }
    @GetMapping("/list")
    public List<Employee> getAllEmployees() {
        // Service layer call to fetch all employees
        return employeeService.getAllEmployees();
    }

}


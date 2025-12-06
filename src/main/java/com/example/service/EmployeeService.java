package com.example.service;

import com.example.model.Employee;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service to manage employee records.
 */
@Service
public class EmployeeService {

    private final List<Employee> employeeList = new ArrayList<>();

    public EmployeeService() {
    }

    /**
     * Adds a new employee to the list.
     *
     * @param employee the employee to add
     * @throws IllegalArgumentException if the employee already exists
     */
    public void addEmployee(Employee employee) {
        if (employeeList.stream().anyMatch(e -> e.getName().equalsIgnoreCase(employee.getName()))) {
            throw new IllegalArgumentException("Employee with the same name already exists.");
        }
        employeeList.add(employee);
    }

    /**
     * Retrieves all employees.
     *
     * @return a list of all employees
     */
    public List<Employee> getAllEmployees() {
        return mockEmpoyeeData();
    }

    /**
     * Finds an employee by name.
     *
     * @param name the name of the employee
     * @return an Optional containing the employee if found, or empty otherwise
     */
    public Optional<Employee> findEmployeeByName(String name) {
        return employeeList.stream()
                .filter(employee -> employee.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    /**
     * Updates the department and salary of an existing employee.
     *
     * @param name   the name of the employee to update
     * @param dept   the new department
     * @param salary the new salary
     * @throws IllegalArgumentException if the employee does not exist
     */
    public void updateEmployee(String name, String dept, BigDecimal salary) {
        Employee employee = findEmployeeByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found."));
        employeeList.remove(employee);
        employeeList.add(new Employee(name, dept, salary));
    }

    /**
     * Deletes an employee by name.
     *
     * @param name the name of the employee to delete
     * @throws IllegalArgumentException if the employee does not exist
     */
    public void deleteEmployee(String name) {
        Employee employee = findEmployeeByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found."));
        employeeList.remove(employee);
    }

    /**
     * Retrieves employees with a salary above a certain threshold.
     *
     * @param salaryThreshold the salary threshold
     * @return a list of employees with a salary above the threshold
     */
    public List<Employee> getEmployeesWithSalaryAbove(BigDecimal salaryThreshold) {
        return employeeList.stream()
                .filter(employee -> employee.getSalary().compareTo(salaryThreshold) > 0)
                .collect(Collectors.toList());
    }



    public List<Employee> filterEmployees() {
        // Example filter: return employees from IT department with salary above 65000
        List<Employee> empList = mockEmpoyeeData();
       /* List<Employee> employeeList = empList.stream()
                .filter(employee -> "IT".equalsIgnoreCase(employee.getDept()) &&
                        employee.getSalary().compareTo(new BigDecimal("65000")) > 0)
                .collect(Collectors.toList());*/

        List<Employee> tempList = new ArrayList<>();
        for(Employee emp : empList) {
            if("IT".equalsIgnoreCase(emp.getDept()) &&
                    emp.getSalary().compareTo(new BigDecimal("70000")) > 0) {
                tempList.add(emp);
            }

        }

        return tempList;
    }

    private List<Employee> mockEmpoyeeData() {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee("Alice", "HR", new BigDecimal("60000")));
        empList.add(new Employee("Bob", "Finance", new BigDecimal("65000")));
        empList.add(new Employee("Charlie", "IT", new BigDecimal("70000")));
        empList.add(new Employee("David", "Marketing", new BigDecimal("55000")));
        empList.add(new Employee("Eve", "Sales", new BigDecimal("62000")));
        empList.add(new Employee("Frank", "IT", new BigDecimal("72000")));
        empList.add(new Employee("Grace", "Finance", new BigDecimal("68000")));
        empList.add(new Employee("Heidi", "HR", new BigDecimal("61000")));
        empList.add(new Employee("Ivan", "Sales", new BigDecimal("63000")));
        empList.add(new Employee("Judy", "Marketing", new BigDecimal("56000")));
        empList.add(new Employee("Karl", "IT", new BigDecimal("74000")));
        empList.add(new Employee("Laura", "Finance", new BigDecimal("69000")));
        empList.add(new Employee("Mallory", "HR", new BigDecimal("62000")));
        empList.add(new Employee("Niaj", "Sales", new BigDecimal("64000")));
        empList.add(new Employee("Olivia", "Marketing", new BigDecimal("57000")));
        empList.add(new Employee("Peggy", "IT", new BigDecimal("76000")));
        empList.add(new Employee("Quentin", "Finance", new BigDecimal("70000")));
        empList.add(new Employee("Rupert", "HR", new BigDecimal("63000")));
        empList.add(new Employee("Sybil", "Sales", new BigDecimal("65000")));
        empList.add(new Employee("Trent", "Marketing", new BigDecimal("58000")));
        return empList;
    }



}
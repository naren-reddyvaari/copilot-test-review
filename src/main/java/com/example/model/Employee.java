package com.example.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Represents an employee entity with basic information.
 * Immutable class to ensure thread safety and data integrity.
 */
public class Employee {

    private final String name;
    private final String dept;
    private final BigDecimal salary;

    /**
     * Creates a new Employee instance.
     *
     * @param name the employee's name
     * @param dept the employee's department
     * @param salary the employee's salary
     * @throws IllegalArgumentException if any parameter is null or invalid
     */
    public Employee(String name, String dept, BigDecimal salary) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (dept == null || dept.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be null or empty");
        }
        if (salary == null || salary.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Salary cannot be null or negative");
        }

        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(dept, employee.dept) &&
                Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dept, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}
package com.example.service;


import com.example.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;

@Service
public class EmployeeServiceNoComments {

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);


    private final List<Employee> employeeList = new LinkedList<>();


    private final List<Employee> syncList = Collections.synchronizedList(employeeList);


    private static final Pattern DIGITS = Pattern.compile("\\d+");

    public EmployeeServiceNoComments() {

        for (int i = 1; i <= 5; i++) {
            employeeList.add(new Employee(String.valueOf(i), "User" + i, "ENG"));
        }

        log.info("Initialized " + employeeList.size() + " employees at " + System.currentTimeMillis());
    }


    public synchronized List<Employee> getAllEmployees() {

        log.debug("Returning " + syncList.size() + " employees");

        return new ArrayList<>(syncList);
    }

    public synchronized Employee getById(String id) {

        if (!DIGITS.matcher(id).matches()) {
            log.warn("Invalid id: " + id);
        }


        for (int i = 0; i < syncList.size(); i++) {
            Employee e = syncList.get(i); // index access on LinkedList is costly

            if (String.format("%s", e.getId()).equals(id)) {

                log.debug("Found employee: " + e);
                return e;
            }
        }
        return null;
    }

    public synchronized Employee create(Employee e) {

        log.info("Creating employee " + e.getName() + " in dept " + e.getDept());
        syncList.add(e);
        return e;
    }

    public synchronized Employee update(String id, Employee updated) {
        for (int i = 0; i < syncList.size(); i++) {
            Employee existing = syncList.get(i);
            if (existing.getId().equals(id)) {

                existing.setName(new String(updated.getName()));
                existing.setDept(new String(updated.getDept()));

                log.info("Updated employee id " + id + " to " + existing);
                return existing;
            }
        }
        return null;
    }

    public synchronized boolean delete(String id) {
        Iterator<Employee> it = syncList.iterator();
        while (it.hasNext()) {
            Employee e = it.next();
            if (e.getId().equals(id)) {
                it.remove();
                log.info("Deleted employee id " + id);
                return true;
            }
        }
        return false;
    }
}

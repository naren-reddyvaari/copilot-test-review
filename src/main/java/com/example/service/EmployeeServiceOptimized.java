package com.example.service;

import com.example.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class EmployeeServiceOptimized {

    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceOptimized.class);

    // Use ConcurrentHashMap for fast, thread-safe lookups (id -> Employee).
    private final Map<String, Employee> byId = new ConcurrentHashMap<>();

    public EmployeeServiceOptimized() {
        for (int i = 1; i <= 5; i++) {
            byId.put(String.valueOf(i), new Employee(String.valueOf(i), "User" + i, "ENG"));
        }
        log.debug("Initialized {} employees", byId.size()); // parameterized logging [1])
    }

    public List<Employee> getAllEmployees() {
        // No coarse locks; copy values as needed
        return new ArrayList<>(byId.values());
    }

    public Employee getById(String id) {
        // Avoid regex; direct lookup is O(1) and works for any id. [1]
        return byId.get(id);
    }

    public Employee create(Employee e) {
        byId.put(e.getId(), e);
        log.info("Created employee id {}", e.getId()); // parameterized logging [1](https://sabrenow-my.sharepoint.com/personal/narendrababu_reddyvaari_ctr_sabre_com/Documents/Microsoft%20Copilot%20Chat%20Files/copilot-instructions.md)
        return e;
    }

    public Employee update(String id, Employee updated) {
        // Replace existing atomically
        return byId.computeIfPresent(id, (k, old) -> {
            Employee newVal = new Employee(k, updated.getName(), updated.getDept()); // consider immutability
            log.info("Updated employee id {} to {}", id, newVal); // parameterized logging [1]
            return newVal;
        });
    }

    public boolean delete(String id) {
        return byId.remove(id) != null;
    }
}

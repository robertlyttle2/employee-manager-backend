package com.robertlyttle.employeemanager.service;

import com.robertlyttle.employeemanager.model.Employee;
import org.springframework.data.domain.Page;

public interface EmployeeService {
    Page<Employee> getAllEmployees(int page, int limit, String sortBy);
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Employee employee, Long id);
    void deleteEmployee(Long id);

}

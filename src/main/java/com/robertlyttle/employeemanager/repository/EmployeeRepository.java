package com.robertlyttle.employeemanager.repository;

import com.robertlyttle.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findEmployeeByPersonalEmail(String email);

}

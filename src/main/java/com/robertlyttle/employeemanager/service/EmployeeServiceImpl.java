package com.robertlyttle.employeemanager.service;

import com.robertlyttle.employeemanager.exception.BadRequestException;
import com.robertlyttle.employeemanager.model.Employee;
import com.robertlyttle.employeemanager.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> getAllEmployees(int pageNumber, int limit, String sortBy) {
        log.info("Fetching all employees");
        Sort sort = Sort.by(Sort.Direction.ASC, sortBy);
        PageRequest pageRequest = PageRequest.of(pageNumber, limit, sort);
        return employeeRepository.findAll(pageRequest);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        Employee exists = employeeRepository.findEmployeeByPersonalEmail(employee.getPersonalEmail());
        if (exists != null) {
            String message = "Employee with email address " + employee.getPersonalEmail() +
                    " already exists in the database";
            log.error(message);
            throw new BadRequestException(message);
        }

        employee.setCompanyEmail(employee.generateCompanyEmail());
        log.info("Saving employee: {}", employee);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new IllegalStateException("Employee with ID " + id + " not found"));
        if (existingEmployee != null) {
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setPersonalEmail(employee.getPersonalEmail());
            existingEmployee.setDateOfBirth(employee.getDateOfBirth());
            existingEmployee.setContactNumber(employee.getContactNumber());
            existingEmployee.setGender(employee.getGender());
            existingEmployee.setJobTitle(employee.getJobTitle());
            existingEmployee.setDepartment(employee.getDepartment());
            existingEmployee.setAnnualSalary(employee.getAnnualSalary());
            log.info("Updating employee with ID: {} to {}", id, employee);
            return employeeRepository.save(existingEmployee);
        }
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new IllegalStateException("Employee with ID " + id + " not found"));
        if (existingEmployee != null) {
            log.info("Deleting employee with ID: {}", id);
            employeeRepository.deleteById(id);
        }

    }
}

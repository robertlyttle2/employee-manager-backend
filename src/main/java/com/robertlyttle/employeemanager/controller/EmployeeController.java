package com.robertlyttle.employeemanager.controller;

import com.robertlyttle.employeemanager.model.Employee;
import com.robertlyttle.employeemanager.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/all/{sortBy}/{pageNumber}")
    public Page<Employee> getAllEmployees(@PathVariable("sortBy") String sortBy, @PathVariable("pageNumber") int pageNumber) {
        return employeeService.getAllEmployees(pageNumber, 8, sortBy);}

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody @Valid Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/{employeeId}/update")
    public Employee updateEmployee(@RequestBody @Valid Employee employee, @PathVariable("employeeId") Long id) {
        return employeeService.updateEmployee(employee, id);
    }

    @DeleteMapping("/delete/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long id) {
        employeeService.deleteEmployee(id);
    }
}

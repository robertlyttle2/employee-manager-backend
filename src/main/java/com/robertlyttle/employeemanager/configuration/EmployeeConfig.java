package com.robertlyttle.employeemanager.configuration;

import com.robertlyttle.employeemanager.enumeration.Department;
import com.robertlyttle.employeemanager.enumeration.Gender;
import com.robertlyttle.employeemanager.model.Employee;
import com.robertlyttle.employeemanager.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
        return args -> {
            employeeRepository.saveAll(Arrays.asList(
                    new Employee(
                            "Courtney",
                            "Warner",
                            "cwarner@icloud.com",
                            LocalDate.of(1955, 2, 24),
                            "07568453120",
                            Gender.FEMALE,
                            "Software Engineer II",
                            Department.IT,
                            32000.00),
                    new Employee("Deacon",
                            "Smith",
                            "deaconsmith_@hotmail.com",
                            LocalDate.of(1992, 10, 8),
                            "07594695854",
                            Gender.MALE,
                            "HR Officer",
                            Department.HR,
                            29000.00),
                    new Employee("Danny",
                            "Stevenson",
                            "danny-stevenson3@gmail.com",
                            LocalDate.of(1980, 12, 31),
                            "07851365451",
                            Gender.OTHER,
                            "Accountant",
                            Department.FINANCE,
                            28000.00)
            ));
        };
    }
}

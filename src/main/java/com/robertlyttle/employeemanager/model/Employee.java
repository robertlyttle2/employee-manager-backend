package com.robertlyttle.employeemanager.model;

import com.robertlyttle.employeemanager.enumeration.Department;
import com.robertlyttle.employeemanager.enumeration.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "student_sequence",
            strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank(message = "Firstname cannot be empty or null")
    @Column(nullable = false)
    private String firstName;
    @NotBlank(message = "Lastname cannot be empty or null")
    @Column(nullable = false)
    private String lastName;
    @Email(message = "Must be a valid email format")
    @Column(nullable = false, unique = true)
    private String personalEmail;
    private String companyEmail;
    @NotNull(message = "Date of birth cannot be empty or null")
    @Column(nullable = false)
    private LocalDate dateOfBirth;
    @NotBlank(message = "Contact number cannot be empty or null")
    @Column(nullable = false)
    private String contactNumber;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;
    @NotBlank(message = "Job title cannot be empty or null")
    @Column(nullable = false)
    private String jobTitle;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Department department;
    @Column(nullable = false)
    private double annualSalary;

    public Employee(String firstName, String lastName, String personalEmail, LocalDate dateOfBirth, String contactNumber, Gender gender, String jobTitle, Department department, double annualSalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalEmail = personalEmail;
        this.companyEmail = generateCompanyEmail();
        this.dateOfBirth = dateOfBirth;
        this.contactNumber = contactNumber;
        this.gender = gender;
        this.jobTitle = jobTitle;
        this.department = department;
        this.annualSalary = annualSalary;
    }

    public String generateCompanyEmail() {
        String companyPrefix = "@fictional-company.com";

        return this.firstName.toLowerCase().trim().replaceAll(" ", "-")
                + "." + this.lastName.toLowerCase().trim().replaceAll(" ", "-")
                + companyPrefix;
    }
}

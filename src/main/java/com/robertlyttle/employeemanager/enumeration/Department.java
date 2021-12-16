package com.robertlyttle.employeemanager.enumeration;

public enum Department {
    FINANCE("FINANCE"),
    HR("HR"),
    MARKETING("MARKETING"),
    SALES("SALES"),
    IT("IT");

    public final String department;

    Department(String department) {
        this.department = department;
    }
}

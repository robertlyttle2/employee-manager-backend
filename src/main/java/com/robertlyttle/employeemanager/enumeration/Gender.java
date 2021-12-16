package com.robertlyttle.employeemanager.enumeration;

public enum Gender {
    MALE("MALE"),
    FEMALE("FEMALE"),
    OTHER("OTHER");

    public final String gender;

    Gender(String gender) {
        this.gender = gender;
    }
}

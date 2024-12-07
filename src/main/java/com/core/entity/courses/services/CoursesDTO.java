package com.core.entity.courses.services;

public class CoursesDTO {
    private final String description, department;
    private final int code, hours, password;
    private final double price;

    public CoursesDTO(int code, double price, String description, int hours, String department, int password) {
        this.code = code;
        this.price = price;
        this.description = description;
        this.hours = hours;
        this.department = department;
        this.password = password;
    }

    public int getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getHours() {
        return hours;
    }

    public String getDepartment() {
        return department;
    }

    public int getPassword() {
        return password;
    }
}

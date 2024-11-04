package com.core.entity.employee.services;

public class EmployeeDTO {
    private final String name, surname, email, number, address, antiquity, department, schedule;
    private final int ident, bankaccount;

    public EmployeeDTO(String name, String surname, String email, String number, String address,
            String antiquity, int ident, String department, String schedule, int bankaccount) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.number = number;
        this.address = address;
        this.antiquity = antiquity;
        this.ident = ident;
        this.department = department;
        this.schedule = schedule;
        this.bankaccount = bankaccount;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    public String getAntiquity() {
        return antiquity;
    }

    public int getIdent() {
        return ident;
    }

    public String getDepartment() {
        return department;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getBankaccount() {
        return bankaccount;
    }
}

package com.core.entity.ClientCompany.services;

public class ClientCompanyDTO {
    private final String name, surname, email, number, address,antiquity, paymentcode, socialreason;
    private final int ident, workers;

    public ClientCompanyDTO(String name, String surname, String email, String number, String address, String antiquity,
    int ident, String paymentcode, int workers, String socialreason) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.number = number;
        this.address = address;
        this.antiquity = antiquity;
        this.ident = ident;
        this.paymentcode = paymentcode;
        this.workers = workers;
        this.socialreason = socialreason;
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
    
    public String getPaymentcode() {
        return paymentcode;
    }

    public int getWorkers() {
        return workers;
    }

    public String getSocialreason() {
        return socialreason;
    }
}

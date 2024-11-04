package com.core.entity.client.services;

public class ClientDTO {
    private final String name, surname, email, number, address,antiquity, paymentcode;
    private final int ident;

    
    public ClientDTO(String name, String surname, String email, String number, String address, String antiquity, int ident, String paymentcode) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.number = number;
        this.address = address;
        this.antiquity = antiquity;
        this.ident = ident;
        this.paymentcode = paymentcode;
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
}

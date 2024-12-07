package com.core.entity.provider.services;

public class ProviderDTO {
    private final String name, surname, email, number, address, antiquity, sponsors, socialreason;
    private final int ident, workers;

    public ProviderDTO(String name, String surname, String email, String number, String address, String antiquity, int ident, 
    String sponsors, int workers, String socialreason) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.number = number;
        this.address = address;
        this.antiquity = antiquity;
        this.ident = ident;
        this.sponsors = sponsors;
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

    public String getSponsors() {
        return sponsors;
    }

    public int getWorkers() {
        return workers;
    }

    public String getSocialreason() {
        return socialreason;
    }
}

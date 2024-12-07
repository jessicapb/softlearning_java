package com.core.entity.provider.services;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Proveïdor")

public class CatalaProviderDTO {
    private String name, surname, email, number, address, antiquity, sponsors, socialreason;
    private int ident, workers;

    public CatalaProviderDTO(){}

    public CatalaProviderDTO(String name, String surname, String email, String number, String address, String antiquity,
            String sponsors, String socialreason, int ident, int workers) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.number = number;
        this.address = address;
        this.antiquity = antiquity;
        this.sponsors = sponsors;
        this.socialreason = socialreason;
        this.ident = ident;
        this.workers = workers;
    }

    // Nom
    @JsonGetter("nom_treballador")
    public String getName() {
        return name;
    }

    @JsonSetter("nom_treballador")
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAntiquity() {
        return antiquity;
    }

    public void setAntiquity(String antiquity) {
        this.antiquity = antiquity;
    }

    public String getSponsors() {
        return sponsors;
    }

    public void setSponsors(String sponsors) {
        this.sponsors = sponsors;
    }

    public String getSocialreason() {
        return socialreason;
    }

    public void setSocialreason(String socialreason) {
        this.socialreason = socialreason;
    }

    public int getIdent() {
        return ident;
    }

    public void setIdent(int ident) {
        this.ident = ident;
    }

    public int getWorkers() {
        return workers;
    }

    public void setWorkers(int workers) {
        this.workers = workers;
    }

    
}

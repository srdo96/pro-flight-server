package com.ars.proflight.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "passenger")
public class PassengerModel {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String passportCode;

    public PassengerModel(String firstName, String lastName, String address, String passportCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.passportCode = passportCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassportCode() {
        return passportCode;
    }

    public void setPassportCode(String passportCode) {
        this.passportCode = passportCode;
    }
}

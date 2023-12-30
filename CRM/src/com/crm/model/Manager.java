package com.crm.model;

public class Manager extends Person {
    private String internalPhoneNumber;
    private String pin;

    public Manager(String name, String surname, String username, String password, String address,
                   String phoneNumber, String internalPhoneNumber, String pin) {
        super(name, surname, username, password, address, phoneNumber);
        this.internalPhoneNumber = internalPhoneNumber;
        this.pin = pin;
    }

    public String getInternalPhoneNumber() {
        return internalPhoneNumber;
    }

    public String getPin() {
        return pin;
    }
}

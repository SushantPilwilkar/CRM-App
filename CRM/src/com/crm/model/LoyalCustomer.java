package com.crm.model;

public class LoyalCustomer extends Customer {
    private int individualID;
    private double discount;

    public LoyalCustomer(String name, String surname, String email, String phone, String address,
                         int individualID, double discount) {
        super(name, surname, email, phone, address);
        this.individualID = individualID;
        this.discount = discount;
    }

    public int getIndividualID() {
        return individualID;
    }

    public double getDiscount() {
        return discount;
    }
}

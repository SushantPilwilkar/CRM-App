package com.crm.model;

public class BusinessCustomer extends LoyalCustomer {
    private String businessID;
    private double businessDiscount;

    public BusinessCustomer(String name, String surname, String email, String phone, String address,
                            int individualID, double discount, String businessID, double businessDiscount) {
        super(name, surname, email, phone, address, individualID, discount);
        this.businessID = businessID;
        this.businessDiscount = businessDiscount;
    }

    public String getBusinessID() {
        return businessID;
    }

    public double getBusinessDiscount() {
        return businessDiscount;
    }
}

package com.crm.model;

public class Customer {
    private static int nextID = 1;

    protected int ID;
    protected String name;
    protected String surname;
    protected String email;
    protected String phone;
    protected String address;

    public Customer(String name, String surname, String email, String phone, String address) {
        this.ID = nextID++;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
    public void updateInfo(String name, String surname, String email, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    
    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public void printInfo() {
        System.out.println("Customer ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);
    }
}

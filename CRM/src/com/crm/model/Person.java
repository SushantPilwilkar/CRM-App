package com.crm.model;

public class Person {
    private static int nextID = 1;

    protected int ID;
    protected String name;
    protected String surname;
    protected String username;
    protected String password;
    protected String address;
    protected String phoneNumber;

    public Person(String name, String surname, String username, String password, String address, String phoneNumber) {
        this.ID = nextID++;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getID() {
        return ID;
    }

    public void printInfo() {
        System.out.println("ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Username: " + username);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNumber);
    }
}

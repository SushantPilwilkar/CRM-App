package com.crm.model;

import java.security.NoSuchAlgorithmException;
import com.crm.model.PasswordHasher;

public class User extends Person {
    private String internalPhoneNumber;
    private double baseSalary;
    private String hashedPassword;

    public User(String name, String surname, String username, String password, String address,
                String phoneNumber, String internalPhoneNumber, double baseSalary) {
        super(name, surname, username, null, address, phoneNumber);
        this.internalPhoneNumber = internalPhoneNumber;
        this.baseSalary = baseSalary;
        try {
            this.hashedPassword = PasswordHasher.hashPassword(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace(); // Handle the exception according to your application's requirements
        }
    }

    public String getInternalPhoneNumber() {
        return internalPhoneNumber;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
    public boolean verifyPassword(String inputPassword) {
        try {
            String hashedInputPassword = PasswordHasher.hashPassword(inputPassword);
            return hashedInputPassword.equals(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace(); // Handle the exception according to your application's requirements
            return false;
        }
    }
}

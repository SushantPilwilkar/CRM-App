package com.crm.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {
 public static String hashPassword(String password) throws NoSuchAlgorithmException {
     MessageDigest md = MessageDigest.getInstance("SHA-256");
     byte[] hashBytes = md.digest(password.getBytes());

     StringBuilder hashedPassword = new StringBuilder();
     for (byte b : hashBytes) {
         hashedPassword.append(String.format("%02x", b));
     }

     return hashedPassword.toString();
 }
}

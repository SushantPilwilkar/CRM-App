package com.crm.model;

public class Service {
    private static int nextID = 1;

    private int ID;
    private int customerID;
    private String priority;
    private double resolutionTimeFrame;
    private String assignedUser;
    private String status;
    private double fee;

    public Service(int customerID, String priority, double resolutionTimeFrame,
                   String assignedUser, String status, double fee) {
        this.ID = nextID++;
        this.customerID = customerID;
        this.priority = priority;
        this.resolutionTimeFrame = resolutionTimeFrame;
        this.assignedUser = assignedUser;
        this.status = status;
        this.fee = fee;
    }

    // Getters and setters for attributes

    public int getID() {
        return ID;
    }

    // Additional getters and setters for other attributes

    public void printInfo() {
        System.out.println("Service ID: " + ID);
        System.out.println("Customer ID: " + customerID);
        System.out.println("Priority: " + priority);
        System.out.println("Resolution Time Frame: " + resolutionTimeFrame);
        System.out.println("Assigned User: " + assignedUser);
        System.out.println("Status: " + status);
        System.out.println("Fee: " + fee);
    }
}

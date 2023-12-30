package com.crm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CRMSystem {
    private static Map<String, User> users = new HashMap<>();
    private static Manager manager;
    private static List<Customer> customers = new ArrayList<>();
    private static List<Service> services = new ArrayList<>();

    public static void main(String[] args) {
        initializeUsers();
        initializeManager();

        Scanner scanner = new Scanner(System.in);
        
        // Simulate a login procedure
        System.out.print("Enter username: ");
        String username = scanner.next().toLowerCase(); // Convert to lowercase

        // Assuming you have a User object associated with the entered username
        User user = users.get(username);

        if (user != null) {
            System.out.print("Enter password: ");
            String password = scanner.next();

            if (user.verifyPassword(password)) {
                System.out.println("Login successful! Welcome, " + user.getName() + " " + user.getSurname());
                // Continue with the rest of the CRMSystem logic
            } else {
                System.out.println("Invalid password. Exiting CRM System.");
                scanner.close();
                System.exit(0);
            }
        } else {
            System.out.println("User not found. Exiting CRM System.");
            scanner.close();
            System.exit(0);
        }

        while (true) {
        	// Inside the main menu loop
        	System.out.println("1. Create Customer");
        	System.out.println("2. Create Service");
        	System.out.println("3. Print Customer Information");
        	System.out.println("4. Print Service Information");
        	System.out.println("5. Exit");
        	System.out.print("Select an option (1-5): ");


        	int choice = scanner.nextInt();
        	scanner.nextLine();

            switch (choice) {
                case 1:
                    createCustomer(scanner);
                    break;
                case 2:
                    createService(scanner);
                    break;
                case 3:
                    printCustomerInformation(scanner);
                    break;
                case 4:
                    printServiceInformation(scanner);
                    break;
                case 5:
                    System.out.println("Exiting CRM System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                case 6:
                    searchCustomer(scanner);
                    break;
                case 7:
                    updateCustomerInformation(scanner);
                    break;
                case 8:
                    displayStatistics();
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            // Consume the remaining characters including newline
            scanner.nextLine();
        }
    }

    private static void initializeUsers() {
        // Initialize five fixed users
        users.put("sushh", new User("Sush", "Pilwilkar", "sushh", "Sushh", "x", "123456789", "Internal123", 1000.0));
        users.put("user2", new User("User2", "Surname2", "user2", "password2", "Address2", "987654321", "Internal456", 1200.0));
        users.put("user3", new User("User3", "Surname3", "user3", "password3", "Address3", "555555555", "Internal789", 1500.0));
        users.put("user4", new User("User4", "Surname4", "user4", "password4", "Address4", "333333333", "Internal101", 900.0));
        users.put("user5", new User("User5", "Surname5", "user5", "password5", "Address5", "111111111", "Internal112", 1100.0));
    }

    private static void initializeManager() {
        // Initialize one fixed manager
        manager = new Manager("Manager", "Surname", "manager", "password", "ManagerAddress", "999999999", "Internal999", "1234");
    }
    
 // Inside the CRMSystem class

    private static void searchCustomer(Scanner scanner) {
        System.out.print("Enter customer name to search: ");
        String customerName = scanner.nextLine();

        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(customerName)) {
                System.out.println("Customer found:");
                customer.printInfo();
                return;
            }
        }
        System.out.println("Customer not found with name: " + customerName);
    }

    private static void updateCustomerInformation(Scanner scanner) {
        System.out.print("Enter customer ID to update information: ");
        int customerID = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        for (Customer customer : customers) {
            if (customer.getID() == customerID) {
                System.out.println("Enter new customer information:");

                System.out.print("Enter customer name: ");
                String name = scanner.nextLine();

                System.out.print("Enter customer surname: ");
                String surname = scanner.nextLine();

                System.out.print("Enter customer email: ");
                String email = scanner.nextLine();

                System.out.print("Enter customer phone: ");
                String phone = scanner.nextLine();

                System.out.print("Enter customer address: ");
                String address = scanner.nextLine();

                // Update customer information
                customer.updateInfo(name, surname, email, phone, address);

                System.out.println("Customer information updated successfully!");
                return;
            }
        }
        System.out.println("Customer not found with ID: " + customerID);
    }


    private static void displayStatistics() {
        // Implement your statistics logic based on the specific requirements
        // For example, you can display the total number of customers, services, etc.
        System.out.println("Total number of customers: " + customers.size());
        System.out.println("Total number of services: " + services.size());
        // Add more statistics as needed
    }


    private static void createCustomer(Scanner scanner) {
    	System.out.print("Enter customer ID: ");
        int customerID;
        while (true) {
            try {
                customerID = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid numeric value for customer ID.");
            }
        }
        
        System.out.print("Enter customer name: ");
        String name = scanner.next();  // Use next() instead of nextLine()

        System.out.print("Enter customer surname: ");
        String surname = scanner.next();  // Use next() instead of nextLine()

        System.out.print("Enter customer email: ");
        String email = scanner.next();  // Use next() instead of nextLine()

        System.out.print("Enter customer phone: ");
        String phone = scanner.next();  // Use next() instead of nextLine()

        System.out.print("Enter customer address: ");
        String address = scanner.next();  // Use next() instead of nextLine()

        customers.add(new Customer(name, surname, email, phone, address));
        System.out.println("Customer created successfully!");
    }


    private static void createService(Scanner scanner) {
        System.out.print("Enter customer ID: ");
        int customerID = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        System.out.print("Enter service priority (High/Medium/Low/Other): ");
        String priority = scanner.nextLine();

        System.out.print("Enter resolution time frame (in man hours): ");
        double resolutionTimeFrame = scanner.nextDouble();
        scanner.nextLine();  // Consume the newline character

        System.out.print("Enter assigned user: ");
        String assignedUser = scanner.nextLine();

        System.out.print("Enter service status (resolved/not resolved): ");
        String status = scanner.nextLine();

        System.out.print("Enter service fee: ");
        double fee = scanner.nextDouble();
        scanner.nextLine();  // Consume the newline character

        services.add(new Service(customerID, priority, resolutionTimeFrame, assignedUser, status, fee));
        System.out.println("Service created successfully!");
    }

    private static void printCustomerInformation(Scanner scanner) {
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(customerName)) {
                customer.printInfo();
                return;
            }
        }
        System.out.println("Customer not found with name: " + customerName);
    }

    private static void printServiceInformation(Scanner scanner) {
        System.out.print("Enter service ID: ");
        int serviceID = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        for (Service service : services) {
            if (service.getID() == serviceID) {
                service.printInfo();
                return;
            }
        }
        System.out.println("Service not found with ID: " + serviceID);
    }

}

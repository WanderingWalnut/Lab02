package com.yycpetresort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static List<Client> clients = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    manageClientInformation();
                    break;
                case 2:
                    managePetInformation();
                    break;
                case 3:
                    bookReservations();
                    break;
                case 4:
                    manageBilling();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("Welcome to YYC Pet Resort Management System");
        System.out.println("1. Manage Client Information");
        System.out.println("2. Manage Pet Information");
        System.out.println("3. Booking and Reservations");
        System.out.println("4. Billing and Payments");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    public static void manageClientInformation() {
        System.out.println("Manage Client Information");
        System.out.println("1. Add a new client");
        System.out.println("2. Update client information");
        System.out.println("3. Remove a client");
        System.out.println("4. View client details");
        System.out.print("Choose an option: ");

        int option = scanner.nextInt();
        scanner.nextLine();  

        switch (option) {
            case 1:
                addNewClient();
                break;
            case 2:
                updateClient();
                break;
            case 3:
                removeClient();
                break;
            case 4:
                viewClientDetails();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    public static void addNewClient() {
        System.out.print("Enter client name: ");
        String name = scanner.nextLine();

        System.out.print("Enter client phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter client address: ");
        String address = scanner.nextLine();

        Client client = new Client(name, phoneNumber, address);
        clients.add(client);
        System.out.println("New client added successfully.");
    }

    public static void updateClient() {
        System.out.print("Enter client name to update: ");
        String name = scanner.nextLine();

        
        Client clientToUpdate = findClientByName(name);

        if (clientToUpdate == null) {
            System.out.println("Client not found.");
        } else {
            System.out.print("Enter updated phone number: ");
            String phoneNumber = scanner.nextLine();
            clientToUpdate.setPhoneNumber(phoneNumber);

            System.out.print("Enter updated address: ");
            String address = scanner.nextLine();
            clientToUpdate.setAddress(address);

            System.out.println("Client information updated successfully.");
        }
    }

    public static void removeClient() {
        System.out.print("Enter client name to remove: ");
        String name = scanner.nextLine();

        
        Client clientToRemove = findClientByName(name);

        if (clientToRemove == null) {
            System.out.println("Client not found.");
        } else {
            clients.remove(clientToRemove);
            System.out.println("Client removed successfully.");
        }
    }

    public static void viewClientDetails() {
        System.out.print("Enter client name to view details: ");
        String name = scanner.nextLine();

        
        Client client = findClientByName(name);

        if (client == null) {
            System.out.println("Client not found.");
        } else {
            System.out.println("Client Details:");
            System.out.println("Name: " + client.getName());
            System.out.println("Phone Number: " + client.getPhoneNumber());
            System.out.println("Address: " + client.getAddress());
            System.out.println("Pets:");
            for (Pet pet : client.getPets()) {
                System.out.println(" - " + pet.getName() + " (" + pet.getType() + ")");
            }
        }
    }

    public static void managePetInformation() {
        System.out.println("Manage Pet Information");
        System.out.println("1. Add a new pet");
        System.out.println("2. Update pet information");
        System.out.println("3. Remove a pet");
        System.out.println("4. View pet details");
        System.out.print("Choose an option: ");

        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        switch (option) {
            case 1:
                addNewPet();
                break;
            case 2:
                updatePet();
                break;
            case 3:
                removePet();
                break;
            case 4:
                viewPetDetails();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    public static void addNewPet() {
        System.out.print("Enter client name to associate with the pet: ");
        String clientName = scanner.nextLine();
        Client client = findClientByName(clientName);

        if (client == null) {
            System.out.println("Client not found.");
            return;
        }

        System.out.print("Enter pet name: ");
        String name = scanner.nextLine();

        System.out.print("Enter pet type (e.g., cat, dog, bird): ");
        String type = scanner.nextLine();

        System.out.print("Enter pet breed: ");
        String breed = scanner.nextLine();

        System.out.print("Enter pet age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        System.out.print("Enter special instructions for the pet: ");
        String specialInstructions = scanner.nextLine();

        Pet pet = new Pet(name, type, breed, age, specialInstructions);
        client.addPet(pet);
        System.out.println("New pet added successfully.");
    }

    public static void updatePet() {
        System.out.print("Enter client name to find the pet: ");
        String clientName = scanner.nextLine();
        Client client = findClientByName(clientName);

        if (client == null) {
            System.out.println("Client not found.");
            return;
        }

        System.out.print("Enter pet name to update: ");
        String petName = scanner.nextLine();

        Pet petToUpdate = findPetByName(client, petName);

        if (petToUpdate == null) {
            System.out.println("Pet not found.");
            return;
        }

        System.out.print("Enter updated pet type (current: " + petToUpdate.getType() + "): ");
        String type = scanner.nextLine();
        petToUpdate.setType(type);

        System.out.print("Enter updated pet breed (current: " + petToUpdate.getBreed() + "): ");
        String breed = scanner.nextLine();
        petToUpdate.setBreed(breed);

        System.out.print("Enter updated pet age (current: " + petToUpdate.getAge() + "): ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        petToUpdate.setAge(age);

        System.out.print("Enter updated special instructions (current: " + petToUpdate.getSpecialInstructions() + "): ");
        String specialInstructions = scanner.nextLine();
        petToUpdate.setSpecialInstructions(specialInstructions);

        System.out.println("Pet information updated successfully.");
    }

    public static void removePet() {
        System.out.print("Enter client name to find the pet: ");
        String clientName = scanner.nextLine();
        Client client = findClientByName(clientName);

        if (client == null) {
            System.out.println("Client not found.");
            return;
        }

        System.out.print("Enter pet name to remove: ");
        String petName = scanner.nextLine();

        Pet petToRemove = findPetByName(client, petName);

        if (petToRemove == null) {
            System.out.println("Pet not found.");
            return;
        }

        client.removePet(petToRemove);
        System.out.println("Pet removed successfully.");
    }

    public static void viewPetDetails() {
        System.out.print("Enter client name to find the pet: ");
        String clientName = scanner.nextLine();
        Client client = findClientByName(clientName);

        if (client == null) {
            System.out.println("Client not found.");
            return;
        }

        System.out.print("Enter pet name to view details: ");
        String petName = scanner.nextLine();

        Pet pet = findPetByName(client, petName);

        if (pet == null) {
            System.out.println("Pet not found.");
        } else {
            System.out.println("Pet Details:");
            System.out.println("Name: " + pet.getName());
            System.out.println("Type: " + pet.getType());
            System.out.println("Breed: " + pet.getBreed());
            System.out.println("Age: " + pet.getAge());
            System.out.println("Special Instructions: " + pet.getSpecialInstructions());
        }
    }

    private static Pet findPetByName(Client client, String petName) {
        for (Pet pet : client.getPets()) {
            if (pet.getName().equalsIgnoreCase(petName)) {
                return pet;
            }
        }
        return null;
    }

    public static void bookReservations() {
        System.out.println("Booking and Reservations");
        System.out.println("1. Book a new reservation");
        System.out.println("2. Confirm reservation");
        System.out.println("3. Cancel reservation");
        System.out.print("Choose an option: ");

        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        switch (option) {
            case 1:
                bookNewReservation();
                break;
            case 2:
                confirmReservation();
                break;
            case 3:
                cancelReservation();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    public static void bookNewReservation() {
        System.out.print("Enter client name to book a reservation: ");
        String clientName = scanner.nextLine();
        Client client = findClientByName(clientName);

        if (client == null) {
            System.out.println("Client not found.");
            return;
        }

        System.out.print("Enter pet name to book reservation for: ");
        String petName = scanner.nextLine();
        Pet pet = findPetByName(client, petName);

        if (pet == null) {
            System.out.println("Pet not found.");
            return;
        }

        System.out.print("Enter start date (YYYY-MM-DD) for the reservation: ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter end date (YYYY-MM-DD) for the reservation: ");
        LocalDate endDate = LocalDate.parse(scanner.nextLine());

        Booking booking = new Booking(client, pet, startDate, endDate);
        // Optionally, you can add this booking to a list of bookings or process further.
        System.out.println("Reservation booked successfully.");
    }


    public static void confirmReservation() {
        System.out.print("Enter client name to find the reservation: ");
        String clientName = scanner.nextLine();
        Client client = findClientByName(clientName);

        if (client == null) {
            System.out.println("Client not found.");
            return;
        }

        System.out.print("Enter pet name to find the reservation: ");
        String petName = scanner.nextLine();
        Pet pet = findPetByName(client, petName);

        if (pet == null) {
            System.out.println("Pet not found.");
            return;
        }

        // Assuming you have a list of bookings, find the booking to confirm
        // For demonstration, let's assume a simple confirmation without list management
        Booking booking = findBookingByClientAndPet(client, pet);

        if (booking == null) {
            System.out.println("Reservation not found.");
            return;
        }

        booking.setConfirmed(true);
        System.out.println("Reservation confirmed successfully.");
    }


    public static void cancelReservation() {
        System.out.print("Enter client name to find the reservation: ");
        String clientName = scanner.nextLine();
        Client client = findClientByName(clientName);

        if (client == null) {
            System.out.println("Client not found.");
            return;
        }

        System.out.print("Enter pet name to find the reservation: ");
        String petName = scanner.nextLine();
        Pet pet = findPetByName(client, petName);

        if (pet == null) {
            System.out.println("Pet not found.");
            return;
        }

        // Assuming you have a list of bookings, find the booking to cancel
        // For demonstration, let's assume a simple cancellation without list management
        Booking booking = findBookingByClientAndPet(client, pet);

        if (booking == null) {
            System.out.println("Reservation not found.");
            return;
        }

        // Perform cancellation logic here, such as removing from a list
        // Example: bookings.remove(booking);
        System.out.println("Reservation canceled successfully.");
    }


    public static void manageBilling() {
        System.out.println("Billing and Payments");
        System.out.println("1. Generate bill");
        System.out.println("2. Mark payment");
        System.out.println("3. View billing details");
        System.out.print("Choose an option: ");

        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        switch (option) {
            case 1:
                generateBill();
                break;
            case 2:
                markPayment();
                break;
            case 3:
                viewBillingDetails();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    public static void generateBill() {
        System.out.print("Enter client name to generate bill: ");
        String clientName = scanner.nextLine();
        Client client = findClientByName(clientName);

        if (client == null) {
            System.out.println("Client not found.");
            return;
        }

        System.out.print("Enter pet name to generate bill for: ");
        String petName = scanner.nextLine();
        Pet pet = findPetByName(client, petName);

        if (pet == null) {
            System.out.println("Pet not found.");
            return;
        }

        // Assuming you have a list of bookings, find the booking to generate a bill
        // For demonstration, let's assume a simple bill generation without detailed logic
        Booking booking = findBookingByClientAndPet(client, pet);

        if (booking == null) {
            System.out.println("Booking not found.");
            return;
        }

        // Calculate total amount based on booking details
        double totalAmount = calculateTotalAmount(booking);

        // Generate a new billing object
        LocalDate dueDate = LocalDate.now().plusDays(30); // Example due date
        Billing bill = new Billing(booking, totalAmount, dueDate);

        // Optionally, you can add this billing to a list of bills or process further.
        System.out.println("Bill generated successfully.");
    }

    private static double calculateTotalAmount(Booking booking) {
        // Example calculation logic based on booking details
        // This can be customized based on your specific billing requirements
        // For example, calculate based on duration of stay, pet services, etc.
        return 100.0; // Placeholder value, replace with actual calculation
    }

    public static void markPayment() {
        System.out.print("Enter client name to mark payment: ");
        String clientName = scanner.nextLine();
        Client client = findClientByName(clientName);

        if (client == null) {
            System.out.println("Client not found.");
            return;
        }

        System.out.print("Enter pet name to mark payment for: ");
        String petName = scanner.nextLine();
        Pet pet = findPetByName(client, petName);

        if (pet == null) {
            System.out.println("Pet not found.");
            return;
        }

        // Assuming you have a list of bills, find the bill to mark payment
        // For demonstration, let's assume a simple payment marking without detailed logic
        Billing bill = findBillingByClientAndPet(client, pet);

        if (bill == null) {
            System.out.println("Bill not found.");
            return;
        }

        // Mark the bill as paid
        bill.setPaid(true);
        System.out.println("Payment marked successfully.");
    }


    public static void viewBillingDetails() {
        System.out.print("Enter client name to view billing details: ");
        String clientName = scanner.nextLine();
        Client client = findClientByName(clientName);

        if (client == null) {
            System.out.println("Client not found.");
            return;
        }

        System.out.print("Enter pet name to view billing details for: ");
        String petName = scanner.nextLine();
        Pet pet = findPetByName(client, petName);

        if (pet == null) {
            System.out.println("Pet not found.");
            return;
        }

        // Assuming you have a list of bills, find and display billing details
        // For demonstration, let's assume a simple display of billing details without list management
        Billing bill = findBillingByClientAndPet(client, pet);

        if (bill == null) {
            System.out.println("Billing details not found.");
            return;
        }

        // Display billing details
        System.out.println("Billing Details:");
        System.out.println("Client: " + client.getName());
        System.out.println("Pet: " + pet.getName());
        System.out.println("Total Amount: $" + bill.getTotalAmount());
        System.out.println("Due Date: " + bill.getDueDate());
        System.out.println("Paid: " + (bill.isPaid() ? "Yes" : "No"));
    }


    private static Client findClientByName(String name) {
        for (Client client : clients) {
            if (client.getName().equalsIgnoreCase(name)) {
                return client;
            }
        }
        return null;  
    }
}
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
        scanner.nextLine(); 

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
        scanner.nextLine(); 

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
        scanner.nextLine(); 
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
        System.out.println("1. Book a reservation");
        System.out.println("2. View all reservations");
        System.out.print("Choose an option: ");

        int option = scanner.nextInt();
        scanner.nextLine(); 

        switch (option) {
            case 1:
                bookReservation();
                break;
            case 2:
                viewAllReservations();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    public static void bookReservation() {
        System.out.print("Enter client name to book a reservation for: ");
        String clientName = scanner.nextLine();
        Client client = findClientByName(clientName);

        if (client == null) {
            System.out.println("Client not found.");
            return;
        }

        System.out.print("Enter pet name for the reservation: ");
        String petName = scanner.nextLine();
        Pet pet = findPetByName(client, petName);

        if (pet == null) {
            System.out.println("Pet not found.");
            return;
        }

        System.out.print("Enter check-in date (YYYY-MM-DD): ");
        LocalDate checkInDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter check-out date (YYYY-MM-DD): ");
        LocalDate checkOutDate = LocalDate.parse(scanner.nextLine());

        Booking booking = new Booking(client, pet, checkInDate, checkOutDate);
        client.addBooking(booking); // Ensure this method exists in Client class
        System.out.println("Reservation booked successfully.");
    }

    public static void viewAllReservations() {
        System.out.print("Enter client name to view reservations: ");
        String clientName = scanner.nextLine();
        Client client = findClientByName(clientName);

        if (client == null) {
            System.out.println("Client not found.");
            return;
        }

        System.out.println("Reservations for " + client.getName() + ":");
        for (Booking booking : client.getBookings()) {
            System.out.println("Pet: " + booking.getPet().getName() + ", Check-in: " + booking.getCheckInDate() + ", Check-out: " + booking.getCheckOutDate());
        }
    }

    public static void manageBilling() {
        System.out.println("Billing and Payments");
        System.out.println("1. Generate bill");
        System.out.println("2. View billing history");
        System.out.print("Choose an option: ");

        int option = scanner.nextInt();
        scanner.nextLine(); 

        switch (option) {
            case 1:
                generateBill();
                break;
            case 2:
                viewBillingHistory();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    public static void generateBill() {
        System.out.print("Enter client name to generate bill for: ");
        String clientName = scanner.nextLine();
        Client client = findClientByName(clientName);

        if (client == null) {
            System.out.println("Client not found.");
            return;
        }

        double totalAmount = 0.0;
        for (Booking booking : client.getBookings()) {
            double amount = calculateBookingAmount(booking);
            totalAmount += amount;
        }

        Billing billing = new Billing(client, totalAmount);
        client.addBilling(billing);
        System.out.println("Bill generated successfully. Total amount: $" + totalAmount);
    }

    public static double calculateBookingAmount(Booking booking) {
        long days = booking.getCheckInDate().until(booking.getCheckOutDate()).getDays();
        double dailyRate = 50.0; 
        return days * dailyRate;
    }

    public static void viewBillingHistory() {
        System.out.print("Enter client name to view billing history: ");
        String clientName = scanner.nextLine();
        Client client = findClientByName(clientName);

        if (client == null) {
            System.out.println("Client not found.");
            return;
        }

        System.out.println("Billing history for " + client.getName() + ":");
        for (Billing billing : client.getBillings()) {
            System.out.println("Date: " + billing.getDate() + ", Amount: $" + billing.getAmount());
        }
    }

    public static Client findClientByName(String name) {
        for (Client client : clients) {
            if (client.getName().equalsIgnoreCase(name)) {
                return client;
            }
        }
        return null;
    }
}

class Client {
    private String name;
    private String phoneNumber;
    private String address;
    private List<Pet> pets;
    private List<Booking> bookings;
    private List<Billing> billings;

    public Client(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.pets = new ArrayList<>();
        this.bookings = new ArrayList<>();
        this.billings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void addPet(Pet pet) {
        this.pets.add(pet);
    }

    public void removePet(Pet pet) {
        this.pets.remove(pet);
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }
    
    public List<Booking> getBookings() {
        return bookings;
    }

    public List<Billing> getBillings() {
        return billings;
    }

    public void addBilling(Billing billing) {
        this.billings.add(billing);
    }
}

class Pet {
    private String name;
    private String type;
    private String breed;
    private int age;
    private String specialInstructions;

    public Pet(String name, String type, String breed, int age, String specialInstructions) {
        this.name = name;
        this.type = type;
        this.breed = breed;
        this.age = age;
        this.specialInstructions = specialInstructions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }
}

class Booking {
    private Client client;
    private Pet pet;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public Booking(Client client, Pet pet, LocalDate checkInDate, LocalDate checkOutDate) {
        this.client = client;
        this.pet = pet;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
}

class Billing {
    private Client client;
    private double amount;
    private LocalDate date;

    public Billing(Client client, double amount) {
        this.client = client;
        this.amount = amount;
        this.date = LocalDate.now();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}


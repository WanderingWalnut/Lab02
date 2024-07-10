package com.yycpetresort;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private String phoneNumber;
    private String address;
    private List<Pet> pets; // List of pets owned by the client

    public Client(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.pets = new ArrayList<>();
    }

    // Getters and Setters
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

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    // Method to add a pet to the client's list of pets
    public void addPet(Pet pet) {
        pets.add(pet);
    }

    // Method to remove a pet from the client's list of pets
    public void removePet(Pet pet) {
        pets.remove(pet);
    }

    // Other methods as needed (e.g., toString, equals, hashCode)
}

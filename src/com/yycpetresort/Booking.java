package com.yycpetresort;

import java.time.LocalDate;

public class Booking {
    private Client client;
    private Pet pet;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isConfirmed;

    public Booking(Client client, Pet pet, LocalDate startDate, LocalDate endDate) {
        this.client = client;
        this.pet = pet;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isConfirmed = false; // Booking is initially not confirmed
    }

    // Getters and Setters
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    // Other methods as needed (e.g., toString, equals, hashCode)
}

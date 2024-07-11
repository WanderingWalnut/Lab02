package com.yycpetresort;

import java.time.LocalDate;

public class Billing {
    private Booking booking;
    private double totalAmount;
    private boolean isPaid;
    private LocalDate dueDate;

    public Billing(Booking booking, double totalAmount, LocalDate dueDate) {
        this.booking = booking;
        this.totalAmount = totalAmount;
        this.isPaid = false; // Billing is initially unpaid
        this.dueDate = dueDate;
    }

    // Getters and Setters
    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    // Other methods as needed (e.g., toString, equals, hashCode)
}

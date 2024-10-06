package com.example.booking.model;

public class Booking {
    private String id;
    private String passengerId;
    private String pickupLocation;
    private String dropoffLocation;

    // Constructors
    public Booking() {}
    
    public Booking(String id, String passengerId, String pickupLocation, String dropoffLocation) {
        this.id = id;
        this.passengerId = passengerId;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(String dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }
}

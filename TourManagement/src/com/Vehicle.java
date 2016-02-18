package com;

/**
 * Created by Araja Jyothi Babu on 18-02-2016.
 */
public class Vehicle {
    int vId;
    int noOfSeats;
    double fare;
    Customer custDetails;
    boolean availability;

    Vehicle(int vid, int seats, double fare, Customer customer, boolean availability){
        this.vId = vid;
        this.noOfSeats = seats;
        this.fare = fare;
        this.custDetails = customer;
        this.availability = availability;
    }

    boolean isAvailability(){
        return this.availability;
    }

    void setAvailability(boolean availability){
        this.availability = availability;
    }

    int getvId(){
        return this.vId;
    }

    void setvId(int id){
        this.vId = id;
    }

    int getNoOfSeats(){
        return this.noOfSeats;
    }

    void setNoOfSeats(int seats){
        this.noOfSeats = seats;
    }

    double getFare(){
        return this.fare;
    }

    void setFare(double fare){
        this.fare = fare;
    }

    Customer getCustDetails(){
        return this.custDetails;
    }

    void setCustDetails(Customer customer){
        this.custDetails = customer;
    }

    int compareTo(Vehicle vehicle){
        return (int)(this.fare - vehicle.fare);
    }
}

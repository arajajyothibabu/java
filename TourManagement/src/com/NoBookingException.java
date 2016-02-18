package com;

/**
 * Created by Araja Jyothi Babu on 18-02-2016.
 */
public class NoBookingException extends Exception{
    int noOfSeats;

    NoBookingException(int noOfSeats){
        this.noOfSeats = noOfSeats;
    }

    int getNoOfSeats(){
        return noOfSeats;
    }

    void setNoOfSeats(int noOfSeats){
        this.noOfSeats = noOfSeats;
    }

    public String getMessage(){
        return "No vehicle available for Booking..!";
    }

}

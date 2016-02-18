package com;

/**
 * Created by Araja Jyothi Babu on 18-02-2016.
 */
public interface BookingOperations {

    Vehicle makeBooking(Customer customer, int noOfSeats) throws NoBookingException;

    boolean cancelBooking(int vId);

}

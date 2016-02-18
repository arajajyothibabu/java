/**
 * 
 * DO NOT MODIFY THIS FILE
 * MODIFYING THIS FILE MAY LEAD TO ERRONEOUS OUTPUT AND HENCE DEDUCTION IN YOUR FINAL SCORE
 * 
 */


package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GreenTrip {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vehicle v1 = new Vehicle(1, 5, 1000, null, true);
		Vehicle v2 = new Vehicle(2,	6, 2000, null, true);
		Vehicle v3 = new Vehicle(3, 7, 3000, null, true);
		
		Travels t = new Travels(new ArrayList<Vehicle>());
		Travels t1 = new Travels(null);
		Travels t2 = new Travels(new ArrayList<Vehicle>());
		
		System.out.println("*****************Start Test Case 1******************");
		//Method M1 Positive
		System.out.println(t.addVehicle(v1));
		System.out.println(t.addVehicle(v2));
		System.out.println(t.addVehicle(v3));
		System.out.println("*****************End Test Case 1******************");
		
		//Method M1 Negative
		System.out.println("*****************Start Test Case 2******************");
		System.out.println(t.addVehicle(v1));
		System.out.println("*****************End Test Case 2******************");
		
		//Method M1 Negative
		System.out.println("*****************Start Test Case 3******************");
		try{
		System.out.println(t1.addVehicle(v1));
		}
		catch(Exception e)
		{
			System.out.println("Error in adding Vehicle" +e.getMessage());
		}
		System.out.println("*****************End Test Case 3******************");
		
		//Method M1 Negative
		System.out.println("*****************Start Test Case 3.1******************");
		try{
		System.out.println(t.addVehicle(null));
		}
		catch(Exception e)
		{
			System.out.println("Error in adding Vehicle" +e.getMessage());
		}
		System.out.println("*****************End Test Case 3.1******************");
		
		//Method M2 Positive
		System.out.println("*****************Start Test Case 4******************");
		Customer cust = new Customer(1001, "ABC");
		try {
			System.out.println(t.makeBooking(cust, 5).getvId());
		} catch (NoBookingException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in making booking"+e.getMessage());
		}
		try {
			System.out.println(t.makeBooking(cust, 6).getvId());
		} catch (NoBookingException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in making booking"+e.getMessage());
		}
		System.out.println("*****************End Test Case 4******************");
		
		//Method M2 Negative
		
		System.out.println("*****************Start Test Case 5******************");
		
		try {
			System.out.println(t.makeBooking(cust, 10).getvId());
		} catch (NoBookingException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in making booking"+e.getMessage());
		}
		System.out.println("*****************End Test Case 5******************");
		

		System.out.println("*****************Start Test Case 6******************");
		
		try {
			Vehicle v = t1.makeBooking(cust, 10);
			System.out.println(v);
		} catch (NoBookingException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in making booking"+e.getMessage());
		}
		System.out.println("*****************End Test Case 6******************");
		
		System.out.println("*****************Start Test Case 7******************");
		
		try {
			System.out.println(t2.makeBooking(cust, 10).getvId());
		} catch (NoBookingException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in making booking"+e.getMessage());
		}
		System.out.println("*****************End Test Case 7******************");
		
		//Method M3 Positive
		
		System.out.println("*****************Start Test Case 8******************");
		
		System.out.println(t.cancelBooking(1));
		
		System.out.println("*****************End Test Case 8******************");
		
		
		//Method M3 Negative
		
		System.out.println("*****************Start Test Case 8******************");
		
		System.out.println(t.cancelBooking(10));
		
		System.out.println("*****************End Test Case 8******************");
		
		
		System.out.println("*****************Start Test Case 9******************");
		
		System.out.println(t1.cancelBooking(10));
		
		System.out.println("*****************End Test Case 9******************");
		
		System.out.println("*****************Start Test Case 10******************");
		
		System.out.println(t2.cancelBooking(10));
		
		System.out.println("*****************End Test Case 10******************");
		
		//Method M4 Positive
		System.out.println("*****************Start Test Case 11******************");
		
		Set<Vehicle> vehSet = t.getVehicleByFare();
		for(Vehicle v: vehSet)
		{
			System.out.println(v.getFare());
		}
		
		System.out.println("*****************End Test Case 11******************");
		
		
		//Method M4 negative
		System.out.println("*****************Start Test Case 12******************");
		System.out.println(t1.getVehicleByFare());
		
		System.out.println("*****************End Test Case 12******************");
		
		System.out.println("*****************Start Test Case 13******************");
		System.out.println(t2.getVehicleByFare());
		
		System.out.println("*****************End Test Case 13******************");
		
		System.out.println("*****************Start Test Case 14******************");
		
		
		//Method M5 positive
		HashMap vehMap = (HashMap) t.getVehicleMap();
		
		 Iterator it = vehMap.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        System.out.println(pair.getKey() + " = " + ((Vehicle)pair.getValue()).getFare());
		     
		    }
		
		System.out.println("*****************End Test Case 14******************");
		
		
		//Method M5 negative
		
		System.out.println("*****************Start Test Case 15******************");
		
		System.out.println(t1.getVehicleMap());
		System.out.println("*****************End Test Case 15******************");
		
		System.out.println("*****************Start Test Case 16******************");
		
		System.out.println(t2.getVehicleMap());
		System.out.println("*****************End Test Case 16******************");
		
	}

}

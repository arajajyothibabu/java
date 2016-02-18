package com;

/**
 * Created by Araja Jyothi Babu on 18-02-2016.
 */
import java.util.*;

public class Travels implements BookingOperations{
    ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();

    ArrayList<Vehicle> getVehicleList(){
        return this.vehicleList;
    }

    void setVehicleList(ArrayList<Vehicle> vehicleList){
        this.vehicleList = vehicleList;
    }

    Travels(ArrayList<Vehicle> vehicleList){
        this.vehicleList = vehicleList;
    }

    boolean addVehicle(Vehicle vehicle){
        if(this.vehicleList.contains(vehicle)){
            return false;
        }
        else{
            this.vehicleList.add(vehicle);
            return true;
        }
    }

    public Vehicle makeBooking(Customer customer, int noOfSeats){
        Vehicle vehicle = null;
        try{
            for(int i=0;i< vehicleList.size(); i++){
                vehicle = vehicleList.get(i);
                if(vehicle.noOfSeats >= noOfSeats){
                    vehicle.availability = false;
                    return vehicle;
                }
            }
            throw new NoBookingException(noOfSeats);
        } catch(NoBookingException nbe){
            nbe.getMessage();
        }
        return vehicle;
    }

    public boolean cancelBooking(int vId){
        Vehicle vehicle;
        for(int i=0; i< vehicleList.size();i++){
            vehicle = vehicleList.get(i);
            if(vehicle.vId == vId){
                vehicle.availability = true;
                vehicle.custDetails = null;
                return true;
            }
        }
        return false;
    }

    Set<Vehicle> getVehicleByFare(){
        SortedSet<Vehicle> vehicleSet = new TreeSet<Vehicle>();
        return vehicleSet;
    }

    Map<Integer, Vehicle> getVehicleMap(){
        Map<Integer, Vehicle> vehicleMap = new HashMap<Integer, Vehicle>();
        Vehicle vehicle;
        for(int i=0;i<vehicleList.size(); i++){
            vehicle = vehicleList.get(i);
            vehicleMap.put(vehicle.vId, vehicle);
        }
        return vehicleMap;
    }
}
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
        if(this.vehicleList.contains(vehicle) || vehicle == null){
            return false;
        }
        else{
            this.vehicleList.add(vehicle);
            return true;
        }
    }

    public Vehicle makeBooking(Customer customer, int noOfSeats) throws NoBookingException{
        Vehicle vehicle = null;
        for(int i=0;i< vehicleList.size(); i++){
            vehicle = vehicleList.get(i);
            if(vehicle.noOfSeats >= noOfSeats){
                vehicle.availability = false;
                return vehicle;
            }
        }
        throw new NoBookingException(noOfSeats);
    }

    public boolean cancelBooking(int vId){
        if(vehicleList == null)
            return false;
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
        TreeSet<Vehicle> vehicleSet = new TreeSet<Vehicle>(new VehicleComparator());
        if(vehicleList != null) {
            for (Vehicle vehicle : vehicleList) {
                vehicleSet.add(vehicle);
            }
        }
        return vehicleSet;
    }

    Map<Integer, Vehicle> getVehicleMap(){
        Map<Integer, Vehicle> vehicleMap = new HashMap<Integer, Vehicle>();
        Vehicle vehicle;
        if(vehicleList != null) {
            for (int i = 0; i < vehicleList.size(); i++) {
                vehicle = vehicleList.get(i);
                vehicleMap.put(vehicle.vId, vehicle);
            }
        }
        return vehicleMap;
    }
}

class VehicleComparator implements Comparator<Vehicle>{
    @Override
    public int compare(Vehicle v1, Vehicle v2) {
        return v1.compareTo(v2);
    }
}
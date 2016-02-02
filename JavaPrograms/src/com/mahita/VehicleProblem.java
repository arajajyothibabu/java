package com.mahita;

/**
 * Created by Araja Jyothi Babu on 24-01-2016.
 */
public class VehicleProblem {
    public static void main(String args[]) throws Exception{
        Vehicle v1 = new Vehicle(123, "Verna", 150, 1200000);
        v1.vehicleDetails();
        Vehicle v2 = new Vehicle(124, "Scorpio", 250, 1600000);
        v2.vehicleDetails();
        Vehicle v3 = new Vehicle(125, "Ertiga", 350, 1100000);
        v3.vehicleDetails();
        Vehicle v4 = new Vehicle();
        v4.vehicleDetails();
        v4.setVno(126);
        v4.setVname("Audi");
        v4.setModelno(100);
        v4.setPrice(5500000);
        v4.vehicleDetails();
        Vehicle[] vehicles = {v1, v2, v3, v4};
        System.out.println("Cost of 4 cars for Siddharta College is : " + priceOfFourVehicles(vehicles));
    }
    static int priceOfFourVehicles(Vehicle[] vehicles){
        int cost = 0;
        for(int i=0;i<vehicles.length;i++){
            cost += vehicles[0].price;
        }
        return cost;
    }
}

class Vehicle{
    int vno;
    String vname;
    int modelno;
    int price;
    Vehicle(){ //default constructor
        this.vno = 100;
        this.vname= "SomeName";
        this.modelno = 123;
        this.price = 25600;
    }
    Vehicle(int vno, String vname, int modelno, int price){ //parameterised constructor
        this.vno = vno;
        this.vname= vname;
        this.modelno = modelno;
        this.price = price;
    }
    void setVno(int vno){
        this.vno = vno;
    }
    void setVname(String vname){
        this.vname = vname;
    }
    void setModelno(int modelno){
        this.modelno = modelno;
    }
    void setPrice(int price){
        this.price = price;
    }
    void vehicleDetails(){
        System.out.println("Vehicle Details: ");
        System.out.println("Vno:" + this.vno);
        System.out.println("Name:" + this.vname);
        System.out.println("ModelNo:" + this.modelno);
        System.out.println("Price:" + this.price);
        System.out.println("************************************");
    }
}

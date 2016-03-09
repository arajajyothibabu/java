package tcs.assignment2.find_car_with_max_mileage;

/**
 * Created by Araja Jyothi Babu on 08-Mar-16.
 */
public class Car {
    private int regNo;
    private double mileage;
    private int capacity;

    public Car(int regNo, double mileage, int capacity) {
        this.regNo = regNo;
        this.mileage = mileage;
        this.capacity = capacity;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

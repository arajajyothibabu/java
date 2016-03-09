package tcs.assignment2.find_car_with_max_mileage;

/**
 * Created by Araja Jyothi Babu on 08-Mar-16.
 */
public class CarDemo {
    public static Car findCarWithHighestMileage(Car[] cars) {
        Car carWithHighestMileage = null; //initializing return Car
        if(cars != null && cars.length > 0){
            double highestMileage = 0;
            for(Car car : cars)
                if(car.getMileage() > highestMileage){
                    highestMileage = car.getMileage();
                    carWithHighestMileage = car;
                }
        }
        return carWithHighestMileage;
    }

    public static void main(String args[]) throws Exception {
        Car car1 = new Car(556, 26.5, 4);
        Car car2 = new Car(557, 20.5, 6);
        Car car3 = new Car(558, 18.5, 4);
        Car car4 = new Car(559, 23.0, 6);
        Car car5 = new Car(560, 16.5, 8);
        Car[] cars = {car1, car2, car3, car4, car5};

        System.out.println("Car with Highest Mileage: " + findCarWithHighestMileage(cars).getRegNo());
    }
}

package tcs.assignment4.Interface.com;

/**
 * Created by Araja Jyothi Babu on 06-Mar-16.
 */
public class Square implements Shape {

    public double getArea(double side) {
        if(side > 0)
            return side * side;
        else
            return 0;
    }

}

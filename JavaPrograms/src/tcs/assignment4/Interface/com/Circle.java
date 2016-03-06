package tcs.assignment4.Interface.com;

/**
 * Created by Araja Jyothi Babu on 06-Mar-16.
 */
public class Circle implements Shape {

    public double getArea(double radius){
        if(radius > 0)
            return 3.14 * radius * radius;
        else
            return 0;
    }

}

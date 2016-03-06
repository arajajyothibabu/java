package tcs.assignment4.Interface.com;

/**
 * Created by Araja Jyothi Babu on 06-Mar-16.
 */
public class TestCircle {

    public static void main(String args[]) throws Exception {

        Circle circle = new Circle();
        System.out.println(calculateArea(circle, 5));

    }

    public static double calculateArea(Shape shape, double metric){
        return shape.getArea(metric);
    }

}

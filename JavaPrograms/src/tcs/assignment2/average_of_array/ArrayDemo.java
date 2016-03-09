package tcs.assignment2.average_of_array;

/**
 * Created by Araja Jyothi Babu on 07-Mar-16.
 */
public class ArrayDemo {

    public static double findAverage(int[] arr) {
        double sum = 0;
        for(int number : arr)
            sum += number;
        return sum / arr.length;
    }

    public static void main(String args[]) throws Exception {
        int[] input = {1,2,3,4,5,6,7,8};
        System.out.println("Average: " + findAverage(input));
    }

}

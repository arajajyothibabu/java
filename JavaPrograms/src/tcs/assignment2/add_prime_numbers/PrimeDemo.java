package tcs.assignment2.add_prime_numbers;

/**
 * Created by Araja Jyothi Babu on 07-Mar-16.
 */
public class PrimeDemo {

    public static double addPrimeNumbers(int[] numbers) {
        double sum = 0;
        for(int i=0; i<numbers.length; i++)
            if(isPrime(numbers[i]))
                sum += numbers[i];
        return sum;
    }

    public static boolean isPrime(int number) {
        if(number <= 2)
            return false;
        for(int i = 2; i <= number / 2; i++)
            if(number % i == 0)
                return false;
        return true;
    }

    public static void main(String args[]) throws Exception {
        PrimeDemo primeDemo = new PrimeDemo();
        int[] input = {1,2,3,4,5,6,7,8,9,10,12};
        System.out.println(primeDemo.addPrimeNumbers(input));
    }

}

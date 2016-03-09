package tcs.assignment2.find_even_numbers;

/**
 * Created by Araja Jyothi Babu on 08-Mar-16.
 */
public class EvenDemo {
    public static int[] findEvenValues(int[] inputArray) {
        int[] intermediateArray = new int[inputArray.length];
        int evenCount = 0;
        for(int i = 0; i < inputArray.length; i++)
            if(inputArray[i] % 2 == 0)
                intermediateArray[evenCount++] = inputArray[i];
        int[] outputArray = new int[evenCount];
        for(int i = 0; i < evenCount; i++)
            outputArray[i] = intermediateArray[i];
        return outputArray;
    }

    public static void main(String args[]) throws Exception {
        int[] input = {22, 11, 9, 20, 13};
        int[] output = findEvenValues(input);
        for(int i = 0; i < output.length; i++)
            System.out.print(output[i] +"\t");
    }
}

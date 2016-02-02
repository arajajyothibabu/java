package com.mahita;

import java.util.Scanner;

/**
 * Created by Araja Jyothi Babu on 24-01-2016.
 */
public class ArraySum {
    int sum(int []arr){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }
        return sum;
    }
    public static void main(String args[]) throws Exception{
        Scanner in = new Scanner(System.in);
        ArraySum obj = new ArraySum();
        int []arr = new int[10];
        System.out.println("Enter array of integers to get Sum: ");
        for(int i=0;i<arr.length;i++){
            arr[i] = in.nextInt();
        }
        System.out.println("Sum of Array Elements: " + obj.sum(arr));
    }
}

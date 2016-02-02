package com.mahita;
import java.util.Scanner;
/**
 * Created by Araja Jyothi Babu on 24-01-2016.
 */
public class Overloading {
    int sum(int a, int b, int c){
        return a + b + c;
    }
    String sum(String s1, String s2){
        return s1 + s2;
    }
    public static void main(String args[]) throws Exception{
        Scanner in = new Scanner(System.in);
        Overloading obj = new Overloading();
        System.out.println("Enter 3 integers to get Sum: ");
        int a,b,c;
        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();
        System.out.println("Sum: " + obj.sum(a,b,c));
        System.out.println("Enter 2 strings to get Concatinated String: ");
        String s1, s2;
        s1 = in.next();
        s2 = in.next();
        System.out.println("Concatinared String: " + obj.sum(s1, s2));
    }
}

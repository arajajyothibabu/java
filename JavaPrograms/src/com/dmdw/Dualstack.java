package com.dmdw;
import java.io.*;
import java.util.*;
class Dualstack
{
    public static int stack[] = new int[100];
    public static int size, top, bottom, value;
    public static Scanner in = new Scanner(System.in);
    Dualstack()
    {
        top = -1;
        bottom = size;
    }
    public static void overflow()
    {
        System.out.println("Stack Overflow..!");
    }
    public static void underflow()
    {
        System.out.println("Stack Underflow..!");
    }
    public static void pushTop()
    {
        if(bottom-top == 1)
            overflow();
        else
        {
            System.out.print("Enter Value: ");
            value = in.nextInt();
            stack[++top] = value;
        }
    }
    public static void pushBottom()
    {
        if(bottom - top == 1)
            overflow();
        else
        {
            System.out.println("Enter Value: ");
            value = in.nextInt();
            stack[--bottom] = value;
        }
    }
    public static void popTop()
    {
        if(top == -1)
            underflow();
        else System.out.println("Popped Value: "+stack[top--]);
    }
    public static void popBottom()
    {
        if(bottom == size)
            underflow();
        else System.out.println("Popped Value: "+stack[bottom++]);
    }
    public static void display()
    {
        System.out.print("Elements from top: ");
        for(int i=0;i<=top;i++)
            System.out.print("\t"+stack[i]);
        System.out.println();
        System.out.print("Elements from bottom: ");
        for(int i=bottom;i<size;i++)
            System.out.print("\t"+stack[i]);
    }
    public static void main(String args[]) throws IOException
    {
        int option;
        System.out.println("Enter size of Stack: ");
        size = in.nextInt();
        Dualstack d = new Dualstack();
        while(true)
        {
            System.out.println("\nMENU:\t\t1.PushTop\t2.PopTop\t3.Display\n\t\t4.PushBottom\t5.PopBottom\t0.Exit");
            option = in.nextInt();
            switch(option)
            {
                case 1:d.pushTop();break;
                case 2:d.popTop();break;
                case 3:d.display();break;
                case 4:d.pushBottom();break;
                case 5:d.popBottom();break;
                case 0:System.exit(0);
                default:System.out.println("Invalid Entry..!");
            }
        }
    }
}
package com.mahita;

import java.util.Scanner;

/**
 * Created by Araja Jyothi Babu on 24-01-2016.
 */
public class StackProblem {
    public static void main(String args[]) throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Size of Stack: ");
        int capacity = in.nextInt();
        Stack stack = new Stack(capacity);
        while(true){
            System.out.print("\nMenu:\t 1. Push \t 2. Pop \t 3. Display \t 0. Exit : ");
            switch(in.nextInt()){
                case 1:System.out.print("Enter Element : ");
                        stack.push(in.nextInt());
                        break;
                case 2: stack.pop();
                        break;
                case 3: stack.display();
                        break;
                case 0: System.exit(0);
                default: System.out.println("Invalid option. Try agian..!");
            }
        }
    }
}

class Stack{
    static int topOfStack;
    static int capacity = 0; //stack capacity
    int []stack;
    Stack(int capacity){
        this.capacity = capacity;
        this.stack = new int[capacity];
        topOfStack = -1;
    }
    static boolean isFull(){
        return (topOfStack == capacity-1);
    }
    static boolean isEmpty(){
        return (topOfStack == -1);
    }
    void push(int element){
        if(!isFull())
            this.stack[++topOfStack] = element;
        else
            System.out.println("Stack overflow..!");
    }
    void pop(){
        if(!isEmpty())
            System.out.println("Element popped is : " + this.stack[topOfStack--]);
        else
            System.out.println("Stack underflow..!");
    }
    void display(){
        if(isEmpty())
            System.out.println("Stack is Empty..!");
        else
            System.out.println("Stack Elements : ");
        for(int i=0;i<=topOfStack;i++){
            System.out.print("\t" + this.stack[i]);
        }
    }
}

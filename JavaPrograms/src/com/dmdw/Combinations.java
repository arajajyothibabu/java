package com.dmdw;

import java.io.*;
import java.util.*;
class Combinations
{
    Combinations()
    {
        //
    }
    public static int len(char arr[])
    {
        int i=0;
        for(;arr[i]!='\0';i++);
        return i;
    }
    public static int pow(int a,int b)
    {
        int mul=1;
        for(;b>0;b--)
            mul *= a;
        return mul;
    }
    public static char []Bin(int n,int length)
    {
        char []tempArr = new char[length], ch;
        int index = 0;
        while(n!=0)
        {
            tempArr[--length] = (char)(n%2+48);
            n /= 2;
        }
        return tempArr;
    }
    public char[][] combinations(char arr[])
    {
        char []binary = new char[arr.length];
        int range = pow(2,arr.length),index = 0;
        char[][] output = new char[range-1][20];
        for(int i=1;i<=range-1;i++)
        {
            binary = Bin(i,arr.length);
            for(int j=0;j<arr.length;j++)
            {
                if(binary[j] == '1')
                    output[i-1][index++] = arr[j];
            }
            output[i-1][index] = '\0';
            System.out.println(output[i-1]);
            System.out.println(len(output[i-1]));
            index = 0;
        }
        return output;
    }
    public static void main(String args[]) throws IOException
    {
        Combinations c = new Combinations();
        char arr[] = {'a','b','c','d'};
        c.combinations(arr);
    }
}
package com.dmdw;

import java.io.*;
import java.util.*;
public class Binning
{
    Binning()
    {
        //initialization
    }
    static int abs(int n)
    {
        return n>0?n:-n;
    }
    static boolean isBinnable(int length,int binSize)
    {
        if(length == 0 || binSize == 0)
            return false;
        if(length % binSize == 0)
            return true;
        else return false;
    }
    static int boundaryValue(int left,int value,int right)
    {
        if(abs(value-left)>abs(value-right))
            return right;
        else return left;
    }
    static int[][] equalSizeBins(int[]arr, int binSize)
    {
        int [][]tempArr = new int[arr.length/binSize][binSize];
        int j=-1;
        for(int i=0;i<arr.length;i++)
        {
            if(i%binSize == 0)
                j++;
            tempArr[j][i%binSize] = arr[i];
        }
        return tempArr;
    }
    int[][] binMeans(int[]arr, int binSize)
    {
        int [][]tempArr = new int[arr.length/binSize][binSize];
        int j, k, tempSum = 0, index=0;
        for(int i=0;i<arr.length/binSize;i++)
        {
            for(j=0;j < binSize;j++)
                tempSum += arr[index++];
            for(k=0;k<binSize;k++)
                tempArr[i][k] = tempSum/binSize;
            tempSum = 0;
        }
        return tempArr;
    }
    int[][] binBoundaries(int[]arr, int binSize)
    {
        int [][]tempArr = new int[arr.length/binSize][binSize];
        tempArr = equalSizeBins(arr,binSize);
        for(int i=0;i<tempArr.length;i++)
            for(int j=1;j<binSize-1;j++)
                tempArr[i][j] = boundaryValue(tempArr[i][0],tempArr[i][j],tempArr[i][binSize-1]);
        return tempArr;
    }
    public static void main(String args[]) throws IOException
    {
        int binSize = 0, arraySize = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Array Size: ");
        arraySize = in.nextInt();
        int[]arr = new int[arraySize];
        System.out.println("Enter Array: ");
        for(int i=0;i<arr.length;i++)
            arr[i] = in.nextInt();
        while(true)
        {
            System.out.println("Enter Bin Size");
            binSize = in.nextInt();
            if(isBinnable(arr.length,binSize))
                break;
            else System.out.println("************Invalid Bin Size..!*************");
        }
        int [][]equalArr = new int[arr.length/binSize][binSize];
        int [][]meanArr = new int[arr.length/binSize][binSize];
        int [][]boundaryArr = new int[arr.length/binSize][binSize];
        Binning b = new Binning();
        equalArr = b.equalSizeBins(arr,binSize);
        meanArr = b.binMeans(arr,binSize);
        boundaryArr = b.binBoundaries(arr,binSize);
        System.out.println("\nEqual Size Bins-->Bin Means-->Bin Boundaries");
        for(int i=0;i<arr.length/binSize;i++)
        {
            for(int j=0;j<binSize;j++)
                System.out.print(equalArr[i][j]+"  ");
            System.out.print("|  ");
            for(int j=0;j<binSize;j++)
                System.out.print(meanArr[i][j]+"  ");
            System.out.print("|  ");
            for(int j=0;j<binSize;j++)
                System.out.print(boundaryArr[i][j]+"  ");
            System.out.print("\n\n");
        }
    }
}
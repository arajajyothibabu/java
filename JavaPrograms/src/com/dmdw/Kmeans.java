package com.dmdw;

import java.io.*;
import java.util.*;
class Kmeans
{
    static Scanner in = new Scanner(System.in);
    static int abs(int n)
    {
        return n>0?n:-n;
    }
    static void display(int cluster[][])
    {
        for(int i=0;i<cluster.length;i++)
        {
            System.out.print(">> Mean:\t" + cluster[i][0] + "\n\t\t:" );
            for(int j=2;cluster[i][j] < cluster[i][1];j++)
                System.out.print(cluster[i][j]+" ");
            System.out.println();
        }
    }
    int [][] clustering(int arr[],int k)
    {
        int cluster[][] = new int[k][20];
        int row = 0, i = 0,j=0,tempSum = 0,length=1,mean = 0;
        while(i<arr.length)
        {
            tempSum = 0;
            for(j=2;j<arr.length/k+2 && i < arr.length;j++)
                tempSum += cluster[row][j] = arr[i++]; //sum of cluster elements and assigning elements to cluster
            row++;
            if(row == k)
                for(j=arr.length/k+2;i < arr.length;j++)
                    tempSum += cluster[row-1][j] = arr[i++];
            cluster[row-1][mean] = tempSum/(j-2);
            cluster[row-1][length] = j;
        }
        display(cluster);
        return cluster;
    }
    int [][]addElement(int cluster[][])
    {
        int element = 0,difference=0,index = 0;
        System.out.print("Enter Element: ");
        element = in.nextInt();
        difference = abs(element-cluster[0][0]); //taking first cluster as appropriate cluster to add element
        for(int i=0;i<cluster.length;i++)
            if(difference >= abs(element-cluster[i][0]))
            {
                difference = abs(element-cluster[i][0]);
                index = i; //index of appropriate cluster in group of clusters
            }
        cluster[index][cluster[index][1]] = element; //appending to related cluster
        cluster[index][1]++; //incrementing cluster length
        cluster[index][0] = (cluster[index][0]+element)/2; //updating cluster mean value
        return cluster;
    }
    
    public static void main(String args[]) throws IOException
    {
        Kmeans km = new Kmeans();
        int size = 0,k = 0;
        System.out.print("Size of Array: ");
        size = in.nextInt();
        int arr[] = new int[size];
        System.out.print("Enter Array: ");
        for(int i=0;i<size;i++)
            arr[i] = in.nextInt();
        System.out.print("No: of Clusters: ");
        k = in.nextInt();
        int Cluster[][] = new int[k][20];
        Cluster = km.clustering(arr,k);
        while(true)
        {
            int choice = 0;
            System.out.print("\nEnter Choice: \t1. Add Element\t2. Display\t0. Exit\t:");
            switch(choice = in.nextInt())
            {
                case 1:Cluster = km.addElement(Cluster);break;
                case 2:display(Cluster);break;
                case 0:System.exit(0);break;
                default:System.out.println("Invalid Choice..!");
            }
        }
    }
}
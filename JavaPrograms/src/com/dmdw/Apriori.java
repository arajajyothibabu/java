package com.dmdw;
import java.io.*;
import java.sql.*;
import java.util.*;
public class Apriori
{
    static int minSupportCount,numberOfItems;
    Apriori(int items)
    {
        minSupportCount = 2;
        numberOfItems = items;
    }
    public static int pow(int a,int b)
    {
        int mul=1;
        for(;b>0;b--)
            mul *= a;
        return mul;
    }
    public static int len(char arr[])
    {
        int i=0;
        for(;arr[i]!='\0';i++);
        return i;
    }
    public static char []Bin(int n,int length)
    {
        char []tempArr = new char[length];
        while(n>0)
        {
            tempArr[--length] = (char)(n%2+48);
            n /= 2;
        }
        return tempArr;
    }
    public static char[][] combinations(char arr[])
    {
        char []binary = new char[arr.length];
        int range = pow(2,arr.length),index = 0;
        char[][] output = new char[range-1][arr.length];
        for(int i=1;i<range;i++)
        {
            binary = Bin(i,arr.length);
            for(int j=0;j<arr.length;j++)
            {
                if(binary[j] == '1')
                    output[i-1][index++] = arr[j];
            }
            output[i-1][index] = '\0';
            index = 0;
        }
        return output;
    }
    static void generateItemSets()
    {
        char []ListOfItems = new char[numberOfItems];
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        StringBuffer format = new StringBuffer("");
        int N = 1;
        for(int number = 1;number <= numberOfItems;number++)
            ListOfItems[number-1] = (char)(number+48); //converting items into chars
        char[][] Combinations = combinations(ListOfItems); //storing all combinations
        HashMap<String,Integer> candidateNItemSet = new HashMap<String,Integer>();
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:jbdb","system","tiger");
            st = con.createStatement();
            while(true)
            {
                for(int i=0;i<Combinations.length;i++)
                {
                    if(len(Combinations[i]) == N)
                    {
                        for(int index=0;index<N;index++)
                        {
                            format.append("%"+String.valueOf(Combinations[i][index]));
                        }
                        rs = st.executeQuery("select count(*) from app where list like '%"+format+"%'");
                        if(rs.next())
                        {
                            candidateNItemSet.put(String.valueOf(Combinations[i]),rs.getInt(1));
                        }
                        format.setLength(0); //free format buffer
                    }
                }
                if(candidateNItemSet.size() == 0)
                    break;
                System.out.println("Candidte-"+N+"-ItemSet");
                for(Map.Entry me : candidateNItemSet.entrySet())
                {               
                    System.out.println(">>"+me.getKey()+"\t"+me.getValue());
                }
                System.out.println("Frequent-"+N+"-ItemSet");
                for(Map.Entry me : candidateNItemSet.entrySet())
                {   
                    if((Integer)me.getValue() >= minSupportCount)            
                        System.out.println(">>"+me.getKey()+"\t"+me.getValue());
                }
                candidateNItemSet.clear();
                System.out.println("*************************************************");
                N++; //incrementing N-candidateSet
            }
        }
        catch(Exception e)
        {
            System.out.println("Error: "+ e);
        }   
    }
    public static void main(String args[]) throws IOException
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of Items in List: ");
        numberOfItems = in.nextInt();
        Apriori a = new Apriori(numberOfItems);
        a.generateItemSets();
    }
}
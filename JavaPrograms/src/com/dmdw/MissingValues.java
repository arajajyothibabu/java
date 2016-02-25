package com.dmdw;

import java.io.*;
import java.sql.*;
import java.util.*;
public class MissingValues
{
    static int GlobalConstant = 1000;
    static Connection con = null;
    static Statement st = null;
    static  ResultSet rs = null;
    static Statement fill = null;
    static Scanner in = new Scanner(System.in);
    MissingValues()
    {
        
    }
    static void globalConstant()
    {
       try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:jbdb","system","tiger");
            fill = con.createStatement();
            fill.executeUpdate("UPDATE employ set sal = " + GlobalConstant + " where sal IS NULL");
            //fill.executeUpdate("UPDATE employ set sal = COALESCE(sal," + GlobalConstant + ")");
            //System.out.println("Entered..!");
            st = con.createStatement();
            rs = st.executeQuery("select * from employ");
            System.out.println("Sno\tName\tSalary\tGPF\tGrade");
            while(rs.next())
            {
                System.out.println(">>"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
            }
        }catch(Exception e)
        {
            System.out.println("Error: "+ e);
        }    
    }
    static void attributeMean()
    {
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:jbdb","system","tiger");
            Statement meanQuery = con.createStatement();
            ResultSet mean = meanQuery.executeQuery("select AVG(sal) from employ where sal IS NOT NULL");
            if(mean.next())
            {
                fill = con.createStatement();
                fill.executeUpdate("UPDATE employ set sal = COALESCE(sal,"+mean.getInt(1)+")");
            }
            /*fill = con.createStatement();
            fill.executeUpdate("UPDATE employ set sal = COALESCE(sal,AVG(sal))");*/
            st = con.createStatement();
            rs = st.executeQuery("select * from employ");
            System.out.println("Sno\tName\tSalary\tGPF\tGrade");
            while(rs.next())
            {               System.out.println(">>"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
            }
        }
        catch(Exception e)
        {
            System.out.println("Error: "+ e);
        }   
    }
    static void specificAttributeMean()
    {
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:jbdb","system","tiger");
            fill = con.createStatement();
            fill.executeUpdate("UPDATE employ a set sal = (select AVG(sal) from employ where sal IS NOT NULL and grade = (select grade from employ b where sal IS NULL and a.grade=b.grade and ROWNUM <= 1)) where sal IS NULL");
            st = con.createStatement();
            rs = st.executeQuery("select * from employ");
            System.out.println(">>Sno\tName\tSalary\tGPF\tGrade");
            while(rs.next())
            {                System.out.println(">>"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
            }
        }
        catch(Exception e)
        {
            System.out.println("Error: "+ e);
        }
    }
    static void probableValue()
    {
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:jbdb","system","tiger");
            Statement freqQuery = con.createStatement();
            ResultSet freq = freqQuery.executeQuery("select sal,count(*) as total from employ group by sal order by total desc");
            if(freq.next())
            {
                fill = con.createStatement();
                fill.executeUpdate("UPDATE employ set sal = COALESCE(sal,"+freq.getInt(1)+")");
            }
            st = con.createStatement();
            rs = st.executeQuery("select * from employ");
            System.out.println(">>Sno\tName\tSalary\tGPF\tGrade");
            while(rs.next())
            {                System.out.println(">>"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
            }
        }
        catch(Exception e)
        {
            System.out.println("Error: "+ e);
        }
    }
    public static void main(String args[]) throws IOException
    {
        MissingValues mv = new MissingValues();
        while(true)
        {
            System.out.println("Menu : \t1. Global Constant\t2. AtrributeMean\n\t3. Specific AttributeMean\t4. Most ProbableValue\n\t\t\t0. Exit");
            switch(in.nextInt())
            {
                case 1:mv.globalConstant();break;
                case 2:mv.attributeMean();break;
                case 3:mv.specificAttributeMean();break;
                case 4:mv.probableValue();break;
                case 0:System.exit(0);
                default:System.out.println("Invalid Option..!");
            }
        }
    }
}
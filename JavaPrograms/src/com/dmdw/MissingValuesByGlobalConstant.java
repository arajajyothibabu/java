package com.dmdw;

import java.io.*;
import java.sql.*;
public class MissingValuesByGlobalConstant
{
    int GlobalConstant;
    MissingValuesByGlobalConstant()
    {
        GlobalConstant = 4000;
    }
    void fillWithGlobalConstant()
    {
        Connection con = null;
        Statement fill = null;
        Statement st = null;
        ResultSet rs = null;
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
        MissingValuesByGlobalConstant mvgc = new MissingValuesByGlobalConstant();
        mvgc.fillWithGlobalConstant();
    }
}
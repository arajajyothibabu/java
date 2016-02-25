package com.dmdw;

import java.io.*;
import java.sql.*;
public class MissingValuesByMostProbableValue
{
    MissingValuesByMostProbableValue()
    {
        //nothing here
    }
    void fillWithMostProbableValue()
    {
        Connection con = null;
        Statement fill = null;
        Statement st = null;
        ResultSet rs = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:jbdb","system","tiger");
            Statement freqQuery = con.createStatement();
            ResultSet freq = freqQuery.executeQuery("select sal,count(*) as total from employ where sal IS NOT NULL group by sal order by total desc");
            if(freq.next())
            {
                fill = con.createStatement();
                fill.executeUpdate("UPDATE employ set sal = "+freq.getInt(1)+" where sal is NULL");
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
        MissingValuesByMostProbableValue mvgc = new MissingValuesByMostProbableValue();
        mvgc.fillWithMostProbableValue();
    }
}
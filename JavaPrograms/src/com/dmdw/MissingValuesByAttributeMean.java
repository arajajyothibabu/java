package com.dmdw;
import java.io.*;
import java.sql.*;
public class MissingValuesByAttributeMean
{ 
    MissingValuesByAttributeMean()
    {
        //nothing here
    }
    void fillWithAttributeMean()
    {
        Connection con = null;
        Statement fill = null;
        Statement st = null;
        ResultSet rs = null;
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
    public static void main(String args[]) throws IOException
    {
        MissingValuesByAttributeMean mvam = new MissingValuesByAttributeMean();
        mvam.fillWithAttributeMean();
    }
}
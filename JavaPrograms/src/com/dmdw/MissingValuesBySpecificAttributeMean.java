package com.dmdw;

import java.io.*;
import java.sql.*;
public class MissingValuesBySpecificAttributeMean
{
    void fillWithSpecificAttributeMean()
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
    public static void main(String args[]) throws IOException
    {
        MissingValuesBySpecificAttributeMean mvgc = new MissingValuesBySpecificAttributeMean();
        mvgc.fillWithSpecificAttributeMean();
    }
}
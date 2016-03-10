package tcs.IM_Diagnostics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Araja Jyothi Babu on 10-Mar-16.
 */
public class ClaimManagementDAO {

    public static void getEmployeeDetails(){
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:jbdb","username","passoword");
            st = con.createStatement();
            rs = st.executeQuery("SELECT * from TBL_Employee_CT20141173457");
            System.out.println("Employee Id\tName\tDesignation\tAge");
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
            }
        }catch(Exception e)
        {
            System.out.println("Error: "+ e);
        }
    }

    public static void main(String args[]) throws Exception {
        getEmployeeDetails();
    }

}

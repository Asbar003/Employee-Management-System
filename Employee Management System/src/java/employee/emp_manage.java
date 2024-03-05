package employee;

import java.sql.*;

public class emp_manage {
    Connection c;
    Statement s;

    public emp_manage(){
        try{
           Class.forName("com.mysql.cj.jdbc.Driver"); 
           c=DriverManager.getConnection("jdbc:mysql:///employee_management","root","A2106@2003r");
           s=c.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
package ASimulatorSystem;

import java.sql.*;  

public class Conn{
    Connection c;
    Statement s;
    public Conn(){  
        try{
//           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/softablitz", "root", "naman@mysql123");
//            jdbc:mysql://localhost:3306/?user=root
            Class.forName("com.mysql.jdbc.Driver");
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","naman@mysql123");
            s =c.createStatement(); 
           
          
            
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  
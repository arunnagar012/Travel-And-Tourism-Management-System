/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;
import java.sql.*;
/**
 *
 * @author Arun Nagar
 */
public class Conn {
    Connection c;
    Statement s;
    Conn() {
        try {
              Class.forName("com.mysql.cj.jdbc.Driver");
              c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tms" , "root" , "arun012");
              s = c.createStatement();
        }
        catch(Exception e) {
           e.printStackTrace();
        }
    }
}

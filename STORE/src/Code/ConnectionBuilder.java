/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PT
 */
public class ConnectionBuilder {
    public static Connection connect() throws ClassNotFoundException, SQLException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Store","app","app");
        return conn;
    }
}
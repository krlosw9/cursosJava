package org.example.platzi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static String url = "jdbc:mysql://localhost:3306/project";
    private static String user = "krlos";
    private static String pass = "//654321";
    private static Connection myConn;

    public static Connection getInstance() throws SQLException{
        if (myConn == null) {
            myConn = DriverManager.getConnection(url, user, pass);
        }
        return myConn;
    }
}

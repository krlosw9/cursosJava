package org.example.platzi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection myConn = null;
        Statement myStamt = null;
        ResultSet myRes = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "krlos", "//654321");
            myStamt = myConn.createStatement();
            myRes = myStamt.executeQuery("SELECT * FROM employees");

            while (myRes.next()) {
                System.out.println(myRes.getString("first_name"));
            }
        } catch (Exception e) {
            System.out.println("Algo salio mal...");
            e.printStackTrace();
        } finally {
            try {
                if (myConn != null) {
                    myConn.close();
                }
                if (myStamt != null) {
                    myStamt.close();
                }
                if (myRes != null) {
                    myRes.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
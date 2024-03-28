package org.example.platzi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.example.platzi.util.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        try (Connection myConn = DatabaseConnection.getInstance();
            Statement myStamt = myConn.createStatement();
            ResultSet myRes = myStamt.executeQuery("SELECT * FROM employees");) {

            while (myRes.next()) {
                System.out.println(myRes.getString("first_name"));
            }
        } catch (Exception e) {
            System.out.println("Algo salio mal...");
            e.printStackTrace();
        }
    }
}
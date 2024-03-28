package org.example.platzi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/project";
        String user = "krlos";
        String pass = "//654321";
        try (Connection myConn = DriverManager.getConnection(url, user, pass);
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
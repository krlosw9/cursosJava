package org.example.platzi;

import java.sql.Connection;

import org.example.platzi.model.Employee;
import org.example.platzi.repository.EmployeeRepository;
import org.example.platzi.repository.Repository;
import org.example.platzi.util.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        try (Connection myConn = DatabaseConnection.getInstance();) {
            Repository<Employee> repository = new EmployeeRepository();

            repository.findAll().forEach(System.out::println);
            System.out.println("\n"+repository.getById(1));;
        } catch (Exception e) {
            System.out.println("Algo salio mal...");
            e.printStackTrace();
        }
    }
}
package org.example.platzi;

// import java.sql.Connection;
import java.sql.SQLException;

import org.example.platzi.model.Employee;
import org.example.platzi.repository.EmployeeRepository;
import org.example.platzi.repository.Repository;
// import org.example.platzi.util.DatabaseConnection;
// import org.example.platzi.view.SwingApp;

public class Main {
    public static void main(String[] args) throws SQLException {
        // try (Connection myConn = DatabaseConnection.getInstance();) {
            // Repository<Employee> repository = new EmployeeRepository();

            // repository.findAll().forEach(System.out::println);
            // System.out.println("\n"+repository.getById(1));;
            // Employee employee = new Employee();
            // employee.setId(7);
            // employee.setFirst_name("Diego2");
            // employee.setPa_surname("Pimental2");
            // employee.setMa_surname("Gutierrez");
            // employee.setEmail("diego@example.com");
            // employee.setSalary((float)20000);
            // repository.save(employee);
            // System.out.println("-------Luego de insertar-------");
            // System.out.println("-------Luego de eliminar-------");
            // repository.delete(7);
            // repository.findAll().forEach(System.out::println);

            // SwingApp app = new SwingApp();
            // app.setVisible(true);

        // } catch (Exception e) {
        //     System.out.println("Algo salio mal...");
        //     e.printStackTrace();
        // }
        // try (Connection myConn = DatabaseConnection.getInstance();) {
        //     if (myConn.getAutoCommit()) {
        //         myConn.setAutoCommit(false);
        //     }
        //     try {
        //         Repository<Employee> repository = new EmployeeRepository(myConn);
        //         System.out.println("-----Insertar un nuevo cliente-----");
                
        //         /* Se crea un empleado con un curp para luego crear otro empleado con el mismo curp y generar rollback(curp unico)
        //         Employee employee = new Employee();
        //         employee.setFirst_name("America");
        //         employee.setPa_surname("Lopez");
        //         employee.setMa_surname("Villa");
        //         employee.setEmail("america@example.com");
        //         employee.setSalary((float)39000);
        //         employee.setCurp("AMEC24545412DFUY51");
        //         repository.save(employee);
        //         */
        //         Employee employee = new Employee();
        //         employee.setFirst_name("David");
        //         employee.setPa_surname("Gutierrez");
        //         employee.setMa_surname("olvera");
        //         employee.setEmail("david@example.com");
        //         employee.setSalary((float)32000);
        //         employee.setCurp("AMEC24545412DFUY51");
        //         repository.save(employee);

        //         myConn.commit();

        //     } catch (Exception e) {
        //         myConn.rollback();
        //         e.printStackTrace();
        //     }
        // } catch (Exception e) {
        //     System.out.println("Algo salio mal...");
        //     e.printStackTrace();
        // }
        System.out.println("----Listando Empleados----");
        Repository<Employee> repository = new EmployeeRepository();
        repository.findAll().forEach(System.out::println);

        System.out.println("----Buscando por id----");
        System.out.println(repository.getById(2));
    }
}
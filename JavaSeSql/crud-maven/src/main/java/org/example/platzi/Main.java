package org.example.platzi;

// import java.sql.Connection;

// import org.example.platzi.model.Employee;
// import org.example.platzi.repository.EmployeeRepository;
// import org.example.platzi.repository.Repository;
// import org.example.platzi.util.DatabaseConnection;
import org.example.platzi.view.SwingApp;

public class Main {
    public static void main(String[] args) {
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

            SwingApp app = new SwingApp();
            app.setVisible(true);

        // } catch (Exception e) {
        //     System.out.println("Algo salio mal...");
        //     e.printStackTrace();
        // }
    }
}
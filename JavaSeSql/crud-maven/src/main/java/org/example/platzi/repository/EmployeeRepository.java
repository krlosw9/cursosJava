package org.example.platzi.repository;

import java.util.List;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import org.example.platzi.model.Employee;
import org.example.platzi.util.DatabaseConnection;

public class EmployeeRepository implements Repository<Employee> {

    // private Connection getConnection() throws SQLException{
    //     return DatabaseConnection.getInstance();
    // }
    // private Connection myConn;
    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getConnection();
    }

    // public EmployeeRepository(Connection myConn) {
    //     this.myConn = myConn;
    // }

    @Override
    public List<Employee> findAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();

        // try (Statement myStamt = getConnection().createStatement();
        try (Connection myConn = getConnection();
            Statement myStamt = myConn.createStatement();
            ResultSet myRes = myStamt.executeQuery("SELECT * FROM employees");) {
            
                while (myRes.next()) {
                    employees.add(createEmployee(myRes));
                }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public Employee getById(Integer id) throws SQLException {
        Employee employee = null;
        String sql = "SELECT * FROM employees WHERE id = ?";

        // try (PreparedStatement myStamt = getConnection().prepareStatement(sql)) {
        try (Connection myConn = getConnection();
            PreparedStatement myStamt = myConn.prepareStatement(sql)) {
            myStamt.setInt(1, id);
            try (ResultSet myRes = myStamt.executeQuery()) {
                if (myRes.next()) {
                    employee = createEmployee(myRes);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return employee;
    }

    @Override
    public void save(Employee employee) throws SQLException {
        String sql = "";
        if (employee.getId() != null && employee.getId() > 0) {
            sql = "UPDATE employees SET first_name=?, pa_surname=?, ma_surname=?, email=?, salary=?, curp=? WHERE id=?";
        }else{
            sql = "INSERT INTO employees (first_name, pa_surname, ma_surname, email, salary, curp) VALUES(?,?,?,?,?,?)";
        }
        // try (PreparedStatement myStamt = getConnection().prepareStatement(sql)) {
        try (Connection myConn = getConnection();
            PreparedStatement myStamt = myConn.prepareStatement(sql)) {
            
            myStamt.setString(1, employee.getFirst_name());
            myStamt.setString(2, employee.getPa_surname());
            myStamt.setString(3, employee.getMa_surname());
            myStamt.setString(4, employee.getEmail());
            myStamt.setFloat(5, employee.getSalary());
            myStamt.setString(6, employee.getCurp());
            if (employee.getId() != null && employee.getId() > 0) {
                myStamt.setInt(7, employee.getId());
            }
            myStamt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id = ?";
        // try (PreparedStatement myStamt = getConnection().prepareStatement(sql)) {
        try (Connection myConn = getConnection();
            PreparedStatement myStamt = myConn.prepareStatement(sql)) {
            myStamt.setInt(1, id);
            myStamt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Employee createEmployee(ResultSet myRes) throws SQLException {
        Employee e = new Employee();
        e.setId(myRes.getInt("id"));
        e.setFirst_name(myRes.getString("first_name"));
        e.setPa_surname(myRes.getString("pa_surname"));
        e.setMa_surname(myRes.getString("ma_surname"));
        e.setEmail(myRes.getString("email"));
        e.setSalary(myRes.getFloat("salary"));
        e.setCurp(myRes.getString("curp"));

        return e;
    }

}

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

import com.mysql.cj.xdevapi.PreparableStatement;

public class EmployeeRepository implements Repository<Employee> {

    private Connection getConnection() throws SQLException{
        return DatabaseConnection.getInstance();
    }

    @Override
    public List<Employee> findAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();

        try (Statement myStamt = getConnection().createStatement();
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

        try (PreparedStatement myStamt = getConnection().prepareStatement(sql)) {
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
    public void save(Employee t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    private Employee createEmployee(ResultSet myRes) throws SQLException {
        Employee e = new Employee();
        e.setId(myRes.getInt("id"));
        e.setFirst_name(myRes.getString("first_name"));
        e.setPa_surname(myRes.getString("pa_surname"));
        e.setMa_surname(myRes.getString("ma_surname"));
        e.setEmail(myRes.getString("email"));
        e.setSalary(myRes.getFloat("salary"));

        return e;
    }

}

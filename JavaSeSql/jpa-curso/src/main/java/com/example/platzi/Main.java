package com.example.platzi;

import java.util.List;

import javax.persistence.EntityManager;

import com.example.platzi.util.UtilEntity;
import com.example.platzi.entity.Employee;

public class Main {
    public static void main(String[] args) {
        EntityManager em = UtilEntity.getEntityManager();
        List<Employee> employees = em.createQuery("SELECT e FROM Employee e",Employee.class).getResultList();
        System.out.println("----Listar empleados----");
        employees.forEach(System.out::println);

        System.out.println("----Buscar un empleado----");
        int employeeId = 3;
        Employee employee = em.find(Employee.class, employeeId);
        System.out.println("Empleado: "+employee);

        /*
        System.out.println("----Registrando empleado----");
        Employee newEmployee = new Employee();
        newEmployee.setFirstName("Diego");
        newEmployee.setPaSurname("Lechuga");
        newEmployee.setMaSurname("Pimentel");
        newEmployee.setEmail("diego@mail.com");
        newEmployee.setSalary((float)19000);

        em.getTransaction().begin();;
        em.persist(newEmployee);
        em.getTransaction().commit();

        System.out.println("Empleado registrado: "+newEmployee);
        
        int employeeToUpdateId = 2;
        System.out.println("----Actualizar empleado: "+employeeToUpdateId+"----");
        Employee employeeToUpdate = em.find(Employee.class, employeeToUpdateId);
        System.out.println("Empleado a modificar: "+employeeToUpdate);

        employeeToUpdate.setFirstName("Irving");
        employeeToUpdate.setPaSurname("Juarez");
        employeeToUpdate.setSalary((float)97000);

        em.getTransaction().begin();
        em.merge(employeeToUpdate);
        em.getTransaction().commit();

        System.out.println("Empleado actualizado: "+employeeToUpdate);
        */
        System.out.println("----Eliminar----");
        int employeeToDeleteId = 1;
        Employee employeeToDelete = em.find(Employee.class, employeeToDeleteId);
        System.out.println("Empleado a eliminar: "+employeeToDelete);

        em.getTransaction().begin();
        em.remove(employeeToDelete);
        em.getTransaction().commit();
        em.close();

    }
}
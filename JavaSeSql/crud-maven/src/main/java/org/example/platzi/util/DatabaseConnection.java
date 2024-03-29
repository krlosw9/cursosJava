package org.example.platzi.util;

import java.sql.Connection;
// import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class DatabaseConnection {
    private static String url = "jdbc:mysql://localhost:3306/project";
    private static String user = "krlos";
    private static String pass = "//654321";
    private static BasicDataSource pool;

    public static BasicDataSource getInstance() throws SQLException{
        if (pool == null) {
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(user);
            pool.setPassword(pass);

            pool.setInitialSize(3);// Tamaño inicial del pool de conexiones.
            pool.setMinIdle(3);// número mínimo de conexiones inactivas que el pool debe mantener en todo momento.
            pool.setMaxIdle(10);// número máximo de conexiones inactivas que el pool puede mantener en todo momento.
            pool.setMaxTotal(10);// número máximo de conexiones totales que el pool puede mantener activas simultáneamente.
            //pool.setMaxWait();// tiempo máximo (en milisegundos) que una solicitud de conexión puede esperar antes de lanzar una excepción por tiempo de espera.
        }
        return pool;
    }

    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }
}

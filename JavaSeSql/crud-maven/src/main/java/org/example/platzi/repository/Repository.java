package org.example.platzi.repository;

import java.util.List;
import java.sql.SQLException;

public interface Repository <T> {

    List<T> findAll() throws SQLException;

    T getById(Integer id) throws SQLException;

    void save(T t) throws SQLException;

    void delete(Integer id) throws SQLException;
}

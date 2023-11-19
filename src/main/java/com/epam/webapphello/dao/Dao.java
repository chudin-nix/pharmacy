package com.epam.webapphello.dao;

import com.epam.webapphello.exception.DaoException;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

//CRUD
public interface Dao<T> {
    Optional<T> getById(Long id);

    List<T> getAll() throws DaoException;

    void save(T item);

    void removeById(Long id);
}

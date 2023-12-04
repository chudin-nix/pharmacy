package com.epam.webapphello.dao;

import com.epam.webapphello.exception.DaoException;

import java.util.List;
import java.util.Optional;

//CRUD
public interface Dao<T> {
    Optional<T> findById(Integer id) throws DaoException;

    List<T> findAll() throws DaoException;

    void save(Optional<T> item) throws DaoException;

    void removeById(Integer id) throws DaoException;
}

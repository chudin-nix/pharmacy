package com.epam.webapphello.dao;

import com.epam.webapphello.entity.User;
import com.epam.webapphello.exception.DaoException;

import java.util.Optional;

public interface UserDao<T> {

    Optional<T> findUserByLoginAndPassword(String login, String password) throws DaoException;
}

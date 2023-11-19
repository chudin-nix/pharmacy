package com.epam.webapphello.service;

import com.epam.webapphello.dao.UserDao;
import com.epam.webapphello.entity.User;
import com.epam.webapphello.exception.DaoException;
import com.epam.webapphello.exception.ServiceException;

import java.util.Optional;


public class SimpleUserService implements UserService{

    private UserDao<User> dao;

    public SimpleUserService(UserDao<User> dao) {
        this.dao = dao;
    }

    public Optional<User> login(String login, String password) throws ServiceException {
        try {
            return dao.findUserByLoginAndPassword(login, password);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }
}
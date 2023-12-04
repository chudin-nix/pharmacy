package com.epam.webapphello.service;

import com.epam.webapphello.dao.UserDao;
import com.epam.webapphello.entity.User;
import com.epam.webapphello.exception.DaoException;
import com.epam.webapphello.exception.ServiceException;

import java.util.Optional;


public class UserServiceImpl implements UserService{

    private UserDao dao;

    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    public Optional<User> login(String login, String password) throws ServiceException {
        try {
            return dao.findUserByLoginAndPassword(login, password);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    @Override
    public Optional<User> findById(Integer userId) throws ServiceException {
        try {
            return dao.findById(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
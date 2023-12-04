package com.epam.webapphello.service;

import com.epam.webapphello.entity.User;
import com.epam.webapphello.exception.ServiceException;

import java.util.Optional;

public interface UserService {
    Optional<User> login(String login, String password) throws ServiceException;

    Optional<User> findById(Integer userId) throws ServiceException;
}
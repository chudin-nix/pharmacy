package com.epam.webapphello.command;

import com.epam.webapphello.exception.DaoException;
import com.epam.webapphello.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException, DaoException;
}
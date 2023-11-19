package com.epam.webapphello.exception;

public class ServiceException extends Exception{
    public ServiceException(DaoException exception) {
        super(exception);
    }
}

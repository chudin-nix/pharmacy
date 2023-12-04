package com.epam.webapphello.exception;

public class ServiceException extends Exception{

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(DaoException exception) {
        super(exception);
    }
}

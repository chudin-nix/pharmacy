package com.epam.webapphello.exception;


public class DaoException extends Exception {

    public DaoException(Exception exception) {
        super(exception);
    }
}

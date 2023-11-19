package com.epam.webapphello.connection;

import com.epam.webapphello.exception.DaoException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection create() throws DaoException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // String url = Config.getInstance().read(Config.DB_CONNECTION_STRING)
            Connection connection = DriverManager.getConnection ("jdbc:mysql://localhost:3306/pharmacy", "root", "root");
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            throw new DaoException(e);
        }
    }
}
package com.epam.webapphello.command;

import com.epam.webapphello.connection.ConnectionPool;
import com.epam.webapphello.dao.OrderDao;
import com.epam.webapphello.entity.User;
import com.epam.webapphello.exception.DaoException;
import com.epam.webapphello.service.*;
import com.epam.webapphello.dao.UserDaoImpl;
import com.epam.webapphello.dao.MedicineDaoImpl;

import java.sql.Connection;


public class CommandFactory {
    public static Command createCommand(String command) throws DaoException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        switch (command) {
            case "login":
                return new LoginCommand(new UserServiceImpl(new UserDaoImpl(connection)), new MedicineServiceImpl(new MedicineDaoImpl(connection)));
            case "medicinePage":
                return new MedicinePageCommand(new MedicineServiceImpl(new MedicineDaoImpl(connection)));
            case "buyMedicine":
                return new OrderCommand(new OrderServiceImpl(new OrderDao(connection), new UserDaoImpl(connection)), new MedicineServiceImpl(new MedicineDaoImpl(connection)), new UserServiceImpl(new UserDaoImpl(connection)));
            default:
                throw new IllegalArgumentException("Unknown command " + command);
        }
    }
}
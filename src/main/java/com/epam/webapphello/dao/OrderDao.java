package com.epam.webapphello.dao;

import com.epam.webapphello.entity.Order;
import com.epam.webapphello.exception.DaoException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDao extends AbstractDao<Order>{

    public OrderDao(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return "order";
    }


    @Override
    protected Order map(ResultSet resultSet) throws SQLException {
        return null;
    }

    public void save(Order order) throws DaoException {
        executeUpdate("INSERT INTO...", order.getMedicineId());
    }
}

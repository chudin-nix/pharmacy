package com.epam.webapphello.dao;

import com.epam.webapphello.connection.ConnectionPool;
import com.epam.webapphello.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<Type> {
    protected abstract Type map(ResultSet resultSet) throws SQLException;

    protected List<Type> executeQuery(String query, List<Object> params) throws DaoException {
        List<Type> elements = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            for (int i = 1; i <= params.size() ; i++) {
                statement.setObject(i, params.get(i-1));
            }
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Type element = map(resultSet);
                elements.add(element);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return elements;
    }

    protected Optional<Type> executeQueryForSingleResult(String query, List<Object> params) throws DaoException {
        List<Type> elements = executeQuery(query, params);
        return elements.isEmpty() ? Optional.empty() : Optional.of(elements.get(0));
    }

    protected List<Type> findAll(String tableName) throws DaoException {
        //вот пустой список параметров, не совсем уверен, что это верно
        List<Object> params = new ArrayList<>();
        String query = "SELECT * FROM " + tableName;
        return executeQuery(query, params);
    }

    protected Type findById(String tableName, int id) throws DaoException {
        String query = "SELECT * FROM " + tableName + " WHERE id = " + id;
        List<Object> params = new ArrayList<>();
        params.add(id);
        List<Type> result = executeQuery(query, params);
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
    }
}

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
    private Connection connection;
    protected abstract Type map(ResultSet resultSet) throws SQLException;


    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

    protected List<Type> executeQuery(String query, List<Object> params) throws DaoException {
        List<Type> elements = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
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

    protected void executeUpdate(String query, List<Object> params) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            for (int i = 1; i <= params.size() ; i++) {
                statement.setObject(i, params.get(i-1));
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
    protected Optional<Type> executeQueryForSingleResult(String query, List<Object> params) throws DaoException {
        List<Type> elements = executeQuery(query, params);
        return elements.isEmpty() ? Optional.empty() : Optional.of(elements.get(0));
    }

    public List<Type> findAll() throws DaoException {
        //вот пустой список параметров, не совсем уверен, что это верно
        List<Object> params = new ArrayList<>();
        String query = "SELECT * FROM " + getTableName();
        return executeQuery(query, params);
    }

    public Optional<Type> findById(Integer id) throws DaoException {
        String query = "SELECT * FROM " + getTableName() + " WHERE id = " + id;
        List<Object> params = new ArrayList<>();
        params.add(id);
        List<Type> result = executeQuery(query, params);
        if (result.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(result.get(0));
        }
    }

    public void removeById(Integer id) {

    }
    protected abstract String getTableName();


//    private String generateInsertQuery( Map<String, Object> fields) {
//        throw new UnsupportedOperationException();
//    }
//
//    private String generateUpdateQuery( Map<String, Object> fields) {
//        throw new UnsupportedOperationException();
//    }

//    @Override
//    public void save(Type item) {
//        Map<String, Object> fields = getFields(item);
//        String query = item.getId() == null ? generateInsertQuery(fields) : generateUpdateQuery(fields);
//        executeUpdate(query);
//        if (item.getId() = null) {
//            //insert
//        } else {
//            //update
//        }
//    }
}

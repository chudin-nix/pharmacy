package com.epam.webapphello.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Optional;

import com.epam.webapphello.entity.User;
import com.epam.webapphello.exception.DaoException;



public class SimpleUserDao extends AbstractDao<User> implements UserDao<User> {

    public Optional<User> findUserByLoginAndPassword(final String login, final String password) throws DaoException {
        return executeQueryForSingleResult("SELECT ID, LOGIN FROM USER WHERE LOGIN = ? AND PASSWORD = MD5(?)",
                Arrays.asList(login, password));
}

    public User map(ResultSet resultSet) throws SQLException {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setLogin(resultSet.getString("login"));
            return user;
    }
}
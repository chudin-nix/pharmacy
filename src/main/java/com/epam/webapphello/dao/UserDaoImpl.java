package com.epam.webapphello.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.epam.webapphello.entity.User;
import com.epam.webapphello.exception.DaoException;



public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

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

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Optional<User> item) throws DaoException {

    }

    @Override
    protected String getTableName() {
        return "user";
    }

}
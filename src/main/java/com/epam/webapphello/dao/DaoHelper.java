//package com.epam.webapphello.dao;
//
//import com.epam.webapphello.connection.ConnectionPool;
//import com.epam.webapphello.connection.ProxyConnection;
//import com.epam.webapphello.exception.DaoException;
//
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//public class DaoHelper implements AutoCloseable{
//
//    private ProxyConnection connection;
//
//    public DaoHelper (ConnectionPool pool) {
//        this.connection = pool.getConnection();
//    }
//
//    public UserDao createUserDao() {
//        return new UserDaoImpl(connection);
//    }
//
//    // public OverDao createUserDao(){
//    //  return new OrderDaoImpl(connection)
//    // }
//
//    @Override
//    public void close() {
//        try {
//            connection.close();
//        } catch (SQLException e) {
//            throw new DaoException(e);
//        }
//    }
//
//    public void startTransaction() throws DaoException {
//        try {
//            connection.setAutoCommit(true);
//        } catch (SQLException exception) {
//            throw new DaoException(exception);
//        }
//    }
//
//    public void endTransaction() throws DaoException {
//        try {
//            connection.commit();
//            connection.setAutoCommit(true);
//        } catch (SQLException exception) {
//            throw new DaoException(exception);
//        }
//    }
//}

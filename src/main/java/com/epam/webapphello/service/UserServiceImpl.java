//package com.epam.webapphello.service;
//
//import com.epam.webapphello.dao.DaoHelper;
//import com.epam.webapphello.dao.DaoHelperFactory;
//import com.epam.webapphello.dao.UserDao;
//import com.epam.webapphello.entity.User;
//import com.epam.webapphello.exception.DaoException;
//import com.epam.webapphello.exception.ServiceException;
//
//import java.util.Optional;
//
//
//public class UserServiceImpl implements UserService {
//
//    private DaoHelperFactory daoHelperFactory;
//
//    public UserServiceImpl(DaoHelperFactory daoHelperFactory) {
//        this.daoHelperFactory = daoHelperFactory;
//    }
//
//    public Optional<User> login(String login, String password) throws ServiceException {
//        try (DaoHelper helper = daoHelperFactory.create()) {
//            helper.startTransaction();
//            UserDao dao = helper.createUserDao();
//            Optional<User> user = dao.findUserByLoginAndPassword(login, password);
//            return user;
//        } catch (DaoException exception) {
//            throw new ServiceException(exception);
//        }
//    }
//}

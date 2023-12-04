package com.epam.webapphello.service;

import com.epam.webapphello.dao.MedicineDao;
import com.epam.webapphello.dao.OrderDao;
import com.epam.webapphello.dao.UserDao;
import com.epam.webapphello.entity.Order;
import com.epam.webapphello.entity.User;
import com.epam.webapphello.exception.DaoException;
import com.epam.webapphello.exception.ServiceException;

import java.util.Optional;

public class OrderServiceImpl implements OrderService{

    private UserDao userDao;
    private OrderDao orderDao;
    public OrderServiceImpl(OrderDao orderDao, UserDao userDao) {
        this.orderDao = orderDao;
        this.userDao = userDao;
    }

    @Override
    public Integer order(Integer userId, Integer medicineId, Integer count) throws ServiceException {
        try {//Открыть транзакцию
        //Проверить что достаточно денег на счету пользователя
        //Списать деньги
        //Сохранить запись в таблицу ордер
        //Закрыть транзакцию
        Optional<User> user = userDao.findById(userId);
        //user.setBallance(user.getBallance()-medicinePrice * count);
        userDao.save(user);
        Order order = new Order();
        orderDao.save(order);
        //Тут надо тоже дописать и не возвращать nul
        return null;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}

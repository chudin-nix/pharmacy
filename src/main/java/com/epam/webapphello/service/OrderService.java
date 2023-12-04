package com.epam.webapphello.service;

import com.epam.webapphello.exception.ServiceException;

public interface OrderService {
    Integer order(Integer userId, Integer medicineId, Integer count) throws ServiceException;
}

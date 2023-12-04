package com.epam.webapphello.service;

import com.epam.webapphello.entity.Medicine;
import com.epam.webapphello.exception.DaoException;
import com.epam.webapphello.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface MedicineService {
    Optional<Medicine> findById(Integer id) throws ServiceException;

    List<Medicine> findAll() throws ServiceException;
}